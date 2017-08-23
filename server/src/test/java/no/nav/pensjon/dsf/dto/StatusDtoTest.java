package no.nav.pensjon.dsf.dto;

import no.nav.pensjon.dsf.domene.status.Status;
import no.nav.pensjon.test.IsMapWithSize;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;

import static net.javacrumbs.jsonunit.fluent.JsonFluentAssert.assertThatJson;
import static org.hamcrest.Matchers.hasEntry;
import static org.junit.Assert.assertEquals;

public class StatusDtoTest {
    private ModelMapper modelMapper = new ModelMapper();

    private Status status;

    @Before
    public void setUp() {
        status = new Status();
        status.setAntallBarn(3);
        status.setDodAvYrkesskade("J");
        status.setDodsddato(19990101);
        status.setEktefelleInntektOver2g("J");

        status.setFoersteGangReg("J");
        status.setFriinntektDato(19980101);
        status.setGammelSammenstotsRegel("??");
        status.setGarantertTilleggsPensjonKode("??");
        status.setGrunnbelopsDato(19970101);
        status.setGrunnPensjonReduksjonsKode("??");
        status.setPensjonFoer9802("??");
        status.setPensjonsrettFoer91("??");
        status.setPensjonsType1("??");
        status.setPensjonsType2("??");
        status.setPensjonsType3("??");
        status.setPoengtilleggsDato(1111);
        status.setPoengtilleggsKode("??");
        status.setRed_grunnPensjon_3_2_1("??");
        status.setSivilstand("??");
        status.setStatusKode("??");
        status.setStatusKodeHistorie("??");
        status.setSumYtelse(1337);
        status.setTrygdetid16_66(1212);
        status.setTrygdetid1967Til1970(1313);
        status.setTrygdetidAnvendt(1414);
        status.setTrygdetidEtter1966(1515);
        status.setTrygdetidFoer1967(1616);
        status.setTrygdetidFramTil(1717);
        status.setTrygdetidGaranti(1818);
        status.setVilkar8_4_3a("??");
        status.setVirkDato(1919);
    }

    @After
    public void tearDown() {
        status = null;
    }

    @Test
    public void thatStatusIsMappedCorrectlyToDto() {
        StatusDto statusDto = modelMapper.map(status, StatusDto.class);

        assertEquals(status.getAntallBarn(), statusDto.getAntallBarn());
        assertEquals(status.getDodAvYrkesskade(), statusDto.getDodAvYrkesskade());
        assertEquals(status.getDodsddato(), statusDto.getDodsddato());
        assertEquals(status.getEktefelleInntektOver2g(), statusDto.getEktefelleInntektOver2g());
        assertEquals(status.getFoersteGangReg(), statusDto.getFoersteGangReg());
        assertEquals(status.getFriinntektDato(), statusDto.getFriinntektDato());
        assertEquals(status.getGammelSammenstotsRegel(), statusDto.getGammelSammenstotsRegel());
        assertEquals(status.getGarantertTilleggsPensjonKode(), statusDto.getGarantertTilleggsPensjonKode());
        assertEquals(status.getGrunnbelopsDato(), statusDto.getGrunnbelopsDato());
        assertEquals(status.getGrunnPensjonReduksjonsKode(), statusDto.getGrunnPensjonReduksjonsKode());
        assertEquals(status.getPensjonFoer9802(), statusDto.getPensjonFoer9802());
        assertEquals(status.getPensjonsrettFoer91(), statusDto.getPensjonsrettFoer91());
        assertEquals(status.getPensjonsType1(), statusDto.getPensjonsType1());
        assertEquals(status.getPensjonsType2(), statusDto.getPensjonsType2());
        assertEquals(status.getPensjonsType3(), statusDto.getPensjonsType3());
        assertEquals(status.getPoengtilleggsDato(), statusDto.getPoengtilleggsDato());
        assertEquals(status.getPoengtilleggsKode(), statusDto.getPoengtilleggsKode());
        assertEquals(status.getRed_grunnPensjon_3_2_1(), statusDto.getRed_grunnPensjon_3_2_1());
        assertEquals(status.getSivilstand(), statusDto.getSivilstand());
        assertEquals(status.getStatusKode(), statusDto.getStatusKode());
        assertEquals(status.getStatusKodeHistorie(), statusDto.getStatusKodeHistorie());
        assertEquals(status.getSumYtelse(), statusDto.getSumYtelse());
        assertEquals(status.getTrygdetid16_66(), statusDto.getTrygdetid16_66());
        assertEquals(status.getTrygdetid1967Til1970(), statusDto.getTrygdetid1967Til1970());
        assertEquals(status.getTrygdetidAnvendt(), statusDto.getTrygdetidAnvendt());
        assertEquals(status.getTrygdetidEtter1966(), statusDto.getTrygdetidEtter1966());
        assertEquals(status.getTrygdetidFoer1967(), statusDto.getTrygdetidFoer1967());
        assertEquals(status.getTrygdetidFramTil(), statusDto.getTrygdetidFramTil());
        assertEquals(status.getTrygdetidGaranti(), statusDto.getTrygdetidGaranti());
        assertEquals(status.getVilkar8_4_3a(), statusDto.getVilkar8_4_3a());
        assertEquals(status.getVirkDato(), statusDto.getVirkDato());
    }

    @Test
    public void thatStatusDtoIsMappedCorrectlyToJson() {
        StatusDto statusDto = modelMapper.map(status, StatusDto.class);
        assertThatJson(statusDto).matches(IsMapWithSize.hasSize(31))
                .matches(hasEntry("virkDato", BigDecimal.valueOf(1919)))
                .matches(hasEntry("statusKode", "??"))
                .matches(hasEntry("statusKodeHistorie", "??"))
                .matches(hasEntry("pensjonsType1", "??"))
                .matches(hasEntry("pensjonsType2", "??"))
                .matches(hasEntry("pensjonsType3", "??"))
                .matches(hasEntry("sivilstand", "??"))
                .matches(hasEntry("trygdetidFoer1967", BigDecimal.valueOf(1616)))
                .matches(hasEntry("trygdetidEtter1966", BigDecimal.valueOf(1515)))
                .matches(hasEntry("trygdetidFramTil", BigDecimal.valueOf(1717)))
                .matches(hasEntry("trygdetid1967Til1970", BigDecimal.valueOf(1313)))
                .matches(hasEntry("trygdetidAnvendt", BigDecimal.valueOf(1414)))
                .matches(hasEntry("foersteGangReg", "J"))
                .matches(hasEntry("sumYtelse", BigDecimal.valueOf(1337)))
                .matches(hasEntry("antallBarn", BigDecimal.valueOf(3)))
                .matches(hasEntry("dodsddato", BigDecimal.valueOf(19990101)))
                .matches(hasEntry("dodAvYrkesskade", "J"))
                .matches(hasEntry("vilkar8_4_3a", "??"))
                .matches(hasEntry("trygdetidGaranti", BigDecimal.valueOf(1818)))
                .matches(hasEntry("grunnbelopsDato", BigDecimal.valueOf(19970101)))
                .matches(hasEntry("poengtilleggsDato", BigDecimal.valueOf(1111)))
                .matches(hasEntry("poengtilleggsKode", "??"))
                .matches(hasEntry("pensjonsrettFoer91", "??"))
                .matches(hasEntry("trygdetid16_66", BigDecimal.valueOf(1212)))
                .matches(hasEntry("garantertTilleggsPensjonKode", "??"))
                .matches(hasEntry("ektefelleInntektOver2g", "J"))
                .matches(hasEntry("pensjonFoer9802", "??"))
                .matches(hasEntry("red_grunnPensjon_3_2_1", "??"))
                .matches(hasEntry("grunnPensjonReduksjonsKode", "??"))
                .matches(hasEntry("friinntektDato", BigDecimal.valueOf(19980101)));
    }

}