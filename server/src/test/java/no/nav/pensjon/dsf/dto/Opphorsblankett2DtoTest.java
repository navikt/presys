package no.nav.pensjon.dsf.dto;

import no.nav.pensjon.dsf.domene.grunnblanketter.OPPHBL2;
import no.nav.pensjon.test.IsMapWithSize;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import static net.javacrumbs.jsonunit.fluent.JsonFluentAssert.assertThatJson;
import static org.hamcrest.Matchers.hasEntry;
import static org.junit.Assert.assertEquals;

public class Opphorsblankett2DtoTest {
    private ModelMapper modelMapper = new ModelMapper();

    private OPPHBL2 opphorsblankett;

    private Opphorsblankett2Dto opphorsblankettDto;

    @Before
    public void setUp() {
        opphorsblankett = new OPPHBL2();
        opphorsblankett.setEktefelletilleggStoppes("??");
        opphorsblankett.setOpphorskode("??");

        opphorsblankettDto = modelMapper.map(opphorsblankett, Opphorsblankett2Dto.class);
    }

    @After
    public void tearDown() {
        opphorsblankett = null;
        opphorsblankettDto = null;
    }

    @Test
    public void thatOpphorsblankettIsMappedCorrectlyToDto() {
        assertEquals(opphorsblankett.getEktefelletilleggStoppes(), opphorsblankettDto.getEktefelletilleggStoppes());
        assertEquals(opphorsblankett.getOpphorskode(), opphorsblankettDto.getOpphorskode());
    }

    @Test
    public void thatOpphorsblankett2DtoIsMappedCorrectlyToJson() {
        assertThatJson(opphorsblankettDto)
                .matches(IsMapWithSize.hasSize(2))
                .matches(hasEntry("ektefelletilleggStoppes", "??"))
                .matches(hasEntry("opphorskode", "??"));
    }

}