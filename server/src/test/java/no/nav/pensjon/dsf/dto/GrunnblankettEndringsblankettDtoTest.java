package no.nav.pensjon.dsf.dto;

import no.nav.pensjon.dsf.domene.grunnblanketter.ENDRBLAN;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import java.util.HashMap;
import java.util.Map;

import static net.javacrumbs.jsonunit.fluent.JsonFluentAssert.assertThatJson;
import static org.junit.Assert.assertEquals;

public class GrunnblankettEndringsblankettDtoTest {
    private ModelMapper modelMapper = new ModelMapper();

    private ENDRBLAN model;

    private GrunnblankettEndringsblankettDto dto;

    @Before
    public void setUp() {
        model = new ENDRBLAN();
        model.setFramtidigArbeidsinntekt(1010);
        model.setHoyestePensjonsgrad("??");
        model.setAlderspensjonsdelIProsent(1111);
        model.setUforegrad(1212);
        model.setForventetInntekt(1313);
        model.setOvergangsstonadTilPensjon("??");
        model.setTilleggspensjonForGjenlevendePensjonIProsent(1414);
        model.setFramleggsdato(1515);
        model.setOpphortOvergangsstonadGjennlevende("??");
        model.setNyttNavnPensjonist("??");
        model.setNyttNavnEps("??");
        model.setFodselsnummerEktefelle("1616");
        model.setNavnEktefelle("??");
        model.setSkilsmisse("??");
        model.setFlyttetFraHverandre("??");
        model.setFlyttetSammen("??");
        model.setInntektMinst4G("??");
        model.setInntektUnder4G("??");
        model.setYrkeUforegrad(1717);

        dto = modelMapper.map(model, GrunnblankettEndringsblankettDto.class);
    }

    @After
    public void tearDown() {
        model = null;
        dto = null;
    }

    @Test
    public void thatENDRBLANIsMappedCorrectlyToDto() {
        assertEquals(model.getFramtidigArbeidsinntekt(), dto.getFramtidigArbeidsinntekt());
        assertEquals(model.getHoyestePensjonsgrad(), dto.getHoyestePensjonsgrad());
        assertEquals(model.getAlderspensjonsdelIProsent(), dto.getAlderspensjonsdelIProsent());
        assertEquals(model.getUforegrad(), dto.getUforegrad());
        assertEquals(model.getForventetInntekt() *100, dto.getForventetInntekt());
        assertEquals(model.getOvergangsstonadTilPensjon(), dto.getOvergangsstonadTilPensjon());
        assertEquals(model.getTilleggspensjonForGjenlevendePensjonIProsent(), dto.getTilleggspensjonForGjenlevendePensjonIProsent());
        assertEquals(model.getFramleggsdato(), dto.getFramleggsdato());
        assertEquals(model.getOpphortOvergangsstonadGjennlevende(), dto.getOpphortOvergangsstonadGjennlevende());
        assertEquals(model.getNyttNavnPensjonist(), dto.getNyttNavnPensjonist());
        assertEquals(model.getNyttNavnEps(), dto.getNyttNavnEps());
        assertEquals(model.getFodselsnummerEktefelle(), dto.getFodselsnummerEktefelle());
        assertEquals(model.getNavnEktefelle(), dto.getNavnEktefelle());
        assertEquals(model.getSkilsmisse(), dto.getSkilsmisse());
        assertEquals(model.getFlyttetFraHverandre(), dto.getFlyttetFraHverandre());
        assertEquals(model.getFlyttetSammen(), dto.getFlyttetSammen());
        assertEquals(model.getInntektMinst4G(), dto.getInntektMinst4G());
        assertEquals(model.getInntektUnder4G(), dto.getInntektUnder4G());
        assertEquals(model.getYrkeUforegrad(), dto.getYrkeUforegrad());
    }

    @Test
    public void thatGrunnblankettEndringsblankettDtoIsMappedCorrectlyToJson() {
        Map<String, Object> expected = new HashMap<>();
        expected.put("framtidigArbeidsinntekt", 1010);
        expected.put("hoyestePensjonsgrad", "??");
        expected.put("alderspensjonsdelIProsent", 1111);
        expected.put("uforegrad", 1212);
        expected.put("forventetInntekt", 131300);
        expected.put("overgangsstonadTilPensjon", "??");
        expected.put("tilleggspensjonForGjenlevendePensjonIProsent", 1414);
        expected.put("framleggsdato", 1515);
        expected.put("opphortOvergangsstonadGjennlevende", "??");
        expected.put("nyttNavnPensjonist", "??");
        expected.put("nyttNavnEps", "??");
        expected.put("fodselsnummerEktefelle", "1616");
        expected.put("navnEktefelle", "??");
        expected.put("skilsmisse", "??");
        expected.put("flyttetFraHverandre", "??");
        expected.put("flyttetSammen", "??");
        expected.put("inntektMinst4G", "??");
        expected.put("inntektUnder4G", "??");
        expected.put("yrkeUforegrad", 1717);

        assertThatJson(dto).isEqualTo(expected);

    }

}