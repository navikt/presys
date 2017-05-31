package no.nav.pensjon.dsf.ebcdic;

import no.nav.pensjon.presys.utils.ebcdic.EbcdicUtils;
import no.nav.pensjon.presys.utils.ebcdic.Meta;
import no.nav.pensjon.presys.utils.ebcdic.ScrollableArray;
import no.nav.pensjon.presys.utils.ebcdic.AnnotationMapper;

import java.io.*;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;


public class SplitPerson {

    private static final String SEARCH_STRING = new String("RF0PERSN"); //Segmentet det skal splittes på
    private static final int START_SKIP = 1924; //I TEST3 er de første 1924 tegnene tull
    private static final String DEFAULT_RESORCE_LOCATION = "TEST3";

    public static void main(String [] args) throws Exception {
        File mappe = new File("server/src/main/resources/database");
        File fil = new File("C:\\data\\dsf-web\\TEST3");
        splitFilOgSkrivTilMappe(fil, mappe);
    }


    public static void splitFilOgSkrivTilMappe(File innFil, File utMappe) throws Exception {
        utMappe.mkdir();
        AtomicInteger integer = new AtomicInteger();
        RequestObject req = new RequestObject();
        req.writer = (data) -> {
            DataOutputStream osFil = null;
            try {
                if(integer.incrementAndGet()% 100000 == 0){
                  System.out.println("Fremdrift:" + integer.get());
                }

                try {
                    String fnr = EbcdicUtils.deCompress(Arrays.copyOfRange(data.getData(), 6 + 29, 6 + 29 + 6), 11, 0).toString();
                    fnr = "00000000000".substring(fnr.length()) + fnr;
                    osFil = new DataOutputStream(new FileOutputStream(utMappe.getAbsolutePath() + "/" + fnr + ".txt"));
                }catch(NumberFormatException e){
                    osFil = new DataOutputStream(new FileOutputStream(utMappe.getAbsolutePath() + "/feilsegmen_" + integer.get() + ".txt"));
                }
                osFil.write(data.getData());
                osFil.close();

            } catch (Exception  e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        };
        req.reader = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(innFil)));
        req.maksAntall = 20;
        ResponseObject res = split(req);
        System.out.println("Fant " + res.getAntall() + " segmenter");
    }


    public static ResponseObject split(RequestObject req) throws Exception {
        ResponseObject res = new ResponseObject();
        skip(req);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] metaBytes = new byte[Meta.META_SIZE];
        try {
            while (res.antall < req.maksAntall) {
                req.reader.readFully(metaBytes);
                Meta meta = AnnotationMapper.mapData(metaBytes, Meta.class);
                if (meta.getSegmentNavn().equals(SEARCH_STRING)) {
                    if (bos.size() > 0) {
                        req.writer.accept(new ScrollableArray(bos.toByteArray()));
                        res.antall++;
                        bos.reset();
                    }
                }
                bos.write(metaBytes);
                byte[] data = new byte[meta.getDatalengde() + 1];
                req.reader.readFully(data);
                bos.write(data);

            }
        }catch(EOFException ex){
            if (bos.size() > 0) {
                req.writer.accept(new ScrollableArray(bos.toByteArray()));
                res.antall++;
                bos.reset();
            }
        }
        return res;
    }

    private static void skip(RequestObject req) throws IOException {
        long leftToSkip = req.bytesToSkip;
        while(leftToSkip > Integer.MAX_VALUE){
            req.reader.skipBytes(Integer.MAX_VALUE);
            leftToSkip -= Integer.MAX_VALUE;
        }
        req.reader.skipBytes((int)leftToSkip);
    }

    public static class RequestObject{
        private Consumer<ScrollableArray> writer;
        private DataInputStream reader;
        private int maksAntall;
        private long bytesToSkip;

        public RequestObject(){
            this((a) ->{}, new DataInputStream(SplitPerson.class.getClassLoader().getResourceAsStream(DEFAULT_RESORCE_LOCATION)),  10, START_SKIP);
        }

        public RequestObject(Consumer<ScrollableArray> writer, DataInputStream reader) {
            this(writer, reader, 10, START_SKIP);
        }

        public RequestObject(Consumer<ScrollableArray> writer, DataInputStream reader, int maksAntall, int bytesToSkip) {
            this.writer = writer;
            this.reader = reader;
            this.maksAntall = maksAntall;
            this.bytesToSkip = bytesToSkip;
        }

        public void setWriter(Consumer<ScrollableArray> writer) {
            this.writer = writer;
        }

        public void setReader(DataInputStream reader) {
            this.reader = reader;
        }

        public void setMaksAntall(int maksAntall) {
            this.maksAntall = maksAntall;
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
