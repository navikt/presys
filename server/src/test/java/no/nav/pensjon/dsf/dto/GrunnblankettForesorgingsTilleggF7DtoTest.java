package no.nav.pensjon.dsf.dto;

import no.nav.pensjon.dsf.domene.grunnblanketter.GRUNNBIF;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import java.util.HashMap;
import java.util.Map;

import static net.javacrumbs.jsonunit.fluent.JsonFluentAssert.assertThatJson;
import static org.junit.Assert.assertEquals;

public class GrunnblankettForesorgingsTilleggF7DtoTest {
    private ModelMapper modelMapper = new ModelMapper();

    private GRUNNBIF grunnbif;

    private GrunnblankettForesorgingsTilleggF7Dto grunnblankettDto;

    @Before
    public void setUp() {
        grunnbif = new GRUNNBIF();
        grunnbif.setAntallBarnetillegg(1010);
        grunnbif.setArbeidsinntekt(1111);
        grunnbif.setArbeidsinntektEktefelle(1212);
        grunnbif.setEktefelletillegg("??");
        grunnbif.setFnrEktefelle("??");
        grunnbif.setNavnEktefelle("??");
        grunnbif.setPensjonsinntekt(1313);
        grunnbif.setPensjonsinntektEktefelle(1414);

        grunnblankettDto = modelMapper.map(grunnbif, GrunnblankettForesorgingsTilleggF7Dto.class);
    }

    @After
    public void tearDown() {
        grunnbif = null;
        grunnblankettDto = null;
    }

    @Test
    public void thatGrunnbifIsMappedCorrectlyToDto() {
        assertEquals(grunnbif.getAntallBarnetillegg(), grunnblankettDto.getAntallBarnetillegg());
        assertEquals(grunnbif.getArbeidsinntekt(), grunnblankettDto.getArbeidsinntekt());
        assertEquals(grunnbif.getArbeidsinntektEktefelle(), grunnblankettDto.getArbeidsinntektEktefelle());
        assertEquals(grunnbif.getEktefelletillegg(), grunnblankettDto.getEktefelletillegg());
        assertEquals(grunnbif.getPensjonsinntekt(), grunnblankettDto.getPensjonsinntekt());
        assertEquals(grunnbif.getPensjonsinntektEktefelle(), grunnblankettDto.getPensjonsinntektEktefelle());
    }

    @Test
    public void thatGrunnblankettDtoIsMappedCorrectlyToJson() {
        Map<String, Object> ektefelle = new HashMap<>();
        ektefelle.put("fnr", "??");
        ektefelle.put("navn", "??");

        Map<String, Object> expected = new HashMap<>();
        expected.put("antallBarnetillegg", 1010);
        expected.put("arbeidsinntekt", 1111);
        expected.put("arbeidsinntektEktefelle", 1212);
        expected.put("pensjonsinntekt", 1313);
        expected.put("pensjonsinntektEktefelle", 1414);
        expected.put("ektefelletillegg", "??");
        expected.put("ektefelle", ektefelle);

        assertThatJson(grunnblankettDto).isEqualTo(expected);
    }
}