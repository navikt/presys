package no.nav.pensjon.dsf.dto;

import no.nav.pensjon.dsf.domene.grunnblanketter.Barn;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import java.util.HashMap;
import java.util.Map;

import static net.javacrumbs.jsonunit.fluent.JsonFluentAssert.assertThatJson;
import static org.junit.Assert.assertEquals;

public class BarnDtoTest {
    private ModelMapper modelMapper = new ModelMapper();

    private Barn model;

    private BarnDto dto;

    @Before
    public void setUp() {
        model = new Barn();
        model.setFellesBarn("??");
        model.setFellesEtter0591("??");
        model.setFellesFor0591("??");
        model.setFnr("??");
        model.setNavn("??");
        model.setTknr("??");

        dto = modelMapper.map(model, BarnDto.class);
    }

    @After
    public void tearDown() {
        model = null;
        dto = null;
    }

    @Test
    public void thatBarnIsMappedCorrectlyToDto() {
        assertEquals(model.getFellesBarn(), dto.getFellesBarn());
        assertEquals(model.getFellesEtter0591(), dto.getFellesEtter0591());
        assertEquals(model.getFellesFor0591(), dto.getFellesFor0591());
        assertEquals(model.getFnr(), dto.getFnr());
        assertEquals(model.getNavn(), dto.getNavn());
    }

    @Test
    public void thatBarnDtoIsMappedCorrectlyToJson() {
        Map<String, Object> expected = new HashMap<>();
        expected.put("fellesBarn", "??");
        expected.put("fellesEtter0591", "??");
        expected.put("fellesFor0591", "??");
        expected.put("fnr", "??");
        expected.put("navn", "??");

        assertThatJson(dto).isEqualTo(expected);

    }

}