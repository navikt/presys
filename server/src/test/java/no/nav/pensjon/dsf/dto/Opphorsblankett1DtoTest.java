package no.nav.pensjon.dsf.dto;

import no.nav.pensjon.dsf.domene.grunnblanketter.OPPHBL1;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import java.util.HashMap;
import java.util.Map;

import static net.javacrumbs.jsonunit.fluent.JsonFluentAssert.assertThatJson;
import static org.junit.Assert.assertEquals;

public class Opphorsblankett1DtoTest {
    private ModelMapper modelMapper = new ModelMapper();

    private OPPHBL1 opphorsblankett;

    private Opphorsblankett1Dto opphorsblankettDto;

    @Before
    public void setUp() {
        opphorsblankett = new OPPHBL1();
        opphorsblankett.setAvdodesPensjonsgivendeInntekt(1010);
        opphorsblankett.setDodsDato(1111);
        opphorsblankett.setEktefelleFodselsnummer("1212");
        opphorsblankett.setEktefelleNavn("??");

        opphorsblankettDto = modelMapper.map(opphorsblankett, Opphorsblankett1Dto.class);
    }

    @After
    public void tearDown() {
        opphorsblankett = null;
        opphorsblankettDto = null;
    }

    @Test
    public void thatOpphorsblankettIsMappedCorrectlyToDto() {
        assertEquals(opphorsblankett.getAvdodesPensjonsgivendeInntekt(), opphorsblankettDto.getAvdodesPensjonsgivendeInntekt());
        assertEquals(opphorsblankett.getDodsDato(), opphorsblankettDto.getDodsDato());
        assertEquals(opphorsblankett.getEktefelleFodselsnummer(), opphorsblankettDto.getEktefelleFodselsnummer());
        assertEquals(opphorsblankett.getEktefelleNavn(), opphorsblankettDto.getEktefelleNavn());
    }

    @Test
    public void thatOpphorsblankett1DtoIsMappedCorrectlyToJson() {
        Map<String, Object> expected = new HashMap<>();
        expected.put("avdodesPensjonsgivendeInntekt", 1010);
        expected.put("dodsDato", 1111);
        expected.put("ektefelleFodselsnummer", "1212");
        expected.put("ektefelleNavn", "??");

        assertThatJson(opphorsblankettDto).isEqualTo(expected);
    }

}