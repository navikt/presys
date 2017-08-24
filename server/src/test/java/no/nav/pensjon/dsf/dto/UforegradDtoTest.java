package no.nav.pensjon.dsf.dto;

import no.nav.pensjon.dsf.domene.Uforegrad;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import java.util.HashMap;
import java.util.Map;

import static net.javacrumbs.jsonunit.fluent.JsonFluentAssert.assertThatJson;
import static org.junit.Assert.assertEquals;

public class UforegradDtoTest {

    private ModelMapper modelMapper = new ModelMapper();

    private Uforegrad uforegrad;

    private UforegradDto uforegradDto;

    @Before
    public void setUp() {
        uforegrad = new Uforegrad();
        uforegrad.setUforegradDato(1010);
        uforegrad.setUforegradOvrige(1111);
        uforegrad.setVirkningsdatoUforegrad(1212);
        uforegrad.setYngsteBarnFoerGrad(1313);

        uforegradDto = modelMapper.map(uforegrad, UforegradDto.class);
    }

    @After
    public void tearDown() {
        uforegrad = null;
        uforegradDto = null;
    }

    @Test
    public void thatUforegradIsMappedCorrectlyToDto() {
        assertEquals(uforegrad.getUforegradDato(), uforegradDto.getUforegradDato());
        assertEquals(uforegrad.getUforegradOvrige(), uforegradDto.getUforegradOvrige());
        assertEquals(uforegrad.getVirkningsdatoUforegrad(), uforegradDto.getVirkningsdatoUforegrad());
        assertEquals(uforegrad.getYngsteBarnFoerGrad(), uforegradDto.getYngsteBarnFoerGrad());
    }

    @Test
    public void thatUforegradDtoIsMappedCorrectlyToJson() {
        Map<String, Object> expected = new HashMap<>();
        expected.put("uforegradDato", 1010);
        expected.put("uforegradOvrige", 1111);
        expected.put("virkningsdatoUforegrad", 1212);
        expected.put("yngsteBarnFoerGrad", 1313);

        assertThatJson(uforegradDto).isEqualTo(expected);
    }

}