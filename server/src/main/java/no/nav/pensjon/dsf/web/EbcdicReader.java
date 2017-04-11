package no.nav.pensjon.dsf.web;

import com.ibm.as400.access.AS400PackedDecimal;
import no.nav.pensjon.dsf.ebcdic.segmenter.Inntekt;
import no.nav.pensjon.dsf.ebcdic.segmenter.PinntektSegment;
import no.nav.pensjon.dsf.ebcdic.segmenter.Segment;

import java.io.*;
import java.math.BigDecimal;

/**
 * Created by d132988 on 05.04.2017.
 */
public class EbcdicReader {

    public static void main2(String[] args) throws IOException {
        DataInputStream is = new DataInputStream(EbcdicReader.class.getClassLoader().getResourceAsStream("TEST3"));
        DataOutputStream os = new DataOutputStream(System.out);
        EbcdicReader er = new EbcdicReader();

        //String seearchString = new String("SOLBAKKEN BRITT ANITA    ");


        int [] pattern = {0x07, 0x11, 0x66, 0x45, 0x42, 0x9C};//, 0x9C};
        //pattern = seearchString.getBytes("Cp1047");
        byte [] value = er.read(is, 2600);
        forvalue:
        for (int i = 0; i < value.length-pattern.length; i++){
            for(int j = 0; j<pattern.length;j++){
                if((value[j+i]&0xFF) != pattern[j] ){
                //if(value[j+i] != pattern[j] ){
                continue forvalue;
                }
            }
            System.out.println(i);


            for(int s = i + pattern.length; s < i + 20; s++)
            er.writePlus(value[s], os);
            break;
        }
    }


    public static void main(String [] args) throws IOException {
        EbcdicReader er = new EbcdicReader();

        DataInputStream is = new DataInputStream(EbcdicReader.class.getClassLoader().getResourceAsStream("TEST3"));
        //DataInputStream is = new DataInputStream(EbcdicReader.class.getClassLoader().getResourceAsStream("rfdbhex.txt"));
        DataInputStream isPinntekt = new DataInputStream(EbcdicReader.class.getClassLoader().getResourceAsStream("pinntekt.txt"));
        DataOutputStream os = new DataOutputStream(System.out);
        DataOutputStream osFil = new DataOutputStream(new FileOutputStream("pinntekt.txt"));

        //er.read(is,102);

       // byte[] test = {1, -104, 63};

        //er.deCompress(test);

            Segment<Inntekt> inntektssegment = new PinntektSegment();
            byte[] file = new byte[56];
            isPinntekt.readFully(file);
            Inntekt inntekt = inntektssegment.readSegment(file);
            System.out.println();

        
//            byte[] start = er.read(isPinntekt, 6);
//            byte[] segmentNavn = er.read(isPinntekt, 8);
//            byte[] mellomrom = er.read(isPinntekt, 19);
//            byte[] ukjent1 = er.read(isPinntekt, 2);
//            byte[] pi_aar = er.read(isPinntekt, 3);
//            byte[] pi_type = er.read(isPinntekt, 1);
//            byte[] pi_merke = er.read(isPinntekt, 1);
//            byte[] pi = er.read(isPinntekt, 5);
//            byte[] kommune = er.read(isPinntekt, 3);
//            byte[] rappdato = er.read(isPinntekt, 4);
//            byte[] reserve = er.read(isPinntekt, 4);



           /* while ((value = er.read(isPinntekt, 1)) != null) {
                er.writePlus(value[0], os);
            }

            */

//           String aar = "";
//            for (byte b : pi_aar){
//               // er.writePlus(b, os);
//                aar += String.format("%02X", b);
//                //System.out.print( String.format("%02X", b).substring() /*+ ":" + value */);
//            }
//
//            System.out.println(Integer.parseInt(aar.substring(0, 5)));
//            System.out.println(Integer.parseInt(aar.substring(0, 5)));
//
//
//            System.out.println(new String(segmentNavn));
//            System.out.println(new String(segmentNavn, "Cp1047"));
//
//            System.out.println(er.deCompress(pi_aar, 5));
//            System.out.println(er.deCompress(kommune, 5));
//            System.out.println(er.deCompress(rappdato, 7));
//
//
//




/*
        for (int i = 0 ; i< 10000; i++){
            byte[] value = er.read(is,1);
            if ((value[0] & 0xFF) == 0xE2 ){
                byte o = er.read(is,1)[0];
                i++;
                if((o & 0xFF) == 0xD6) {
                    System.out.print(i + ":");
                    er.writePlus(value[0], os);
                    er.writePlus(o, os);
                    er.writePlus(er.read(is, 1)[0], os);
                    er.writePlus(er.read(is, 1)[0], os);
                    er.writePlus(er.read(is, 1)[0], os);
                    i += 3;
                }
            }
        }

*/
        //er.deCompress(value);

        //for(int i = 0; i<32; i++){
        //    value = er.read(is,1);
        //    er.write(value, new DataOutputStream(System.out));
        //}



    }


    public byte[] read(DataInput data, int length) throws IOException {
        byte[] kdgex = new byte[length];
        data.readFully(kdgex);
        return kdgex;
    }

    public void write(byte[] value, DataOutput out) throws IOException {
        out.write(value);
        System.out.print("\n");


    }

    public void writePlus(byte value, DataOutput out) throws IOException {
        byte stringbytes[] = {value};
        out.write(new String(stringbytes, "Cp1047").getBytes("UTF-8"));
        int unsignedByte = value & 0xFF;
        System.out.print(":" + String.format("%02X ", value) /*+ ":" + value */+ "\n");


    }

    public String deCompress(byte[] packed, int length){
        BigDecimal komprimertEntry = (BigDecimal) new AS400PackedDecimal(length, 0).toObject(packed);
        return komprimertEntry.toString();
    }

    public void compress(double unpacked) throws IOException {
        //if (re.isErKomprimert()) {
        AS400PackedDecimal packedDecimal = new AS400PackedDecimal(5, 0);
        for (byte b : packedDecimal.toBytes(unpacked))
            writePlus(b, new DataOutputStream(System.out));
        // } else {
        //     entryValue = new String(recordEntryBytes, "Cp1047");
        // }
    }
}