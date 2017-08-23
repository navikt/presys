package no.nav.pensjon.dsf.dto;

import no.nav.pensjon.dsf.domene.Tilberpo;
import no.nav.pensjon.test.IsMapWithSize;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;

import static net.javacrumbs.jsonunit.fluent.JsonFluentAssert.assertThatJson;
import static org.hamcrest.Matchers.hasEntry;
import static org.junit.Assert.assertEquals;

public class TilberpoDtoTest {
    private ModelMapper modelMapper = new ModelMapper();

    private Tilberpo tilberpo;

    private TilberpoDto tilberpoDto;

    @Before
    public void setUp() throws Exception {
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
    public void tearDown() throws Exception {
        tilberpo = null;
        tilberpoDto = null;
    }

    @Test
    public void thatTilberpoIsMappedCorrectlyToDto() {
        assertEquals(tilberpo.getAi63(), tilberpoDto.getAi63());
        assertEquals(tilberpo.getAi64(), tilberpoDto.getAi64());
        assertEquals(tilberpo.getAi65(), tilberpoDto.getAi65());
        assertEquals(tilberpo.getAi66(), tilberpoDto.getAi66());
        assertEquals(tilberpo.getPi66(), tilberpoDto.getPi66());
        assertEquals(tilberpo.getVernepliktaar1(), tilberpoDto.getVernepliktaar1());
        assertEquals(tilberpo.getVernepliktaar2(), tilberpoDto.getVernepliktaar2());
        assertEquals(tilberpo.getVernepliktaar3(), tilberpoDto.getVernepliktaar3());
        assertEquals(tilberpo.getVernepliktaar4(), tilberpoDto.getVernepliktaar4());
    }

    @Test
    public void thatTilberpoDtoIsMappedCorrectlyToJson() {
        assertThatJson(tilberpoDto)
                .matches(IsMapWithSize.hasSize(9))
                .matches(hasEntry("ai63", BigDecimal.valueOf(1010)))
                .matches(hasEntry("ai64", BigDecimal.valueOf(1111)))
                .matches(hasEntry("ai65", BigDecimal.valueOf(1212)))
                .matches(hasEntry("ai66", BigDecimal.valueOf(1313)))
                .matches(hasEntry("pi66", BigDecimal.valueOf(1414)))
                .matches(hasEntry("vernepliktaar1", BigDecimal.valueOf(1515)))
                .matches(hasEntry("vernepliktaar2", BigDecimal.valueOf(1616)))
                .matches(hasEntry("vernepliktaar3", BigDecimal.valueOf(1717)))
                .matches(hasEntry("vernepliktaar4", BigDecimal.valueOf(1818)));
    }

}