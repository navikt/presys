package no.nav.pensjon.dsf.ebcdic;

import no.nav.pensjon.dsf.web.EbcdicReader;

import java.io.*;
import java.util.Arrays;
import java.util.function.Consumer;

import static no.nav.pensjon.dsf.ebcdic.EbcdicUtils.EBCDIC_CHARSET;

/**
 * Created by d132988 on 18.04.2017.
 */
public class SplitPerson {

    public static void main(String[]args) throws IOException {
        File mappe = new File("src/main/resources/database");
        mappe.mkdir();
        Consumer<ScrollableArray>  fileWriter = data ->{
            DataOutputStream osFil = null;
            try {
                osFil = new DataOutputStream(new FileOutputStream(mappe.getAbsolutePath() + "/" + EbcdicUtils.deCompress(Arrays.copyOfRange(data.getData(), 6+29, 6+29+6),11,0).toString() + ".txt"));
                osFil.write(data.getData());
                osFil.close();
            } catch (IOException  e) {
                e.printStackTrace();
            }
        } ;

        split(fileWriter);
    }

    public static void split(Consumer<ScrollableArray> writer) throws IOException {
        DataInputStream is = new DataInputStream(EbcdicReader.class.getClassLoader().getResourceAsStream("TEST3"));
        String seearchString = new String("RF0PERSN");
        byte [] pattern = seearchString.getBytes(EBCDIC_CHARSET);
        byte [] value = EbcdicUtils.read(is, 40000);
        int segmentStart = 0;
        int antall = -2;
        forvalue:
        for (int i = 0; i < value.length-pattern.length; i++){
            for(int j = 0; j<pattern.length;j++){
                if(value[j+i] != pattern[j] ){
                    continue forvalue;
                }
            }
            antall++;
            if(antall<=0){
                segmentStart = i-6;
                continue;
            }
            writer.accept(new ScrollableArray(Arrays.copyOfRange(value, segmentStart, i-6)));
            segmentStart = i-6;
        }
    }
}
