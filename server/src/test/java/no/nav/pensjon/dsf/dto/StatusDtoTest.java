package no.nav.pensjon.dsf.dto;

import no.nav.pensjon.dsf.domene.status.Status;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static net.javacrumbs.jsonunit.fluent.JsonFluentAssert.assertThatJson;
import static org.junit.Assert.assertEquals;

public class StatusDtoTest {
    private ModelMapper modelMapper = new ModelMapper();

    private Status status;

    private StatusDto statusDto;

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
        status.setRedGrunnPensjon321("??");
        status.setSivilstand("??");
        status.setStatusKode("??");
        status.setStatusKodeHistorie("??");
        status.setSumYtelse(1337);
        status.setTrygdetid1666(1212);
        status.setTrygdetid1967Til1970(1313);
        status.setTrygdetidAnvendt(1414);
        status.setTrygdetidEtter1966(1515);
        status.setTrygdetidFoer1967(1616);
        status.setTrygdetidFramTil(1717);
        status.setTrygdetidGaranti(1818);
        status.setVilkar843A("??");
        status.setVirkDato(1919);

        statusDto = modelMapper.map(status, StatusDto.class);
    }

    @After
    public void tearDown() {
        status = null;
        statusDto = null;
    }

    @Test
    public void thatStatusIsMappedCorrectlyToDto() {
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
        assertEquals(status.getRedGrunnPensjon321(), statusDto.getRedGrunnPensjon321());
        assertEquals(status.getSivilstand(), statusDto.getSivilstand());
        assertEquals(status.getStatusKode(), statusDto.getStatusKode());
        assertEquals(status.getStatusKodeHistorie(), statusDto.getStatusKodeHistorie());
        assertEquals(status.getSumYtelse(), statusDto.getSumYtelse());
        assertEquals(status.getTrygdetid1666(), statusDto.getTrygdetid1666());
        assertEquals(status.getTrygdetid1967Til1970(), statusDto.getTrygdetid1967Til1970());
        assertEquals(status.getTrygdetidAnvendt(), statusDto.getTrygdetidAnvendt());
        assertEquals(status.getTrygdetidEtter1966(), statusDto.getTrygdetidEtter1966());
        assertEquals(status.getTrygdetidFoer1967(), statusDto.getTrygdetidFoer1967());
        assertEquals(status.getTrygdetidFramTil(), statusDto.getTrygdetidFramTil());
        assertEquals(status.getTrygdetidGaranti(), statusDto.getTrygdetidGaranti());
        assertEquals(status.getVilkar843A(), statusDto.getVilkar843A());
        assertEquals(status.getVirkDato(), statusDto.getVirkDato());
    }

    @Test
    public void thatStatusDtoIsMappedCorrectlyToJson() {
        Map<String, Object> expected = new HashMap<>();
        expected.put("virkDato", 1919);
        expected.put("statusKode", "??");
        expected.put("statusKodeHistorie", "??");
        expected.put("pensjonsType1", "??");
        expected.put("pensjonsType2", "??");
        expected.put("pensjonsType3", "??");
        expected.put("sivilstand", "??");
        expected.put("gammelSammenstotsRegel", "??");
        expected.put("trygdetidFoer1967", 1616);
        expected.put("trygdetidEtter1966", 1515);
        expected.put("trygdetidFramTil", 1717);
        expected.put("trygdetid1967Til1970", 1313);
        expected.put("trygdetidAnvendt", 1414);
        expected.put("foersteGangReg", "J");
        expected.put("sumYtelse", 1337);
        expected.put("antallBarn", 3);
        expected.put("dodsddato", 19990101);
        expected.put("dodAvYrkesskade", "J");
        expected.put("vilkar843A", "??");
        expected.put("trygdetidGaranti", 1818);
        expected.put("grunnbelopsDato", 19970101);
        expected.put("poengtilleggsDato", 1111);
        expected.put("poengtilleggsKode", "??");
        expected.put("pensjonsrettFoer91", "??");
        expected.put("trygdetid1666", 1212);
        expected.put("garantertTilleggsPensjonKode", "??");
        expected.put("ektefelleInntektOver2g", "J");
        expected.put("pensjonFoer9802", "??");
        expected.put("redGrunnPensjon321", "??");
        expected.put("grunnPensjonReduksjonsKode", "??");
        expected.put("friinntektDato", 19980101);
        expected.put("uforehistorikk", new ArrayList<>());
        expected.put("afpHistorikk", new ArrayList<>());
        expected.put("eosInfo", new ArrayList<>());
        expected.put("spesielleOpplysninger", new ArrayList<>());

        assertThatJson(statusDto).isEqualTo(expected);
    }

}