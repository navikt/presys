package no.nav.pensjon.dsf.dto;

import no.nav.pensjon.dsf.domene.grunnblanketter.GRUNNBIF;
import no.nav.pensjon.test.IsMapWithSize;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;

import static net.javacrumbs.jsonunit.fluent.JsonFluentAssert.assertThatJson;
import static org.hamcrest.Matchers.hasEntry;
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
        assertThatJson(grunnblankettDto)
                .matches(IsMapWithSize.hasSize(7))
                .matches(hasEntry("antallBarnetillegg", BigDecimal.valueOf(1010)))
                .matches(hasEntry("arbeidsinntekt", BigDecimal.valueOf(1111)))
                .matches(hasEntry("arbeidsinntektEktefelle", BigDecimal.valueOf(1212)))
                .matches(hasEntry("pensjonsinntekt", BigDecimal.valueOf(1313)))
                .matches(hasEntry("pensjonsinntektEktefelle", BigDecimal.valueOf(1414)))
                .matches(hasEntry("ektefelletillegg", "??"))
                .node("ektefelle")
                    .matches(hasEntry("fnr", "??"))
                    .matches(hasEntry("navn", "??"));
    }
}