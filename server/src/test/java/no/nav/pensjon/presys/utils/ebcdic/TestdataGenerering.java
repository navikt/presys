package no.nav.pensjon.presys.utils.ebcdic;

import no.nav.pensjon.dsf.domene.EtteroppgjorAFP;
import no.nav.pensjon.dsf.domene.Inntekt;
import no.nav.pensjon.dsf.domene.Person;
import no.nav.pensjon.presys.utils.ebcdic.annotations.Felt;
import no.nav.pensjon.presys.utils.ebcdic.annotations.PackedDecimal;
import no.nav.pensjon.presys.utils.ebcdic.annotations.Segment;
import no.nav.pensjon.presys.utils.ebcdic.annotations.SubSegment;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class TestdataGenerering {
    static void writeSegment(Object o, OutputStream os) throws Exception {
        Meta m = new Meta();
        m.setMetalengde(Meta.META_SIZE);

        Segment seg = o.getClass().getAnnotation(Segment.class);
        m.setDatalengde(seg.length());
        m.setSegmentNavn(seg.name());

        os.write(asByte(m));
        os.write(asByte(o));
        os.write(0);

        Field[] fields = o.getClass().getDeclaredFields();
        for (Field f : fields) {
            if (f.isAnnotationPresent(SubSegment.class)) {
                List<Object> segments =  (List<Object>) getGetter(f).invoke(o);
                for(Object segment : segments){
                    writeSegment(segment, os);
                }
            }
        }
    }

    static byte[] asByte(Object o) throws Exception {
        Segment seg = o.getClass().getAnnotation(Segment.class);
        byte[] segmentBytes = new byte[seg.length()];
        Field[] fields = o.getClass().getDeclaredFields();
        for (Field f : fields) {
            if (f.isAnnotationPresent(Felt.class)) {
                Felt ta = f.getAnnotation(Felt.class);

                byte[] feltData = new byte[ta.length()];

                if (f.isAnnotationPresent(PackedDecimal.class)) {
                    if (f.getType().equals(String.class)) {
                        feltData =  EbcdicUtils.compress(Double.parseDouble(getGetter(f).invoke(o).toString()), ta.length() * 2 - 1);

                    } else if (f.getType().equals(Integer.TYPE)) {
                        feltData =  EbcdicUtils.compress((int) getGetter(f).invoke(o), ta.length() * 2 - 1);
                    }
                } else if (f.getType().equals(String.class)) {
                    byte[] tmp = getGetter(f).invoke(o).toString().getBytes(EbcdicUtils.EBCDIC_CHARSET);
                    for(int i = 0; i<feltData.length && i< tmp.length;i++){
                        feltData[i] = tmp[i];
                    }
                } else if (f.getType().equals(Integer.TYPE)) {
                    ByteBuffer buf = ByteBuffer.allocate(2);
                    int tmp = (int)getGetter(f).invoke(o);
                    buf.putShort((short)tmp);
                    feltData = buf.array();
                }
                for(int i = 0; i< feltData.length; i++){

                    segmentBytes[i+ta.start()] = feltData[i];
                }
            }
        }

        return segmentBytes;
    }

    private static Method getGetter(Field f) throws Exception {
        String getterName = "get" + String.valueOf(f.getName().charAt(0)).toUpperCase() + f.getName().substring(1);
        return f.getDeclaringClass().getMethod(getterName);
    }

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
            writeSegment(p, bos);

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
