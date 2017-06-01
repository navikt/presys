package no.nav.pensjon.presys.utils.ebcdic;

import no.nav.pensjon.dsf.domene.EtteroppgjorAFP;
import no.nav.pensjon.dsf.domene.Inntekt;
import no.nav.pensjon.dsf.domene.Person;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class TestdataGenerering {


    public static void main(String[] args) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        Person [] personer = {
                person("1", "Donald Duck", 12,
                        Arrays.asList(inntekt(999, 1991, "A", "B", 1234, "0231")),
                        Arrays.asList(eoafp())),
                person("2", "Fetter Anton", 12,
                        Arrays.asList(inntekt(999, 1991, "A", "B", 1234, "0231")),
                        Collections.emptyList())
        };
        List<String> lines = new ArrayList<>();
        for (Person p : personer){
            AnnotationMapper.writeSegment(p, bos);

            String fnr = p.getFnr();
            String data = new String(Base64.getEncoder().encode(bos.toByteArray()), Charset.forName("UTF-8"));
            bos.reset();
            lines.add(fnr + ";" + data);
        }

        Path file = Paths.get("testpersoner.txt");
        Files.write(file, lines, Charset.forName("UTF-8"));

    }


    static Person person(String fnr, String navn, int ai67, List<Inntekt> inntekter, List<EtteroppgjorAFP> etteroppgjorAFPs){
        Person p = new Person();
        p.setFnr(fnr);
        p.setNavn(navn);
        p.setAi67(ai67);
        p.getInntekter().addAll(inntekter);
        p.getEtteroppgjor().addAll(etteroppgjorAFPs);
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

    static EtteroppgjorAFP eoafp (){
        EtteroppgjorAFP eoafp = new EtteroppgjorAFP();
        eoafp.setBeregnetEllerRegistrertViaInfotrygd("N");
        eoafp.setDifferanseForLiteUtbetalt(100);
        eoafp.setDifferanseForMyeUtbetalt(0);
        eoafp.setFaktiskUtbetalt(200);
        eoafp.setFullAFPiAvregningsperioden(3);
        eoafp.setInntektsAar(2001);
        eoafp.setInntektEtterOpphor(122);
        eoafp.setInntektForUttakAvAFP(123);
        eoafp.setInntektIAFPPerioden(32);
        eoafp.setOppgittFramtidigInntekt(234);
        eoafp.setPensjonsgivendeInntekt(432);
        eoafp.setRegistertViaDSFEllerInfotrygdIEO("d");
        eoafp.setRegistertViaDSFEllerInfotrygdIFU("daw");
        eoafp.setTidligereInntekt(6543);
        return eoafp;
    }
}
