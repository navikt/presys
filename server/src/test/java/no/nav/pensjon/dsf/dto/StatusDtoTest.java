package no.nav.pensjon.dsf.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import no.nav.pensjon.dsf.domene.status.Status;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import static org.junit.Assert.assertEquals;

public class StatusDtoTest {
    private ModelMapper modelMapper = new ModelMapper();

    private ObjectMapper objectMapper = new ObjectMapper();

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
    public void thatStatusIsMappedCorrectlyToDto() throws Exception {
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
    public void thatStatusDtoIsMappedCorrectlyToJson() throws Exception {
        StatusDto statusDto = modelMapper.map(status, StatusDto.class);
        String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(statusDto);

        String expected = "{\r\n" +
                "  \"virkDato\" : 1919,\r\n" +
                "  \"statusKode\" : \"??\",\r\n" +
                "  \"statusKodeHistorie\" : \"??\",\r\n" +
                "  \"pensjonsType1\" : \"??\",\r\n" +
                "  \"pensjonsType2\" : \"??\",\r\n" +
                "  \"pensjonsType3\" : \"??\",\r\n" +
                "  \"sivilstand\" : \"??\",\r\n" +
                "  \"trygdetidFoer1967\" : 1616,\r\n" +
                "  \"trygdetidEtter1966\" : 1515,\r\n" +
                "  \"trygdetidFramTil\" : 1717,\r\n" +
                "  \"trygdetid1967Til1970\" : 1313,\r\n" +
                "  \"trygdetidAnvendt\" : 1414,\r\n" +
                "  \"foersteGangReg\" : \"J\",\r\n" +
                "  \"sumYtelse\" : 1337,\r\n" +
                "  \"antallBarn\" : 3,\r\n" +
                "  \"dodsddato\" : 19990101,\r\n" +
                "  \"dodAvYrkesskade\" : \"J\",\r\n" +
                "  \"vilkar8_4_3a\" : \"??\",\r\n" +
                "  \"trygdetidGaranti\" : 1818,\r\n" +
                "  \"grunnbelopsDato\" : 19970101,\r\n" +
                "  \"poengtilleggsDato\" : 1111,\r\n" +
                "  \"poengtilleggsKode\" : \"??\",\r\n" +
                "  \"pensjonsrettFoer91\" : \"??\",\r\n" +
                "  \"trygdetid16_66\" : 1212,\r\n" +
                "  \"garantertTilleggsPensjonKode\" : \"??\",\r\n" +
                "  \"gammelSammenstotsRegel\" : \"??\",\r\n" +
                "  \"ektefelleInntektOver2g\" : \"J\",\r\n" +
                "  \"pensjonFoer9802\" : \"??\",\r\n" +
                "  \"red_grunnPensjon_3_2_1\" : \"??\",\r\n" +
                "  \"grunnPensjonReduksjonsKode\" : \"??\",\r\n" +
                "  \"friinntektDato\" : 19980101\r\n" +
                "}";
        assertEquals(expected, json);
    }

}