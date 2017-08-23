package no.nav.pensjon.dsf.dto;

import no.nav.pensjon.dsf.domene.grunnblanketter.OPPHBL1;
import no.nav.pensjon.test.IsMapWithSize;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;

import static net.javacrumbs.jsonunit.fluent.JsonFluentAssert.assertThatJson;
import static org.hamcrest.Matchers.hasEntry;
import static org.junit.Assert.assertEquals;

public class Opphorsblankett1DtoTest {
    private ModelMapper modelMapper = new ModelMapper();

    private OPPHBL1 opphorsblankett;

    private Opphorsblankett1Dto opphorsblankettDto;

    @Before
    public void setUp() throws Exception {
        opphorsblankett = new OPPHBL1();
        opphorsblankett.setAvdodesPensjonsgivendeInntekt(1010);
        opphorsblankett.setDodsDato(1111);
        opphorsblankett.setEktefelleFodselsnummer(1212);
        opphorsblankett.setEktefelleNavn("??");

        opphorsblankettDto = modelMapper.map(opphorsblankett, Opphorsblankett1Dto.class);
    }

    @After
    public void tearDown() throws Exception {
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
        assertThatJson(opphorsblankettDto)
                .matches(IsMapWithSize.hasSize(4))
                .matches(hasEntry("avdodesPensjonsgivendeInntekt", BigDecimal.valueOf(1010)))
                .matches(hasEntry("dodsDato", BigDecimal.valueOf(1111)))
                .matches(hasEntry("ektefelleFodselsnummer", BigDecimal.valueOf(1212)))
                .matches(hasEntry("ektefelleNavn", "??"));
    }

}