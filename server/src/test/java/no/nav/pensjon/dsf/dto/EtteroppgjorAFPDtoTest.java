package no.nav.pensjon.dsf.dto;

import no.nav.pensjon.dsf.domene.EtteroppgjorAFP;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import java.util.HashMap;
import java.util.Map;

import static net.javacrumbs.jsonunit.fluent.JsonFluentAssert.assertThatJson;
import static org.junit.Assert.assertEquals;

public class EtteroppgjorAFPDtoTest {
    private ModelMapper modelMapper = new ModelMapper();

    private EtteroppgjorAFP etteroppgjorAFP;

    private EtteroppgjorAFPDto etteroppgjorAFPDto;

    @Before
    public void setUp() {
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
    public void tearDown() {
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
        Map<String, Object> expected = new HashMap<>();
        expected.put("differanseForLiteUtbetalt", 1010);
        expected.put("differanseForMyeUtbetalt", 1111);
        expected.put("faktiskUtbetalt", 1212);
        expected.put("fullAFPiAvregningsperioden", 1313);
        expected.put("inntektEtterOpphor", 1414);
        expected.put("inntektForUttakAvAFP", 1515);
        expected.put("inntektsAar", 1616);
        expected.put("inntektIAFPPerioden", 1717);
        expected.put("oppgittFramtidigInntekt", 1818);
        expected.put("pensjonsgivendeInntekt", 1919);
        expected.put("tidligereInntekt", 2020);
        expected.put("beregnetEllerRegistrertViaInfotrygd", "??");
        expected.put("registertViaDSFEllerInfotrygdIEO", "??");
        expected.put("registertViaDSFEllerInfotrygdIFU", "??");

        assertThatJson(etteroppgjorAFPDto).isEqualTo(expected);

    }

}