package no.nav.pensjon.dsf.ebcdic;

import no.nav.pensjon.dsf.domene.Inntekt;
import no.nav.pensjon.dsf.domene.Person;
import no.nav.pensjon.dsf.ebcdic.segmenter.RF0PersonSegment;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

public class TestdataGenerering {

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        RF0PersonSegment pSeg = new RF0PersonSegment();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        Person [] personer = {
                person("1", "Donald Duck", 12, inntekt(999, 1991, "A", "B", 1234, "0231")),
                person("2", "Fetter Anton", 12, inntekt(4558, 1992, "A", "B", 1234, "0231"))
        };
        List<String> lines = new ArrayList<>();
        for (Person p : personer){
            pSeg.writeSegment(p, bos);
            String fnr = p.getFnr();
            String data = new String(Base64.getEncoder().encode(bos.toByteArray()), Charset.forName("UTF-8"));
            bos.reset();
            lines.add(fnr + ";" + data);
        }

        Path file = Paths.get("testpersoner.txt");
        Files.write(file, lines, Charset.forName("UTF-8"));
   }


    static Person person(String fnr, String navn, int ai67, Inntekt...inntekter){
        Person p = new Person();
        p.setFnr(fnr);
        p.setNavn(navn);
        p.setAi67(ai67);
        p.getInntekter().addAll(Arrays.asList(inntekter));

        return p;
    }

    static Inntekt inntekt(int personinntekt, int aar, String merke, String type, int dato, String kommune){
        Inntekt i = new Inntekt();
        i.setPersonInntekt(personinntekt);
        i.setPersonInntektAar(aar);
        i.setPersonInntektMerke(merke);
        i.setPersonInntektType(type);
        i.setRapporteringsDato(dato);
        i.setKommune(kommune);
        return i;
    }
}
