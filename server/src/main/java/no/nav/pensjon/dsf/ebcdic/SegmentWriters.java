package no.nav.pensjon.dsf.ebcdic;

import no.nav.pensjon.dsf.domene.Inntekt;
import no.nav.pensjon.dsf.domene.Person;
import no.nav.pensjon.dsf.ebcdic.segmenter.RF0PersonSegment;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;


public class SegmentWriters {

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        RF0PersonSegment pSeg = new RF0PersonSegment();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        Person p = new Person();
        p.setFnr("0123456");
        p.setNavn("Lars Erik");
        p.setAi67(12);

        Inntekt i = new Inntekt();
        i.setPersonInntekt(999);
        i.setPersonInntektAar(1991);
        i.setPersonInntektMerke("A");
        i.setPersonInntektType("B");
        i.setRapporteringsDato(1234);
        i.setKommune("0231");
        p.getInntekter().add(i);
        pSeg.writeSegment(p, bos);

        File mappe = new File("src/main/resources/database");
        mappe.mkdir();
        String fnr = EbcdicUtils.deCompress(Arrays.copyOfRange(bos.toByteArray(), 6+29, 6+29+6),11,0).toString();
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(fnr.getBytes("UTF-8"));
        byte[] digest = md.digest();
        DataOutputStream osFil = new DataOutputStream(new FileOutputStream(mappe.getAbsolutePath() + "/" + String.format("%064x", new java.math.BigInteger(1, digest)) + ".txt"));
        osFil.write(bos.toByteArray());
        osFil.close();

    }
}
