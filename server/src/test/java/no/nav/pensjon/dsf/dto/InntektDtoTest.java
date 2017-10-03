package no.nav.pensjon.dsf.dto;

import no.nav.pensjon.dsf.domene.Inntekt;
import no.nav.pensjon.dsf.domene.status.SpesielleOpplysninger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import java.util.HashMap;
import java.util.Map;

import static net.javacrumbs.jsonunit.fluent.JsonFluentAssert.assertThatJson;
import static org.junit.Assert.assertEquals;

public class InntektDtoTest {
    private ModelMapper modelMapper = new ModelMapper();

    private Inntekt inntekt;

    private InntektDto inntektDto;

    @Before
    public void setUp() {
        inntekt = new Inntekt();
        inntekt.setKommune("??");
        inntekt.setPersonInntekt(1010);
        inntekt.setPersonInntektAar(1111);
        inntekt.setPersonInntektMerke("??");
        inntekt.setPersonInntektType("??");
        inntekt.setRapporteringsDato(1212);

        inntektDto = modelMapper.map(inntekt, InntektDto.class);
    }

    @After
    public void tearDown() {
        inntekt = null;
        inntektDto = null;
    }

    @Test
    public void thatInntektIsMappedCorrectlyToDto() {
        assertEquals(inntekt.getKommune(), inntektDto.getKommune());
        assertEquals(inntekt.getPersonInntekt(), inntektDto.getPersonInntekt());
        assertEquals(inntekt.getPersonInntektAar(), inntektDto.getPersonInntektAar());
        assertEquals(inntekt.getPersonInntektMerke(), inntektDto.getPersonInntektMerke());
        assertEquals(inntekt.getPersonInntektType(), inntektDto.getPersonInntektType());
        assertEquals(inntekt.getRapporteringsDato(), inntektDto.getRapporteringsDato());
    }

    @Test
    public void thatInntektDtoIsMappedCorrectlyToJson() {
        Map<String, Object> expected = new HashMap<>();
        expected.put("kommune", "??");
        expected.put("personInntekt", 1010);
        expected.put("personInntektAar", 1111);
        expected.put("personInntektMerke", "??");
        expected.put("personInntektType", "??");
        expected.put("rapporteringsDato", 1212);

        assertThatJson(inntektDto).isEqualTo(expected);
    }

}