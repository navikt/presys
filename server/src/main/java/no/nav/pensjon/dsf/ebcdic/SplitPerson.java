package no.nav.pensjon.dsf.ebcdic;

import java.io.*;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;

import static no.nav.pensjon.dsf.ebcdic.EbcdicUtils.EBCDIC_CHARSET;


public class SplitPerson {

    private static final int BUFFER_SIZE = 100;
    private static final String SEARCH_STRING = new String("RF0PERSN"); //Segmentet det skal splittes på
    private static final int SEPERATOR_OFFSET = 6; //Kolonne som alle segmentene starter med, før segmentnavnet
    private static final int START_SKIP = 1924; //I TEST3 er de første 1924 tegnene tull
    private static final String DEFAULT_RESORCE_LOCATION = "TEST3";


    public static void main(String[]args) throws IOException {
        File mappe = new File("server/src/main/resources/database");
        mappe.mkdir();
        AtomicInteger integer = new AtomicInteger();
        RequestObject req = new RequestObject();
        req.writer = (data, position) -> {
            DataOutputStream osFil = null;
            System.out.println("Fant segment på posisjon " + position);
            try {
                String fnr = "";
                try {
                    fnr = EbcdicUtils.deCompress(Arrays.copyOfRange(data.getData(), 6 + 29, 6 + 29 + 6), 11, 0).toString();
                    fnr = "00000000000".substring(fnr.length()) + fnr;
                }catch(NumberFormatException e){
                    fnr += integer.incrementAndGet();
                }
                osFil = new DataOutputStream(new FileOutputStream(mappe.getAbsolutePath() + "/" + fnr + ".txt"));

                osFil.write(data.getData());
                osFil.close();
            } catch (Exception  e) {
                e.printStackTrace();
            }
        };
        ResponseObject res = split(req);
        System.out.println("Fant " + res.getAntall() + " segmenter");
    }


    public static ResponseObject split(RequestObject req) throws IOException {
        ResponseObject res = new ResponseObject();
            byte[] pattern = SEARCH_STRING.getBytes(EBCDIC_CHARSET);
            int navneLength = SEPERATOR_OFFSET + pattern.length;
            byte[] value = new byte[req.bufferSize];
            int bufferSize = 0;
            req.reader.skipBytes(req.bytesToSkip);
            long bytesLest = req.bytesToSkip;
            ByteArrayOutputStream bos = new ByteArrayOutputStream();

            long prevSegStart = bytesLest;

            while (res.antall < req.maksAntall) {
                {
                    int antallLest = req.reader.read(value, bufferSize, value.length - bufferSize);
                    bufferSize += antallLest;
                    bytesLest += antallLest;
                }
                int pointer = 0;
                readBuffer:
                for (int i = 0; i < bufferSize - navneLength; i++) {
                    if (!match(value, i, bufferSize, pattern)) {
                        continue readBuffer;
                    }

                    int segmentStart = i < SEPERATOR_OFFSET ? 0 : i - SEPERATOR_OFFSET;
                    bos.write(value, 0, segmentStart);
                    pointer += segmentStart;

                    byte[] segmentRest = bos.toByteArray();

                    if (segmentRest.length > 0) {
                        req.writer.accept(new ScrollableArray(bos.toByteArray()), prevSegStart);
                        res.antall++;
                        bos.reset();
                    }

                    prevSegStart = bytesLest - bufferSize + segmentStart;
                    bos.write(value, segmentStart, navneLength);
                    pointer += navneLength;

                    break readBuffer;
                }

                if (pointer == 0) { //fant ingen segmentstart
                    if (bufferSize == value.length) {
                        pointer += write(value, bos, bufferSize - navneLength);
                    } else { //Alt er lest inn
                        write(value, bos, bufferSize - navneLength);
                        req.writer.accept(new ScrollableArray(bos.toByteArray()), prevSegStart);
                        res.antall++;
                        break;
                    }
                }

                leftShift(value, pointer);
                bufferSize = bufferSize - pointer;

            }

        return res;
    }

    static int write(byte[] value, ByteArrayOutputStream os, int length){
        os.write(value, 0, length);
        return length;
    }

    static boolean match(byte[]data, int start, int size, byte[]pattern){
        for(int i = 0; i < pattern.length && i + start < size;i++){
            if(data[i+start] != pattern[i] ){
                return false;
            }
        }
        return true;
    }

    static void leftShift(byte [] data, int offset){
        for(int i = 0; i+offset < data.length; i++){
            data[i] = data[i+offset];
        }
    }

    public static class RequestObject{
        private BiConsumer<ScrollableArray, Long> writer;
        private DataInputStream reader;
        private int maksAntall;
        private int bufferSize;
        private int bytesToSkip;

        public RequestObject(){
            this((a,l) ->{}, new DataInputStream(SplitPerson.class.getClassLoader().getResourceAsStream(DEFAULT_RESORCE_LOCATION)),  10, BUFFER_SIZE, START_SKIP);
        }

        public RequestObject(BiConsumer<ScrollableArray, Long> writer, DataInputStream reader) {
            this(writer, reader, 10, BUFFER_SIZE, START_SKIP);
        }

        public RequestObject(BiConsumer<ScrollableArray, Long> writer, DataInputStream reader, int maksAntall, int bufferSize, int bytesToSkip) {
            this.writer = writer;
            this.reader = reader;
            this.maksAntall = maksAntall;
            this.bufferSize = bufferSize;
            this.bytesToSkip = bytesToSkip;
        }

        public void setWriter(BiConsumer<ScrollableArray, Long> writer) {
            this.writer = writer;
        }

        public void setReader(DataInputStream reader) {
            this.reader = reader;
        }

        public void setMaksAntall(int maksAntall) {
            this.maksAntall = maksAntall;
        }

        public void setBufferSize(int bufferSize) {
            this.bufferSize = bufferSize;
        }

        public void setBytesToSkip(int bytesToSkip) {
            this.bytesToSkip = bytesToSkip;
        }
    }

    public static class ResponseObject{
        private int antall = 0;

        public int getAntall(){
            return antall;
        }

    }

}
