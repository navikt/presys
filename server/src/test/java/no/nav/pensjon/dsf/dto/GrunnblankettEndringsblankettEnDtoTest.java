package no.nav.pensjon.dsf.dto;

import no.nav.pensjon.dsf.domene.grunnblanketter.ENBLAN1;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import java.util.HashMap;
import java.util.Map;

import static net.javacrumbs.jsonunit.fluent.JsonFluentAssert.assertThatJson;
import static org.junit.Assert.assertEquals;

public class GrunnblankettEndringsblankettEnDtoTest {
    private ModelMapper modelMapper = new ModelMapper();

    private ENBLAN1 model;

    private GrunnblankettEndringsblankettEnDto dto;

    @Before
    public void setUp() {
        model = new ENBLAN1();
        model.setFramtidigArbeidsinntekt(1010);
        model.setUforegrad(1111);
        model.setForventetInntekt(1212);
        model.setFraOvergangsstonadTilPensjon("??");
        model.setFradrag2G("??");
        model.setFramleggsdato(1313);
        model.setOpphortOvergangsstonadGjennlevende("??");
        model.setNyttNavnStonadsmottaker("??");
        model.setNyttNavnEktefelle("??");
        model.setFodselsnummerEktefelle("1414");
        model.setNavnEktefelle("??");
        model.setSkilsmisse("??");
        model.setFlyttetFraHverandre("??");
        model.setFlyttetSammen("??");
        model.setInntektMins4G("??");
        model.setInntektUnder4G("??");
        model.setYrkeUforegrad(1515);
        model.setPensjonsinntekt(1616);
        model.setArbeidsinntekt(1717);
        model.setPensjonsinntektEktefelle(1818);
        model.setArbeidsinntektEktefelle(1919);
        model.setStatsborgerskap(2020);
        model.setBosattLand(2121);
        model.setTilleggspensjonNordiskLand(2222);
        model.setTilleggsPensjonFraNordiskLand(2323);
        model.setPensjonFraEOS(2424);
        model.setSivilstatus("??");
        model.setOpphorSamboer("??");
        model.setInntektForUforepensjon(2525);
        model.setInntektsdato(2626);
        model.setReaktivisering("??");
        model.setUnntattForVentetid("??");
        model.setFrysperiode5Aar("??");
        model.setFrysperiodeTidspunkt("??");
        model.setInntektOver2GEktefelle("??");
        model.setInntektsprovetIEOS("??");
        model.setTrygdetidEOSAar(2727);
        model.setTrygdetidEOSMaaneder(2828);
        model.setEpsInntektOverG("??");
        model.setLonnstilskudd("??");

        dto = modelMapper.map(model, GrunnblankettEndringsblankettEnDto.class);
    }

    @After
    public void tearDown() {
        model = null;
        dto = null;
    }

    @Test
    public void thatENBLAN1IsMappedCorrectlyToDto() {
        assertEquals(model.getFramtidigArbeidsinntekt()*100, dto.getFramtidigArbeidsinntekt());
        assertEquals(model.getUforegrad(), dto.getUforegrad());
        assertEquals(model.getForventetInntekt() *100, dto.getForventetInntekt());
        assertEquals(model.getFraOvergangsstonadTilPensjon(), dto.getFraOvergangsstonadTilPensjon());
        assertEquals(model.getFradrag2G(), dto.getFradrag2G());
        assertEquals(model.getFramleggsdato(), dto.getFramleggsdato());
        assertEquals(model.getOpphortOvergangsstonadGjennlevende(), dto.getOpphortOvergangsstonadGjennlevende());
        assertEquals(model.getNyttNavnStonadsmottaker(), dto.getNyttNavnStonadsmottaker());
        assertEquals(model.getNyttNavnEktefelle(), dto.getNyttNavnEktefelle());
        assertEquals(model.getFodselsnummerEktefelle(), dto.getFodselsnummerEktefelle());
        assertEquals(model.getNavnEktefelle(), dto.getNavnEktefelle());
        assertEquals(model.getSkilsmisse(), dto.getSkilsmisse());
        assertEquals(model.getFlyttetFraHverandre(), dto.getFlyttetFraHverandre());
        assertEquals(model.getFlyttetSammen(), dto.getFlyttetSammen());
        assertEquals(model.getInntektMins4G(), dto.getInntektMins4G());
        assertEquals(model.getInntektUnder4G(), dto.getInntektUnder4G());
        assertEquals(model.getYrkeUforegrad(), dto.getYrkeUforegrad());
        assertEquals(model.getPensjonsinntekt(), dto.getPensjonsinntekt());
        assertEquals(model.getArbeidsinntekt(), dto.getArbeidsinntekt());
        assertEquals(model.getPensjonsinntektEktefelle(), dto.getPensjonsinntektEktefelle());
        assertEquals(model.getArbeidsinntektEktefelle(), dto.getArbeidsinntektEktefelle());
        assertEquals(model.getStatsborgerskap(), dto.getStatsborgerskap());
        assertEquals(model.getBosattLand(), dto.getBosattLand());
        assertEquals(model.getTilleggspensjonNordiskLand(), dto.getTilleggspensjonNordiskLand());
        assertEquals(model.getTilleggsPensjonFraNordiskLand(), dto.getTilleggsPensjonFraNordiskLand());
        assertEquals(model.getPensjonFraEOS(), dto.getPensjonFraEOS());
        assertEquals(model.getSivilstatus(), dto.getSivilstatus());
        assertEquals(model.getOpphorSamboer(), dto.getOpphorSamboer());
        assertEquals(model.getInntektForUforepensjon(), dto.getInntektForUforepensjon());
        assertEquals(model.getInntektsdato(), dto.getInntektsdato());
        assertEquals(model.getReaktivisering(), dto.getReaktivisering());
        assertEquals(model.getUnntattForVentetid(), dto.getUnntattForVentetid());
        assertEquals(model.getFrysperiode5Aar(), dto.getFrysperiode5Aar());
        assertEquals(model.getFrysperiodeTidspunkt(), dto.getFrysperiodeTidspunkt());
        assertEquals(model.getInntektOver2GEktefelle(), dto.getInntektOver2GEktefelle());
        assertEquals(model.getInntektsprovetIEOS(), dto.getInntektsprovetIEOS());
        assertEquals(model.getTrygdetidEOSAar(), dto.getTrygdetidEOSAar());
        assertEquals(model.getTrygdetidEOSMaaneder(), dto.getTrygdetidEOSMaaneder());
        assertEquals(model.getEpsInntektOverG(), dto.getEpsInntektOverG());
        assertEquals(model.getLonnstilskudd(), dto.getLonnstilskudd());
    }

    @Test
    public void thatGrunnblankettEndringsblankettEnDtoIsMappedCorrectlyToJson() {
        Map<String, Object> expected = new HashMap<>();
        expected.put("framtidigArbeidsinntekt", 101000);
        expected.put("uforegrad", 1111);
        expected.put("forventetInntekt", 121200);
        expected.put("fraOvergangsstonadTilPensjon", "??");
        expected.put("fradrag2G", "??");
        expected.put("framleggsdato", 1313);
        expected.put("opphortOvergangsstonadGjennlevende", "??");
        expected.put("nyttNavnStonadsmottaker", "??");
        expected.put("nyttNavnEktefelle", "??");
        expected.put("fodselsnummerEktefelle", "1414");
        expected.put("navnEktefelle", "??");
        expected.put("skilsmisse", "??");
        expected.put("flyttetFraHverandre", "??");
        expected.put("flyttetSammen", "??");
        expected.put("inntektMins4G", "??");
        expected.put("inntektUnder4G", "??");
        expected.put("yrkeUforegrad", 1515);
        expected.put("pensjonsinntekt", 1616);
        expected.put("arbeidsinntekt", 1717);
        expected.put("pensjonsinntektEktefelle", 1818);
        expected.put("arbeidsinntektEktefelle", 1919);
        expected.put("statsborgerskap", 2020);
        expected.put("bosattLand", 2121);
        expected.put("tilleggspensjonNordiskLand", 2222);
        expected.put("tilleggsPensjonFraNordiskLand", 2323);
        expected.put("pensjonFraEOS", 2424);
        expected.put("sivilstatus", "??");
        expected.put("opphorSamboer", "??");
        expected.put("inntektForUforepensjon", 2525);
        expected.put("inntektsdato", 2626);
        expected.put("reaktivisering", "??");
        expected.put("unntattForVentetid", "??");
        expected.put("frysperiode5Aar", "??");
        expected.put("frysperiodeTidspunkt", "??");
        expected.put("inntektOver2GEktefelle", "??");
        expected.put("inntektsprovetIEOS", "??");
        expected.put("trygdetidEOSAar", 2727);
        expected.put("trygdetidEOSMaaneder", 2828);
        expected.put("epsInntektOverG", "??");
        expected.put("lonnstilskudd", "??");

        assertThatJson(dto).isEqualTo(expected);

    }

}