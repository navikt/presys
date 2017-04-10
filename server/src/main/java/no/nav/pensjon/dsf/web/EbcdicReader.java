package no.nav.pensjon.dsf.web;

import com.ibm.as400.access.AS400PackedDecimal;

import java.io.*;
import java.math.BigDecimal;

/**
 * Created by d132988 on 05.04.2017.
 */
public class EbcdicReader {


    public static void main(String [] args) throws IOException {
        EbcdicReader er = new EbcdicReader();

        //er.compress(1983);
        DataInputStream is = new DataInputStream(EbcdicReader.class.getClassLoader().getResourceAsStream("TEST3"));
        //DataInputStream is = new DataInputStream(EbcdicReader.class.getClassLoader().getResourceAsStream("rfdbhex.txt"));
        DataInputStream isPinntekt = new DataInputStream(EbcdicReader.class.getClassLoader().getResourceAsStream("pinntekt.txt"));
        DataOutputStream os = new DataOutputStream(System.out);
        DataOutputStream osFil = new DataOutputStream(new FileOutputStream("pinntekt.txt"));

        //er.read(is,102);

       // byte[] test = {1, -104, 63};

        //er.deCompress(test);


            byte[] start = er.read(isPinntekt, 6);
            byte[] segmentNavn = er.read(isPinntekt, 8);
            er.read(isPinntekt, 19);
            byte[] ukjent1 = er.read(isPinntekt, 2);
            byte[] pi_aar = er.read(isPinntekt, 3);
            byte[] pi_type = er.read(isPinntekt, 1);
            byte[] ukjent2 = er.read(isPinntekt, 6);
            byte[] kommune = er.read(isPinntekt, 3);
            byte[] rappdato = er.read(isPinntekt, 4);
            byte[] reserve = er.read(isPinntekt, 4);

           /* while ((value = er.read(isPinntekt, 1)) != null) {
                er.writePlus(value[0], os);
            }
            */
           String aar = "";
            for (byte b : pi_aar){
               // er.writePlus(b, os);
                aar += String.format("%02X", b);
                //System.out.print( String.format("%02X", b).substring() /*+ ":" + value */);
            }

            System.out.println(Integer.parseInt(aar.substring(0, 5)));



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
        out.write(value);
        int unsignedByte = value & 0xFF;
        System.out.print(":" + String.format("%02X ", value) /*+ ":" + value */+ "\n");


    }

    public void deCompress(byte[] packed){
        //if (re.isErKomprimert()) {
        AS400PackedDecimal packedDecimal = new AS400PackedDecimal(5, 0);
        double d = packedDecimal.toDouble(packed);
        //BigDecimal komprimertEntry = (BigDecimal) packedDecimal.toObject(packed);

        System.out.println(d);
        // } else {
        //     entryValue = new String(recordEntryBytes, "Cp1047");
        // }
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