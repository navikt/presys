package no.nav.pensjon.dsf.web;

import no.nav.pensjon.dsf.ebcdic.EbcdicUtils;

import java.io.*;

/**
 * Created by d132988 on 05.04.2017.
 */
public class EbcdicReader {

    public static void main(String[] args) throws IOException {
        DataInputStream is = new DataInputStream(EbcdicReader.class.getClassLoader().getResourceAsStream("TEST3"));
        DataOutputStream os = new DataOutputStream(System.out);
        
        int [] pattern = {0x07, 0x11, 0x66, 0x45, 0x42, 0x9C};
        byte [] value = EbcdicUtils.read(is, 2600);
        int index = EbcdicUtils.search(value, pattern);
        for(int s = index + pattern.length; s < index + 20; s++)
            EbcdicUtils.writePlus(value[s], os);
    }


}