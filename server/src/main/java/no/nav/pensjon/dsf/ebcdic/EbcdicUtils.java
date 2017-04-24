package no.nav.pensjon.dsf.ebcdic;

import com.ibm.as400.access.AS400PackedDecimal;

import java.io.*;
import java.math.BigDecimal;

public class EbcdicUtils {

    public static final String EBCDIC_CHARSET = "Cp1142";

    public static byte[] read(DataInput data, int length) throws IOException {
        byte[] kdgex = new byte[length];
        data.readFully(kdgex);
        return kdgex;
    }

    public static void write(byte[] value, DataOutput out) throws IOException {
        out.write(value);
        System.out.print("\n");
    }

    public static void writePlus(byte value, DataOutput out) throws IOException {
        byte stringbytes[] = {value};
        out.write(new String(stringbytes, EBCDIC_CHARSET).getBytes("UTF-8"));
        int unsignedByte = value & 0xFF;
        System.out.print(":" + String.format("%02X ", value) /*+ ":" + value */+ "\n");
    }

    public static String deCompress(byte[] packed, int length, int decimals){
        BigDecimal komprimertEntry = (BigDecimal) new AS400PackedDecimal(length, decimals).toObject(packed);
        return komprimertEntry.toString();
    }

    public static byte[] compress(double unpacked, int length) throws IOException {
        AS400PackedDecimal packedDecimal = new AS400PackedDecimal(length, 0);
        return  packedDecimal.toBytes(unpacked);
    }

    public static String getString(byte[] Cp1047bytes){
        try {
            return new String(Cp1047bytes, EBCDIC_CHARSET);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static int search(byte[]value, String seearchString) throws UnsupportedEncodingException {
        return search(value, seearchString.getBytes(EBCDIC_CHARSET));
    }

    public static int search(byte[]value, byte[] pattern){
        forvalue:
        for (int i = 0; i < value.length-pattern.length; i++){
            for(int j = 0; j<pattern.length;j++){
                if(value[j+i] != pattern[j] ){
                    continue forvalue;
                }
            }
            return i;
        }
        return -1;
    }

    public static int search(byte[]value, int[] pattern){
        forvalue:
        for (int i = 0; i < value.length-pattern.length; i++){
            for(int j = 0; j<pattern.length;j++){
                if((value[j+i]&0xFF) != pattern[j] ){
                    continue forvalue;
                }
            }
            return i;
        }
        return -1;
    }
}
