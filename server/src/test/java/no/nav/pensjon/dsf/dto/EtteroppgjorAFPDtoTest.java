package no.nav.pensjon.dsf.dto;

import no.nav.pensjon.dsf.domene.EtteroppgjorAFP;
import no.nav.pensjon.test.IsMapWithSize;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;

import static net.javacrumbs.jsonunit.fluent.JsonFluentAssert.assertThatJson;
import static org.hamcrest.Matchers.hasEntry;
import static org.junit.Assert.assertEquals;

public class EtteroppgjorAFPDtoTest {
    private ModelMapper modelMapper = new ModelMapper();

    private EtteroppgjorAFP etteroppgjorAFP;

    private EtteroppgjorAFPDto etteroppgjorAFPDto;

    @Before
    public void setUp() throws Exception {
        etteroppgjorAFP = new EtteroppgjorAFP();
        etteroppgjorAFP.setBeregnetEllerRegistrertViaInfotrygd("??");
        etteroppgjorAFP.setDifferanseForLiteUtbetalt(1010);
        etteroppgjorAFP.setDifferanseForMyeUtbetalt(1111);
        etteroppgjorAFP.setFaktiskUtbetalt(1212);
        etteroppgjorAFP.setFullAFPiAvregningsperioden(1313);
        etteroppgjorAFP.setInntektEtterOpphor(1414);
        etteroppgjorAFP.setInntektForUttakAvAFP(1515);
        etteroppgjorAFP.setInntektsAar(1616);
        etteroppgjorAFP.setInntektIAFPPerioden(1717);
        etteroppgjorAFP.setOppgittFramtidigInntekt(1818);
        etteroppgjorAFP.setPensjonsgivendeInntekt(1919);
        etteroppgjorAFP.setRegistertViaDSFEllerInfotrygdIEO("??");
        etteroppgjorAFP.setRegistertViaDSFEllerInfotrygdIFU("??");
        etteroppgjorAFP.setTidligereInntekt(2020);

        etteroppgjorAFPDto = modelMapper.map(etteroppgjorAFP, EtteroppgjorAFPDto.class);
    }

    @After
    public void tearDown() throws Exception {
        etteroppgjorAFP = null;
        etteroppgjorAFPDto = null;
    }

    @Test
    public void thatEtteroppgjorAFPIsMappedCorrectlyToDto() {
        assertEquals(etteroppgjorAFP.getBeregnetEllerRegistrertViaInfotrygd(), etteroppgjorAFPDto.getBeregnetEllerRegistrertViaInfotrygd());
        assertEquals(etteroppgjorAFP.getDifferanseForLiteUtbetalt(), etteroppgjorAFPDto.getDifferanseForLiteUtbetalt());
        assertEquals(etteroppgjorAFP.getDifferanseForMyeUtbetalt(), etteroppgjorAFPDto.getDifferanseForMyeUtbetalt());
        assertEquals(etteroppgjorAFP.getFaktiskUtbetalt(), etteroppgjorAFPDto.getFaktiskUtbetalt());
        assertEquals(etteroppgjorAFP.getFullAFPiAvregningsperioden(), etteroppgjorAFPDto.getFullAFPiAvregningsperioden());
        assertEquals(etteroppgjorAFP.getInntektEtterOpphor(), etteroppgjorAFPDto.getInntektEtterOpphor());
        assertEquals(etteroppgjorAFP.getInntektForUttakAvAFP(), etteroppgjorAFPDto.getInntektForUttakAvAFP());
        assertEquals(etteroppgjorAFP.getInntektIAFPPerioden(), etteroppgjorAFPDto.getInntektIAFPPerioden());
        assertEquals(etteroppgjorAFP.getInntektsAar(), etteroppgjorAFPDto.getInntektsAar());
        assertEquals(etteroppgjorAFP.getOppgittFramtidigInntekt(), etteroppgjorAFPDto.getOppgittFramtidigInntekt());
        assertEquals(etteroppgjorAFP.getPensjonsgivendeInntekt(), etteroppgjorAFPDto.getPensjonsgivendeInntekt());
        assertEquals(etteroppgjorAFP.getRegistertViaDSFEllerInfotrygdIEO(), etteroppgjorAFPDto.getRegistertViaDSFEllerInfotrygdIEO());
        assertEquals(etteroppgjorAFP.getRegistertViaDSFEllerInfotrygdIFU(), etteroppgjorAFPDto.getRegistertViaDSFEllerInfotrygdIFU());
        assertEquals(etteroppgjorAFP.getTidligereInntekt(), etteroppgjorAFPDto.getTidligereInntekt());
    }

    @Test
    public void thatEtteroppgjorAFPDtoIsMappedCorrectlyToJson() {
        assertThatJson(etteroppgjorAFPDto)
                .matches(IsMapWithSize.hasSize(14))
                .matches(hasEntry("differanseForLiteUtbetalt", BigDecimal.valueOf(1010)))
                .matches(hasEntry("differanseForMyeUtbetalt", BigDecimal.valueOf(1111)))
                .matches(hasEntry("faktiskUtbetalt", BigDecimal.valueOf(1212)))
                .matches(hasEntry("fullAFPiAvregningsperioden", BigDecimal.valueOf(1313)))
                .matches(hasEntry("inntektEtterOpphor", BigDecimal.valueOf(1414)))
                .matches(hasEntry("inntektForUttakAvAFP", BigDecimal.valueOf(1515)))
                .matches(hasEntry("inntektsAar", BigDecimal.valueOf(1616)))
                .matches(hasEntry("inntektIAFPPerioden", BigDecimal.valueOf(1717)))
                .matches(hasEntry("oppgittFramtidigInntekt", BigDecimal.valueOf(1818)))
                .matches(hasEntry("pensjonsgivendeInntekt", BigDecimal.valueOf(1919)))
                .matches(hasEntry("tidligereInntekt", BigDecimal.valueOf(2020)))
                .matches(hasEntry("beregnetEllerRegistrertViaInfotrygd", "??"))
                .matches(hasEntry("registertViaDSFEllerInfotrygdIEO", "??"))
                .matches(hasEntry("registertViaDSFEllerInfotrygdIFU", "??"));
    }

}