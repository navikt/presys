package no.nav.pensjon.dsf.ebcdic;

import no.nav.pensjon.dsf.web.EbcdicReader;

import java.io.*;
import java.util.Arrays;
import java.util.Base64;

import static no.nav.pensjon.dsf.ebcdic.EbcdicUtils.EBCDIC_CHARSET;

/**
 * Created by d132988 on 18.04.2017.
 */
public class SplitPerson {

    public static void main(String[]args) throws IOException {
        split();
    }

    public static void split() throws IOException {
        DataInputStream is = new DataInputStream(EbcdicReader.class.getClassLoader().getResourceAsStream("TEST3"));
        String seearchString = new String("RF0PERSN");

        byte [] pattern = seearchString.getBytes(EBCDIC_CHARSET);
        byte [] value = EbcdicUtils.read(is, 500000);
        File mappe = new File("src/main/resources/database");
        mappe.mkdir();
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

            DataOutputStream osFil = new DataOutputStream(new FileOutputStream(mappe.getAbsolutePath() + "/" +EbcdicUtils.deCompress(Arrays.copyOfRange(value, segmentStart+6+29, segmentStart+6+29+6),11,0).toString() + ".txt"));
            osFil.write(Arrays.copyOfRange(value, segmentStart, i-6));
            osFil.close();
            /*System.out.print(EbcdicUtils.deCompress(Arrays.copyOfRange(value, segmentStart+6+29, segmentStart+6+29+6),11,0));
            System.out.print(":" +Arrays.copyOfRange(value, segmentStart, i-6).length + ":" );
            System.out.print(":" +Base64.getEncoder().encode(Arrays.copyOfRange(value, segmentStart, i-6)).length +":" );
            System.out.println(new String(Base64.getEncoder().encode(Arrays.copyOfRange(value, segmentStart, i-6))));*/
            segmentStart = i-6;

        }
        System.out.println("Fant " + antall + " personer");
    }
}
