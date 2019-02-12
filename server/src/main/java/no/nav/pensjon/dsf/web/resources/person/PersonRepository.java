package no.nav.pensjon.dsf.web.resources.person;

import no.nav.pensjon.dsf.domene.Inntekt;
import no.nav.pensjon.dsf.domene.Person;
import no.nav.pensjon.dsf.domene.grunnblanketter.GRBLEBEN;
import no.nav.pensjon.dsf.domene.grunnblanketter.GRUNNBA1;
import no.nav.pensjon.dsf.domene.grunnblanketter.GRUNNEES;
import no.nav.pensjon.dsf.domene.grunnblanketter.TranHist;
import no.nav.pensjon.dsf.domene.status.Status;
import no.nav.pensjon.dsf.domene.status.UforeHistorikk;
import no.nav.pensjon.dsf.web.exceptions.ResourceNotFound;
import no.nav.pensjon.presys.utils.ebcdic.AnnotationMapper;
import no.nav.pensjon.presys.utils.ebcdic.ScrollableArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.Base64;
import java.util.Map;

@Component
public class PersonRepository {
    private static final Logger LOG = LoggerFactory.getLogger(PersonRepository.class);

    private JdbcTemplate db;

    @Inject
    public PersonRepository(JdbcTemplate db){
        this.db = db;
    }

    Person findPerson(String fnr) {
        MDC.put("bruker", fnr);

        if("1".equals(fnr)){
            return testBruker1();
        } else if("2".equals(fnr)){
            return testBruker2();
        }

        try {
            Map<String, Object> map = db.queryForMap("select data from db_person where fnr=?", fnr);
            return AnnotationMapper.les(new ScrollableArray(map.get("data") instanceof String ? Base64.getDecoder().decode((String) map.get("data")) : (byte[]) map.get("data")), Person.class);
        } catch (EmptyResultDataAccessException e){
            throw new ResourceNotFound(e);
        } catch (RuntimeException rte) {
            LOG.warn("Feil ved henting av person", rte);
            throw rte;
        }  finally {
            MDC.remove("bruker");
        }
    }

    boolean exists(String fnr){
        return db.queryForObject("SELECT COUNT(*) FROM DB_PERSON WHERE fnr = ?", new Object[]{fnr} , Integer.class ) > 0;
    }

    private Person testBruker1(){
        Person person = new Person();
        person.setFnr("1");
        person.setAi67(1234);
        person.setNavn("Donald Duck");

        person.getInntekter().add(testinntekt(1968, 12));
        person.getInntekter().add(testinntekt(1969, 123));
        person.getInntekter().add(testinntekt(1970, 1234));
        person.getInntekter().add(testinntekt(1971, 12345));
        person.getInntekter().add(testinntekt(1972, 123456));
        return person;
    }

    private Person testBruker2() {
        Person person = new Person();
        person.setFnr("2");
        person.setAi67(4321);
        person.setNavn("Dolly Duck");

        person.getInntekter().add(testinntekt(1973, 98));
        person.getInntekter().add(testinntekt(1974, 987));
        person.getInntekter().add(testinntekt(1975, 9876));
        person.getInntekter().add(testinntekt(1976, 98765));
        person.getInntekter().add(testinntekt(1977, 987654));

        person.getStatus().add(testStatus());

        person.getTranHister().add(testTranHist());
        return person;
    }

    private TranHist testTranHist() {
        TranHist tranHist = new TranHist();
        tranHist.setAutoTerminalId("ATid");
        tranHist.setGrunnblankettkode("GBK");
        tranHist.setPrioritetskode("PK");
        tranHist.setSivilstand("U");
        tranHist.setSpraak("N");
        tranHist.setTransaksjonsreturkode("TRK");
        tranHist.setTrygdekontornummer(124);
        tranHist.getGrunnba1er().add(testGrunnBa1());
        tranHist.getGrblebener().add(testGrblebener());
        return tranHist;
    }

    private GRBLEBEN testGrblebener() {
        GRBLEBEN grbleben = new GRBLEBEN();
        grbleben.setDodAvYrkesskade("N");
        grbleben.setDodsdato(199011);
        grbleben.setFodselsnummerAvdod("1");
        grbleben.setNavnYngsteBarn("N/A");
        grbleben.setPleiebarn("PB");
        return grbleben;
    }

    private GRUNNBA1 testGrunnBa1() {
        GRUNNBA1 grunnba1 = new GRUNNBA1();
        grunnba1.setAlderspensjonIProsent(1);
        grunnba1.setAntallBarn(0);
        grunnba1.setBosattNorge("J");
        grunnba1.setEktefelleInntektOver2G("N");
        grunnba1.setEktefelleMinst4G("N");
        grunnba1.setFodselsnummerEktefelle("1");
        grunnba1.setErFlyktning("N");
        grunnba1.setFramtidigArbeidsinntekt(100);
        grunnba1.setInntektEktefelle(23);
        grunnba1.setNavnEktefelle("Donald");
        grunnba1.setTilleggEktefelle("TE");
        return grunnba1;
    }

    private Status testStatus() {
        Status status = new Status();
        status.setAntallBarn(0);
        status.setDodAvYrkesskade("N");
        status.setEktefelleInntektOver2g("N");
        status.setSivilstand("U");
        status.setStatusKode("K");
        return status;
    }

    private Inntekt testinntekt(int aar, int belop){
        Inntekt inntekt = new Inntekt();
        inntekt.setKommune("01234");
        inntekt.setPersonInntekt(belop);
        inntekt.setPersonInntektAar(aar);
        inntekt.setPersonInntektType("B");
        inntekt.setPersonInntektMerke("");
        inntekt.setRapporteringsDato(2004147);
        return inntekt;
    }
}
