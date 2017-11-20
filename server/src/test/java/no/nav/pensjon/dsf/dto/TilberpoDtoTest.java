package no.nav.pensjon.dsf.dto;

import no.nav.pensjon.dsf.domene.Tilberpo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import java.util.HashMap;
import java.util.Map;

import static net.javacrumbs.jsonunit.fluent.JsonFluentAssert.assertThatJson;
import static org.junit.Assert.assertEquals;

public class TilberpoDtoTest {
    private ModelMapper modelMapper = new ModelMapper();

    private Tilberpo tilberpo;

    private TilberpoDto tilberpoDto;

    @Before
    public void setUp() {
        tilberpo = new Tilberpo();
        tilberpo.setAi63(1010);
        tilberpo.setAi64(1111);
        tilberpo.setAi65(1212);
        tilberpo.setAi66(1313);
        tilberpo.setPi66(1414);
        tilberpo.setVernepliktaar1(1515);
        tilberpo.setVernepliktaar2(1616);
        tilberpo.setVernepliktaar3(1717);
        tilberpo.setVernepliktaar4(1818);

        tilberpoDto = modelMapper.map(tilberpo, TilberpoDto.class);
    }

    @After
    public void tearDown() {
        tilberpo = null;
        tilberpoDto = null;
    }

    @Test
    /**
     * Vi ganger tallet i Dto'en med 100 for å få riktig visning
     * EBCD-filen lagret beløp/100
     */

    public void thatTilberpoIsMappedCorrectlyToDto() {
        assertEquals(tilberpo.getAi63()*100, tilberpoDto.getAi63());
        assertEquals(tilberpo.getAi64()*100, tilberpoDto.getAi64());
        assertEquals(tilberpo.getAi65()*100, tilberpoDto.getAi65());
        assertEquals(tilberpo.getAi66()*100, tilberpoDto.getAi66());
        assertEquals(tilberpo.getPi66()*100, tilberpoDto.getPi66());
        assertEquals(tilberpo.getVernepliktaar1(), tilberpoDto.getVernepliktaar1());
        assertEquals(tilberpo.getVernepliktaar2(), tilberpoDto.getVernepliktaar2());
        assertEquals(tilberpo.getVernepliktaar3(), tilberpoDto.getVernepliktaar3());
        assertEquals(tilberpo.getVernepliktaar4(), tilberpoDto.getVernepliktaar4());
    }

    @Test
    public void thatTilberpoDtoIsMappedCorrectlyToJson() {
        Map<String, Object> expected = new HashMap<>();
        expected.put("ai63", 101000);
        expected.put("ai64", 111100);
        expected.put("ai65", 121200);
        expected.put("ai66", 131300);
        expected.put("pi66", 141400);
        expected.put("vernepliktaar1", 1515);
        expected.put("vernepliktaar2", 1616);
        expected.put("vernepliktaar3", 1717);
        expected.put("vernepliktaar4", 1818);

        assertThatJson(tilberpoDto).isEqualTo(expected);
    }

}