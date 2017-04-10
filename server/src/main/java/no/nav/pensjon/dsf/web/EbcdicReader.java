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
        //DataInputStream is = new DataInputStream(EbcdicReader.class.getClassLoader().getResourceAsStream("RFDB"));
        DataInputStream is = new DataInputStream(EbcdicReader.class.getClassLoader().getResourceAsStream("rfdbhex.txt"));
        DataOutputStream os = new DataOutputStream(System.out);

        //er.read(is,102);

       // byte[] test = {1, -104, 63};

        //er.deCompress(test);

        byte[] value = er.read(is,9);
        value = er.read(is,8);
        er.write(value, os);

        value = er.read(is,22);
        //er.write(value, os);

        value = er.read(is,3);
        for (byte b : value){
            er.writePlus(b, os);
        }

        er.deCompress(value);

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
        System.out.print(":" + String.format("%02X ", value) + ":" + value + "\n");


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