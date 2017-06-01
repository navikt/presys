package no.nav.pensjon.dsf.ebcdic;

import no.nav.pensjon.dsf.domene.Person;
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
    public static final int START_SKIP = 1924; //I TEST3 er de første 1924 tegnene tull

    public static void main(String [] args) throws Exception {
        File mappe = new File("server/src/main/resources/database");
        File fil = new File("C:\\data\\dsf-web\\TEST3");
        splitFilOgSkrivTilMappe(fil, mappe);
    }


    public static void splitFilOgSkrivTilMappe(File innFil, File utMappe) throws Exception {
        utMappe.mkdir();
        AtomicInteger integer = new AtomicInteger();

        Consumer<ScrollableArray> writer = (data) -> {
            DataOutputStream osFil = null;
            try {
                if(integer.incrementAndGet()% 100000 == 0){
                  System.out.println("Fremdrift:" + integer.get());
                }

                try {
                    String fnr = EbcdicUtils.unpack(Arrays.copyOfRange(data.getData(), Meta.META_SIZE, Meta.META_SIZE + 6), 11, 0).toString();
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

        DataInputStream reader = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(innFil)));
        int maksAntall = 20;
        int antallLest = split(reader, writer, maksAntall, START_SKIP );

        System.out.println("Fant " + antallLest + " segmenter");
    }


    public static int split(DataInputStream reader, Consumer<ScrollableArray> writer, int maksAntall, long bytesToSkip) throws Exception {
        int antall = 0;
        skip(reader, bytesToSkip);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] metaBytes = new byte[Meta.META_SIZE];
        try {
            while (antall < maksAntall) {
                reader.readFully(metaBytes);
                Meta meta = AnnotationMapper.mapData(metaBytes, Meta.class);
                if (meta.getSegmentNavn().equals(SEARCH_STRING)) {
                    if (bos.size() > 0) {
                        writer.accept(new ScrollableArray(bos.toByteArray()));
                        antall++;
                        bos.reset();
                    }
                }
                bos.write(metaBytes);
                byte[] data = new byte[meta.getDatalengde() + 1];
                reader.readFully(data);
                bos.write(data);

            }
        }catch(EOFException ex){
            if (bos.size() > 0) {
                writer.accept(new ScrollableArray(bos.toByteArray()));
                antall++;
                bos.reset();
            }
        }
        return antall;
    }

    private static void skip(DataInputStream reader, long bytesToSkip) throws IOException {
        long leftToSkip = bytesToSkip;
        while(leftToSkip > Integer.MAX_VALUE){
            reader.skipBytes(Integer.MAX_VALUE);
            leftToSkip -= Integer.MAX_VALUE;
        }
        reader.skipBytes((int)leftToSkip);
    }
}
