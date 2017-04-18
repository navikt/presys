package no.nav.pensjon.dsf.ebcdic;

import no.nav.pensjon.dsf.web.EbcdicReader;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by d132988 on 18.04.2017.
 */
public class SplitPerson {

    public static void split() throws IOException {
        EbcdicReader er = new EbcdicReader();

        DataInputStream is = new DataInputStream(EbcdicReader.class.getClassLoader().getResourceAsStream("TEST3"));
        DataOutputStream os = new DataOutputStream(System.out);

        String seearchString = new String("RF0PERSN");


        byte [] pattern = seearchString.getBytes("Cp1047");
        byte [] value = EbcdicUtils.read(is, 20000);

        int segmentStart = 0;
        int skip = 2;
        forvalue:
        for (int i = 0; i < value.length-pattern.length; i++){
            for(int j = 0; j<pattern.length;j++){
                //if((value[j+i]&0xFF) != pattern[j] ){
                if(value[j+i] != pattern[j] ){
                    continue forvalue;
                }
            }

            if(skip>0){
                segmentStart = i-6;
                skip--;
                continue;
            }

            DataOutputStream osFil = new DataOutputStream(new FileOutputStream(EbcdicUtils.deCompress(Arrays.copyOfRange(value, segmentStart+6+29, segmentStart+6+29+6),11,0).toString() + ".txt"));
            osFil.write(Arrays.copyOfRange(value, segmentStart, i-6));
            osFil.close();
            System.out.print(new String(Arrays.copyOfRange(value, segmentStart+6, segmentStart+6+8), "Cp1047"));
            System.out.print(" ");
            System.out.print(EbcdicUtils.deCompress(Arrays.copyOfRange(value, segmentStart+6+29, segmentStart+6+29+6),11,0));
            System.out.print(" ");
            System.out.print(new String(Arrays.copyOfRange(value, segmentStart+6+35, segmentStart+6+35+25), "Cp1142"));
            //System.out.println(new String(Arrays.copyOfRange(value, segmentStart+8, i), "UTF-8"));
            System.out.print("\n");
            segmentStart = i-6;


            // break;
        }


    }
}
