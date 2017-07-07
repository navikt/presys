package no.nav.pensjon.presys.utils.ebcdic;

import no.nav.pensjon.dsf.domene.EtteroppgjorAFP;
import no.nav.pensjon.dsf.domene.Inntekt;
import no.nav.pensjon.dsf.domene.Person;
import no.nav.pensjon.dsf.domene.Status;

import static no.nav.pensjon.presys.utils.ebcdic.TestStatus.createStatus;

public class TestPerson {
    private Person p;

    TestPerson(Person p){
        this.p = p;
    }

    public TestPerson withInntekter(){
        p.getInntekter().add(inntekt(2010));
        p.getInntekter().add(inntekt(2011));
        p.getInntekter().add(inntekt(2012));
        return this;
    }

    public TestPerson withEtteroppgjorAfp(){
        p.getEtteroppgjor().add(eoafp());
        return this;
    }

    public TestPerson withUforehistorikk(){
        return withStatus(createStatus("S").withUforeHistorikk());
    }

    public TestPerson withStatus(TestStatus status){
        p.getStatus().add(status.get());
        return this;
    }

    public Person get(){
        return p;
    }

    static TestPerson createPerson(String fnr, String navn, int ai67){
        Person p = new Person();
        p.setFnr(fnr);
        p.setNavn(navn);
        p.setAi67(ai67);
        return new TestPerson(p);
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

    static Inntekt inntekt(int aar){
        return inntekt(10000, aar, "B", "C", 201010, "1234");
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
