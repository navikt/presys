package no.nav.pensjon.dsf.dto;

import no.nav.pensjon.dsf.domene.grunnblanketter.GRUNNBU3;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;
import static net.javacrumbs.jsonunit.fluent.JsonFluentAssert.assertThatJson;

public class GrunnblankettUforepensjonDtoTest {
    private ModelMapper modelMapper = new ModelMapper();

    private GRUNNBU3 model;

    private GrunnblankettUforepensjonDto dto;

    @Before
    public void setUp() {
        model = new GRUNNBU3();
        model.setAttforingUfor("??");
        model.setNavn("??");
        model.setBosattNorge("??");
        model.setEktefelletillegg("??");
        model.setBarnetillegg("??");
        model.setVernepliktaar1(1010);
        model.setVernepliktaar2(1111);
        model.setVernepliktaar3(1212);
        model.setVernepliktaar4(1313);
        model.setVilkaarPar8Pkt4Ledd3BokstavA("??");
        model.setPensjonsgivendeInntekt(1414);
        model.setYngsteBarnFodselsaar(0);
        model.setYrkesskadetillegg("??");
        model.setYrkesmessigAttforing("??");
        model.setUtdanning(1515);
        model.setYrke(1616);
        model.setUforegrad(1717);
        model.setUforetidspunkt(1818);
        model.setFriinntektDato(1919);
        model.setVirkningsdato(2020);
        model.setFodselsnummerEktefelle("2121");
        model.setNavnEktefelle("??");
        model.setStatsborgerskap(2222);
        model.setBosattLand(2323);
        model.setUnntakPar12Pkt2("??");
        model.setStonadstilfelleDato3B(2424);
        model.setFravikPar2Pkt1Ledd3BokstavC("??");
        model.setStonadstilfelleDato3C(2525);
        model.setPensjonstrygdet("??");
        model.setGrunnPensjonBeregnetPaaTrygdetidLikPoengaar("??");
        model.setMinst20Aar("??");
        model.setFolgerKonvensjonMedAndreLand("??");
        model.setKonvensjonsLand(2626);
        model.setFravikBosattEOS("??");
        model.setFravikPar8Pkt1("??");
        model.setTrygdetidLikPoengaar("??");
        model.setBeregneFramtidigTrygdetid("??");
        model.setBeregneFaktiskTrygdetid("??");
        model.setUngUfor("??");
        model.setGodkjentFlyktningUDI("??");
        model.setOverkompensert("??");
        model.setTrygdetidFra1937Aar(2727);
        model.setTrygdetidFra1937Maaneder(2828);
        model.setTrygdetidFor1967Aar(2929);
        model.setTrygdetidEtter1966Aar(3030);
        model.setTrygdetidEtter1966Maaneder(3131);
        model.setTrygdetidFor1967AarEktefelle(3232);
        model.setTrygdetidEtter1966AarEktefelle(3333);
        model.setTrygdetidEtter1966MaanederEktefelle(3434);
        model.setFravikpar19Pkt3("??");
        model.setTrygdetidEndres("??");
        model.setTrygdetidAnnetNordiskLand("??");
        model.setIkkeBeregneGrunnpensjon("??");
        model.setAvkorteSaertillegg("??");
        model.setTilleggspensjonFraAnnetNordiskland(3535);
        model.setTilleggspensjonsland(3636);
        model.setBeregningKonvensjon("??");
        model.setTrygdetidKonvensjonAar(3737);
        model.setBeregneFolketrygd("??");
        model.setEosPar8Pkt4Ledd3BokstavA("??");
        model.setTeoretiskTrygdetidEOSAar(3838);
        model.setTeoretiskTrygdetidEOSMaaneder(3939);
        model.setProrataTrygdetidEOSAar(4040);
        model.setProrataTrygdetidEOSMaaneder(4141);
        model.setPensjonEOS(4242);
        model.setPoengaarIEOS(new boolean[] {true, false});
        model.setInntektForUforepensjon(4343);
        model.setFaktiskNordiskTrygdetidAar(4444);
        model.setFaktiskNordiskTrygdetidMaaneder(4545);
        model.setFaktiskeNordiskePoengaar(4646);
        model.setReaktivisering("??");
        model.setUnntakVentetid("??");
        model.setEktefelleInntektOver2G("??");
        model.setGarantiTilleggspensjon("??");
        model.setFrysp5AarArbeid("??");
        model.setFryspTidsb("??");
        model.setPoengaarIEOSIkkeMedIProrata(new boolean[] {false, true});
        model.setReduksjonGrunnpensjonEtterPar3Pkt2Ledd5("??");
        model.setEosOpplysning("??");
        model.setLonnstilskudd("??");

        dto = modelMapper.map(model, GrunnblankettUforepensjonDto.class);
    }

    @After
    public void tearDown() {
        model = null;
        dto = null;
    }

    @Test
    public void thatGRUNNBU3IsMappedCorrectlyToDto() {
        assertEquals(model.getAttforingUfor(), dto.getAttforingUfor());
        assertEquals(model.getNavn(), dto.getNavn());
        assertEquals(model.getBosattNorge(), dto.getBosattNorge());
        assertEquals(model.getEktefelletillegg(), dto.getEktefelletillegg());
        assertEquals(model.getBarnetillegg(), dto.getBarnetillegg());
        assertEquals(model.getVernepliktaar1(), dto.getVernepliktaar1());
        assertEquals(model.getVernepliktaar2(), dto.getVernepliktaar2());
        assertEquals(model.getVernepliktaar3(), dto.getVernepliktaar3());
        assertEquals(model.getVernepliktaar4(), dto.getVernepliktaar4());
        assertEquals(model.getVilkaarPar8Pkt4Ledd3BokstavA(), dto.getVilkaarPar8Pkt4Ledd3BokstavA());
        assertEquals(model.getPensjonsgivendeInntekt(), dto.getPensjonsgivendeInntekt());
        assertEquals(model.getYngsteBarnFodselsaar(), dto.getYngsteBarnFodselsaar());
        assertEquals(model.getYrkesskadetillegg(), dto.getYrkesskadetillegg());
        assertEquals(model.getYrkesmessigAttforing(), dto.getYrkesmessigAttforing());
        assertEquals(model.getUtdanning(), dto.getUtdanning());
        assertEquals(model.getYrke(), dto.getYrke());
        assertEquals(model.getUforegrad(), dto.getUforegrad());
        assertEquals(model.getUforetidspunkt(), dto.getUforetidspunkt());
        assertEquals(model.getFriinntektDato(), dto.getFriinntektDato());
        assertEquals(model.getVirkningsdato(), dto.getVirkningsdato());
        assertEquals(model.getFodselsnummerEktefelle(), dto.getFodselsnummerEktefelle());
        assertEquals(model.getNavnEktefelle(), dto.getNavnEktefelle());
        assertEquals(model.getStatsborgerskap(), dto.getStatsborgerskap());
        assertEquals(model.getBosattLand(), dto.getBosattLand());
        assertEquals(model.getUnntakPar12Pkt2(), dto.getUnntakPar12Pkt2());
        assertEquals(model.getStonadstilfelleDato3B(), dto.getStonadstilfelleDato3B());
        assertEquals(model.getFravikPar2Pkt1Ledd3BokstavC(), dto.getFravikPar2Pkt1Ledd3BokstavC());
        assertEquals(model.getStonadstilfelleDato3C(), dto.getStonadstilfelleDato3C());
        assertEquals(model.getPensjonstrygdet(), dto.getPensjonstrygdet());
        assertEquals(model.getGrunnPensjonBeregnetPaaTrygdetidLikPoengaar(), dto.getGrunnPensjonBeregnetPaaTrygdetidLikPoengaar());
        assertEquals(model.getMinst20Aar(), dto.getMinst20Aar());
        assertEquals(model.getFolgerKonvensjonMedAndreLand(), dto.getFolgerKonvensjonMedAndreLand());
        assertEquals(model.getKonvensjonsLand(), dto.getKonvensjonsLand());
        assertEquals(model.getFravikBosattEOS(), dto.getFravikBosattEOS());
        assertEquals(model.getFravikPar8Pkt1(), dto.getFravikPar8Pkt1());
        assertEquals(model.getTrygdetidLikPoengaar(), dto.getTrygdetidLikPoengaar());
        assertEquals(model.getBeregneFramtidigTrygdetid(), dto.getBeregneFramtidigTrygdetid());
        assertEquals(model.getBeregneFaktiskTrygdetid(), dto.getBeregneFaktiskTrygdetid());
        assertEquals(model.getUngUfor(), dto.getUngUfor());
        assertEquals(model.getGodkjentFlyktningUDI(), dto.getGodkjentFlyktningUDI());
        assertEquals(model.getOverkompensert(), dto.getOverkompensert());
        assertEquals(model.getTrygdetidFra1937Aar(), dto.getTrygdetidFra1937Aar());
        assertEquals(model.getTrygdetidFra1937Maaneder(), dto.getTrygdetidFra1937Maaneder());
        assertEquals(model.getTrygdetidFor1967Aar(), dto.getTrygdetidFor1967Aar());
        assertEquals(model.getTrygdetidEtter1966Aar(), dto.getTrygdetidEtter1966Aar());
        assertEquals(model.getTrygdetidEtter1966Maaneder(), dto.getTrygdetidEtter1966Maaneder());
        assertEquals(model.getTrygdetidFor1967AarEktefelle(), dto.getTrygdetidFor1967AarEktefelle());
        assertEquals(model.getTrygdetidEtter1966AarEktefelle(), dto.getTrygdetidEtter1966AarEktefelle());
        assertEquals(model.getTrygdetidEtter1966MaanederEktefelle(), dto.getTrygdetidEtter1966MaanederEktefelle());
        assertEquals(model.getFravikpar19Pkt3(), dto.getFravikpar19Pkt3());
        assertEquals(model.getTrygdetidEndres(), dto.getTrygdetidEndres());
        assertEquals(model.getTrygdetidAnnetNordiskLand(), dto.getTrygdetidAnnetNordiskLand());
        assertEquals(model.getIkkeBeregneGrunnpensjon(), dto.getIkkeBeregneGrunnpensjon());
        assertEquals(model.getAvkorteSaertillegg(), dto.getAvkorteSaertillegg());
        assertEquals(model.getTilleggspensjonFraAnnetNordiskland(), dto.getTilleggspensjonFraAnnetNordiskland());
        assertEquals(model.getTilleggspensjonsland(), dto.getTilleggspensjonsland());
        assertEquals(model.getBeregningKonvensjon(), dto.getBeregningKonvensjon());
        assertEquals(model.getTrygdetidKonvensjonAar(), dto.getTrygdetidKonvensjonAar());
        assertEquals(model.getBeregneFolketrygd(), dto.getBeregneFolketrygd());
        assertEquals(model.getEosPar8Pkt4Ledd3BokstavA(), dto.getEosPar8Pkt4Ledd3BokstavA());
        assertEquals(model.getTeoretiskTrygdetidEOSAar(), dto.getTeoretiskTrygdetidEOSAar());
        assertEquals(model.getTeoretiskTrygdetidEOSMaaneder(), dto.getTeoretiskTrygdetidEOSMaaneder());
        assertEquals(model.getProrataTrygdetidEOSAar(), dto.getProrataTrygdetidEOSAar());
        assertEquals(model.getProrataTrygdetidEOSMaaneder(), dto.getProrataTrygdetidEOSMaaneder());
        assertEquals(model.getPensjonEOS(), dto.getPensjonEOS());
        assertEquals( Arrays.asList(1967), dto.getPoengaarIEOS());
        assertEquals(model.getInntektForUforepensjon(), dto.getInntektForUforepensjon());
        assertEquals(model.getFaktiskNordiskTrygdetidAar(), dto.getFaktiskNordiskTrygdetidAar());
        assertEquals(model.getFaktiskNordiskTrygdetidMaaneder(), dto.getFaktiskNordiskTrygdetidMaaneder());
        assertEquals(model.getFaktiskeNordiskePoengaar(), dto.getFaktiskeNordiskePoengaar());
        assertEquals(model.getReaktivisering(), dto.getReaktivisering());
        assertEquals(model.getUnntakVentetid(), dto.getUnntakVentetid());
        assertEquals(model.getEktefelleInntektOver2G(), dto.getEktefelleInntektOver2G());
        assertEquals(model.getGarantiTilleggspensjon(), dto.getGarantiTilleggspensjon());
        assertEquals(model.getFrysp5AarArbeid(), dto.getFrysp5AarArbeid());
        assertEquals(model.getFryspTidsb(), dto.getFryspTidsb());
        assertEquals( Arrays.asList(1968), dto.getPoengaarIEOSIkkeMedIProrata());
        assertEquals(model.getReduksjonGrunnpensjonEtterPar3Pkt2Ledd5(), dto.getReduksjonGrunnpensjonEtterPar3Pkt2Ledd5());
        assertEquals(model.getEosOpplysning(), dto.getEosOpplysning());
        assertEquals(model.getLonnstilskudd(), dto.getLonnstilskudd());
    }

    @Test
    public void thatGrunnblankettUforepensjonDtoIsMappedCorrectlyToJson() {
        Map<String, Object> expected = new HashMap<>();
        expected.put("attforingUfor", "??");
        expected.put("navn", "??");
        expected.put("bosattNorge", "??");
        expected.put("ektefelletillegg", "??");
        expected.put("barnetillegg", "??");
        expected.put("vernepliktaar1", 1010);
        expected.put("vernepliktaar2", 1111);
        expected.put("vernepliktaar3", 1212);
        expected.put("vernepliktaar4", 1313);
        expected.put("vilkaarPar8Pkt4Ledd3BokstavA", "??");
        expected.put("pensjonsgivendeInntekt", 1414);
        expected.put("yngsteBarnFodselsaar", 0);
        expected.put("yrkesskadetillegg", "??");
        expected.put("yrkesmessigAttforing", "??");
        expected.put("utdanning", 1515);
        expected.put("yrke", 1616);
        expected.put("uforegrad", 1717);
        expected.put("uforetidspunkt", 1818);
        expected.put("friinntektDato", 1919);
        expected.put("virkningsdato", 2020);
        expected.put("fodselsnummerEktefelle", "2121");
        expected.put("navnEktefelle", "??");
        expected.put("statsborgerskap", 2222);
        expected.put("bosattLand", 2323);
        expected.put("unntakPar12Pkt2", "??");
        expected.put("stonadstilfelleDato3B", 2424);
        expected.put("fravikPar2Pkt1Ledd3BokstavC", "??");
        expected.put("stonadstilfelleDato3C", 2525);
        expected.put("pensjonstrygdet", "??");
        expected.put("grunnPensjonBeregnetPaaTrygdetidLikPoengaar", "??");
        expected.put("minst20Aar", "??");
        expected.put("folgerKonvensjonMedAndreLand", "??");
        expected.put("konvensjonsLand", 2626);
        expected.put("fravikBosattEOS", "??");
        expected.put("fravikPar8Pkt1", "??");
        expected.put("trygdetidLikPoengaar", "??");
        expected.put("beregneFramtidigTrygdetid", "??");
        expected.put("beregneFaktiskTrygdetid", "??");
        expected.put("ungUfor", "??");
        expected.put("godkjentFlyktningUDI", "??");
        expected.put("overkompensert", "??");
        expected.put("trygdetidFra1937Aar", 2727);
        expected.put("trygdetidFra1937Maaneder", 2828);
        expected.put("trygdetidFor1967Aar", 2929);
        expected.put("trygdetidEtter1966Aar", 3030);
        expected.put("trygdetidEtter1966Maaneder", 3131);
        expected.put("trygdetidFor1967AarEktefelle", 3232);
        expected.put("trygdetidEtter1966AarEktefelle", 3333);
        expected.put("trygdetidEtter1966MaanederEktefelle", 3434);
        expected.put("fravikpar19Pkt3", "??");
        expected.put("trygdetidEndres", "??");
        expected.put("trygdetidAnnetNordiskLand", "??");
        expected.put("ikkeBeregneGrunnpensjon", "??");
        expected.put("avkorteSaertillegg", "??");
        expected.put("tilleggspensjonFraAnnetNordiskland", 3535);
        expected.put("tilleggspensjonsland", 3636);
        expected.put("beregningKonvensjon", "??");
        expected.put("trygdetidKonvensjonAar", 3737);
        expected.put("beregneFolketrygd", "??");
        expected.put("eosPar8Pkt4Ledd3BokstavA", "??");
        expected.put("teoretiskTrygdetidEOSAar", 3838);
        expected.put("teoretiskTrygdetidEOSMaaneder", 3939);
        expected.put("prorataTrygdetidEOSAar", 4040);
        expected.put("prorataTrygdetidEOSMaaneder", 4141);
        expected.put("pensjonEOS", 4242);
        expected.put("poengaarIEOS", Arrays.asList(1967));
        expected.put("inntektForUforepensjon", 4343);
        expected.put("faktiskNordiskTrygdetidAar", 4444);
        expected.put("faktiskNordiskTrygdetidMaaneder", 4545);
        expected.put("faktiskeNordiskePoengaar", 4646);
        expected.put("reaktivisering", "??");
        expected.put("unntakVentetid", "??");
        expected.put("ektefelleInntektOver2G", "??");
        expected.put("garantiTilleggspensjon", "??");
        expected.put("frysp5AarArbeid", "??");
        expected.put("fryspTidsb", "??");
        expected.put("poengaarIEOSIkkeMedIProrata",  Arrays.asList(1968));
        expected.put("reduksjonGrunnpensjonEtterPar3Pkt2Ledd5", "??");
        expected.put("eosOpplysning", "??");
        expected.put("lonnstilskudd", "??");

        assertThatJson(dto).isEqualTo(expected);

    }

}