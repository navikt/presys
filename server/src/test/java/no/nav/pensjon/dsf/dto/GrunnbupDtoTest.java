package no.nav.pensjon.dsf.dto;

import no.nav.pensjon.dsf.domene.grunnblanketter.Grunnbup;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import java.util.HashMap;
import java.util.Map;

import static net.javacrumbs.jsonunit.fluent.JsonFluentAssert.assertThatJson;
import static org.junit.Assert.assertEquals;

public class GrunnbupDtoTest {
    private ModelMapper modelMapper = new ModelMapper();

    private Grunnbup grunnbup;

    private GrunnbupDto grunnbupDto;

    @Before
    public void setUp() {
        grunnbup = new Grunnbup();
        grunnbup.setAnntallBarn(1010);
        grunnbup.setAttforingUfore("??");
        grunnbup.setBosattLand(1111);
        grunnbup.setEktefelletillegg("??");
        grunnbup.setFodselsnummerEktefelle(1212);
        grunnbup.setFravik81("??");
        grunnbup.setFravik193("??");
        grunnbup.setFravikBosatt("??");
        grunnbup.setFravikFlyktning("??");
        grunnbup.setFravikTrygdet3Aar("??");
        grunnbup.setIkkeGrunnpensjon("??");
        grunnbup.setInntektForUforepensjon(1313);
        grunnbup.setInntektMinst4G("??");
        grunnbup.setKonvensjon("??");
        grunnbup.setNavnEktefelle("??");
        grunnbup.setNorskINorgeMedlem("??");
        grunnbup.setOverkompUtl("??");
        grunnbup.setPensjonsgivendeInntekt(1414);
        grunnbup.setStatsborgerskap(1515);
        grunnbup.setTrygd3("??");
        grunnbup.setTrygdetidEtter1966Aar(1616);
        grunnbup.setTrygdetidEtter1966AarEktefelle(1717);
        grunnbup.setTrygdetidEtter1966Maaneder(1818);
        grunnbup.setTrygdetidEtter1966MaanederEktefelle(1919);
        grunnbup.setTrygdetidFor1967(2020);
        grunnbup.setTrygdetidFor1967Ektefelle(2121);
        grunnbup.setTtfmt81(2222);
        grunnbup.setTtFramtUft(2323);
        grunnbup.setUforegrad(2424);
        grunnbup.setUforetidspunkt(2525);
        grunnbup.setUforUnderBotid("??");
        grunnbup.setVernepliktAar1(2626);
        grunnbup.setVernepliktAar2(2727);
        grunnbup.setVernepliktAar3(2828);
        grunnbup.setVernepliktAar4(2929);
        grunnbup.setVilkaar81B("??");
        grunnbup.setVilkaar843A("??");
        grunnbup.setYrke(3030);
        grunnbup.setYrkesskadetillegg("??");

        grunnbupDto = modelMapper.map(grunnbup, GrunnbupDto.class);
    }

    @After
    public void tearDown() {
        grunnbup = null;
        grunnbupDto = null;
    }

    @Test
    public void thatGrunnbupIsMappedCorrectlyToDto() {
        assertEquals(grunnbup.getAnntallBarn(), grunnbupDto.getAnntallBarn());
        assertEquals(grunnbup.getBosattLand(), grunnbupDto.getBosattLand());
        assertEquals(grunnbup.getFodselsnummerEktefelle(), grunnbupDto.getFodselsnummerEktefelle());
        assertEquals(grunnbup.getInntektForUforepensjon(), grunnbupDto.getInntektForUforepensjon());
        assertEquals(grunnbup.getPensjonsgivendeInntekt(), grunnbupDto.getPensjonsgivendeInntekt());
        assertEquals(grunnbup.getStatsborgerskap(), grunnbupDto.getStatsborgerskap());
        assertEquals(grunnbup.getTrygdetidEtter1966Aar(), grunnbupDto.getTrygdetidEtter1966Aar());
        assertEquals(grunnbup.getTrygdetidEtter1966AarEktefelle(), grunnbupDto.getTrygdetidEtter1966AarEktefelle());
        assertEquals(grunnbup.getTrygdetidEtter1966Maaneder(), grunnbupDto.getTrygdetidEtter1966Maaneder());
        assertEquals(grunnbup.getTrygdetidEtter1966MaanederEktefelle(), grunnbupDto.getTrygdetidEtter1966MaanederEktefelle());
        assertEquals(grunnbup.getTrygdetidFor1967(), grunnbupDto.getTrygdetidFor1967());
        assertEquals(grunnbup.getTrygdetidFor1967Ektefelle(), grunnbupDto.getTrygdetidFor1967Ektefelle());
        assertEquals(grunnbup.getTtfmt81(), grunnbupDto.getTtfmt81());
        assertEquals(grunnbup.getTtFramtUft(), grunnbupDto.getTtFramtUft());
        assertEquals(grunnbup.getUforegrad(), grunnbupDto.getUforegrad());
        assertEquals(grunnbup.getUforetidspunkt(), grunnbupDto.getUforetidspunkt());
        assertEquals(grunnbup.getVernepliktAar1(), grunnbupDto.getVernepliktAar1());
        assertEquals(grunnbup.getVernepliktAar2(), grunnbupDto.getVernepliktAar2());
        assertEquals(grunnbup.getVernepliktAar3(), grunnbupDto.getVernepliktAar3());
        assertEquals(grunnbup.getVernepliktAar4(), grunnbupDto.getVernepliktAar4());
        assertEquals(grunnbup.getYrke(), grunnbupDto.getYrke());
        assertEquals(grunnbup.getAttforingUfore(), grunnbupDto.getAttforingUfore());
        assertEquals(grunnbup.getEktefelletillegg(), grunnbupDto.getEktefelletillegg());
        assertEquals(grunnbup.getFravik81(), grunnbupDto.getFravik81());
        assertEquals(grunnbup.getFravik193(), grunnbupDto.getFravik193());
        assertEquals(grunnbup.getFravikBosatt(), grunnbupDto.getFravikBosatt());
        assertEquals(grunnbup.getFravikFlyktning(), grunnbupDto.getFravikFlyktning());
        assertEquals(grunnbup.getFravikTrygdet3Aar(), grunnbupDto.getFravikTrygdet3Aar());
        assertEquals(grunnbup.getIkkeGrunnpensjon(), grunnbupDto.getIkkeGrunnpensjon());
        assertEquals(grunnbup.getInntektMinst4G(), grunnbupDto.getInntektMinst4G());
        assertEquals(grunnbup.getKonvensjon(), grunnbupDto.getKonvensjon());
        assertEquals(grunnbup.getNavnEktefelle(), grunnbupDto.getNavnEktefelle());
        assertEquals(grunnbup.getNorskINorgeMedlem(), grunnbupDto.getNorskINorgeMedlem());
        assertEquals(grunnbup.getOverkompUtl(), grunnbupDto.getOverkompUtl());
        assertEquals(grunnbup.getTrygd3(), grunnbupDto.getTrygd3());
        assertEquals(grunnbup.getUforUnderBotid(), grunnbupDto.getUforUnderBotid());
        assertEquals(grunnbup.getVilkaar81B(), grunnbupDto.getVilkaar81B());
        assertEquals(grunnbup.getVilkaar843A(), grunnbupDto.getVilkaar843A());
        assertEquals(grunnbup.getYrkesskadetillegg(), grunnbupDto.getYrkesskadetillegg());
    }

    @Test
    public void thatGrunnbupDtoIsMappedCorrectlyToJson() {
        Map<String, Object> expected = new HashMap<>();
        expected.put("ektefelletillegg", "??");
        expected.put("anntallBarn", 1010);
        expected.put("uforegrad", 2424);
        expected.put("uforetidspunkt", 2525);
        expected.put("yrke", 3030);
        expected.put("vilkaar843A", "??");
        expected.put("vilkaar81B", "??");
        expected.put("fodselsnummerEktefelle", 1212);
        expected.put("navnEktefelle", "??");
        expected.put("norskINorgeMedlem", "??");
        expected.put("vernepliktAar1", 2626);
        expected.put("vernepliktAar2", 2727);
        expected.put("vernepliktAar3", 2828);
        expected.put("vernepliktAar4", 2929);
        expected.put("pensjonsgivendeInntekt", 1414);
        expected.put("overkompUtl", "??");
        expected.put("uforUnderBotid", "??");
        expected.put("trygdetidFor1967", 2020);
        expected.put("trygdetidEtter1966Aar", 1616);
        expected.put("trygdetidEtter1966Maaneder", 1818);
        expected.put("trygdetidFor1967Ektefelle", 2121);
        expected.put("statsborgerskap", 1515);
        expected.put("bosattLand", 1111);
        expected.put("fravikBosatt", "??");
        expected.put("trygd3", "??");
        expected.put("fravikTrygdet3Aar", "??");
        expected.put("fravik81", "??");
        expected.put("konvensjon", "??");
        expected.put("fravik193", "??");
        expected.put("fravikFlyktning", "??");
        expected.put("trygdetidEtter1966AarEktefelle", 1717);
        expected.put("trygdetidEtter1966MaanederEktefelle", 1919);
        expected.put("ttfmt81", 2222);
        expected.put("ttFramtUft", 2323);
        expected.put("ikkeGrunnpensjon", "??");
        expected.put("inntektMinst4G", "??");
        expected.put("attforingUfore", "??");
        expected.put("yrkesskadetillegg", "??");
        expected.put("inntektForUforepensjon", 1313);

        assertThatJson(grunnbupDto).isEqualTo(expected);

    }
}