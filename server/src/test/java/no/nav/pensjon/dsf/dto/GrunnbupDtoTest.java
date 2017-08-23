package no.nav.pensjon.dsf.dto;

import no.nav.pensjon.dsf.domene.grunnblanketter.Grunnbup;
import no.nav.pensjon.test.IsMapWithSize;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;

import static net.javacrumbs.jsonunit.fluent.JsonFluentAssert.assertThatJson;
import static org.hamcrest.Matchers.hasEntry;
import static org.junit.Assert.assertEquals;

public class GrunnbupDtoTest {
    private ModelMapper modelMapper = new ModelMapper();

    private Grunnbup grunnbup;

    private GrunnbupDto grunnbupDto;

    @Before
    public void setUp() throws Exception {
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
    public void tearDown() throws Exception {
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
        assertThatJson(grunnbupDto)
                .matches(IsMapWithSize.hasSize(39))
                .matches(hasEntry("ektefelletillegg", "??"))
                .matches(hasEntry("anntallBarn", BigDecimal.valueOf(1010)))
                .matches(hasEntry("uforegrad", BigDecimal.valueOf(2424)))
                .matches(hasEntry("uforetidspunkt", BigDecimal.valueOf(2525)))
                .matches(hasEntry("yrke", BigDecimal.valueOf(3030)))
                .matches(hasEntry("vilkaar843A", "??"))
                .matches(hasEntry("vilkaar81B", "??"))
                .matches(hasEntry("fodselsnummerEktefelle", BigDecimal.valueOf(1212)))
                .matches(hasEntry("navnEktefelle", "??"))
                .matches(hasEntry("norskINorgeMedlem", "??"))
                .matches(hasEntry("vernepliktAar1", BigDecimal.valueOf(2626)))
                .matches(hasEntry("vernepliktAar2", BigDecimal.valueOf(2727)))
                .matches(hasEntry("vernepliktAar3", BigDecimal.valueOf(2828)))
                .matches(hasEntry("vernepliktAar4", BigDecimal.valueOf(2929)))
                .matches(hasEntry("pensjonsgivendeInntekt", BigDecimal.valueOf(1414)))
                .matches(hasEntry("overkompUtl", "??"))
                .matches(hasEntry("uforUnderBotid", "??"))
                .matches(hasEntry("trygdetidFor1967", BigDecimal.valueOf(2020)))
                .matches(hasEntry("trygdetidEtter1966Aar", BigDecimal.valueOf(1616)))
                .matches(hasEntry("trygdetidEtter1966Maaneder", BigDecimal.valueOf(1818)))
                .matches(hasEntry("trygdetidFor1967Ektefelle", BigDecimal.valueOf(2121)))
                .matches(hasEntry("statsborgerskap", BigDecimal.valueOf(1515)))
                .matches(hasEntry("bosattLand", BigDecimal.valueOf(1111)))
                .matches(hasEntry("fravikBosatt", "??"))
                .matches(hasEntry("trygd3", "??"))
                .matches(hasEntry("fravikTrygdet3Aar", "??"))
                .matches(hasEntry("fravik81", "??"))
                .matches(hasEntry("konvensjon", "??"))
                .matches(hasEntry("fravik193", "??"))
                .matches(hasEntry("fravikFlyktning","??"))
                .matches(hasEntry("trygdetidEtter1966AarEktefelle", BigDecimal.valueOf(1717)))
                .matches(hasEntry("trygdetidEtter1966MaanederEktefelle", BigDecimal.valueOf(1919)))
                .matches(hasEntry("ttfmt81", BigDecimal.valueOf(2222)))
                .matches(hasEntry("ttFramtUft", BigDecimal.valueOf(2323)))
                .matches(hasEntry("ikkeGrunnpensjon", "??"))
                .matches(hasEntry("inntektMinst4G", "??"))
                .matches(hasEntry("attforingUfore", "??"))
                .matches(hasEntry("yrkesskadetillegg", "??"))
                .matches(hasEntry("inntektForUforepensjon", BigDecimal.valueOf(1313)));
    }
}