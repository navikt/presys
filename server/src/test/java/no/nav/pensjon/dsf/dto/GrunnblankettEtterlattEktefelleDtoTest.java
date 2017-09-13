package no.nav.pensjon.dsf.dto;

import no.nav.pensjon.dsf.domene.grunnblanketter.GRUNNBE3;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import java.util.HashMap;
import java.util.Map;

import static net.javacrumbs.jsonunit.fluent.JsonFluentAssert.assertThatJson;
import static org.junit.Assert.assertEquals;

public class GrunnblankettEtterlattEktefelleDtoTest {
    private ModelMapper modelMapper = new ModelMapper();

    private GRUNNBE3 model;

    private GrunnblankettEtterlattEktefelleDto dto;

    @Before
    public void setUp() {
        model = new GRUNNBE3();
        model.setBosattNorge("??");
        model.setOmsorgAvdodesBarn("??");
        model.setVilkaarPar10Pkt5("??");
        model.setForventetInntekt(1010);
        model.setFramtidigArbeidsinntekt(1111);
        model.setYtelse("??");
        model.setYrkesskadeTillegg("??");
        model.setFramleggsdato(1212);
        model.setFramleggskode("??");
        model.setFodselsnummerEktefelle("1313");
        model.setNavnEktefelle("??");
        model.setDodsdato(1414);
        model.setBosattNorgeEktefelle("??");
        model.setVilkaarPar8Pkt3Ledd3bokstavA("??");
        model.setVernepliktaar1(1515);
        model.setVernepliktaar2(1616);
        model.setVernepliktaar3(1717);
        model.setVernepliktaar4(1818);
        model.setPensjonsgivendeInntektSisteLeveaar(1919);
        model.setStatsborgerskap(2020);
        model.setBosattLand(2121);
        model.setPensjonstrygdet("??");
        model.setMinst20AarBotid("??");
        model.setFravikPgaKonvensjonAnnetLand("??");
        model.setFlyktning("??");
        model.setOverkompensasjonUtland("??");
        model.setSkalIkkeBeregnesGrunnpenson("??");
        model.setPensjonBeregnesEtterKonvensjonsregler("??");
        model.setGrunnpensjonBeregnesEtterAnnenSamletTrygdetid(2222);
        model.setFramtidigTrygdetidFraDod(2323);
        model.setFaktiskTrygdetidAar(2424);
        model.setFaktiskTrygdetidMaaneder(2525);
        model.setBeregnesEtterNordiskKonvensjon("??");
        model.setVilkaarPar10Pkt5nr2("??");
        model.setMedlemFolketrygdenFra(2626);
        model.setStatsborgerskapEktefelle(2727);
        model.setBosattEktefelle(2828);
        model.setErEktefelleFlyktning("??");
        model.setTrygdetidFra1937EktefelleAar(2929);
        model.setTrygdetidFra1937EktefelleMaaneder(3030);
        model.setOverkompensasjonUtlandEktefelle("??");

        dto = modelMapper.map(model, GrunnblankettEtterlattEktefelleDto.class);
    }

    @After
    public void tearDown() {
        model = null;
        dto = null;
    }

    @Test
    public void thatGRUNNBE3IsMappedCorrectlyToDto() {
        assertEquals(model.getBosattNorge(), dto.getBosattNorge());
        assertEquals(model.getOmsorgAvdodesBarn(), dto.getOmsorgAvdodesBarn());
        assertEquals(model.getVilkaarPar10Pkt5(), dto.getVilkaarPar10Pkt5());
        assertEquals(model.getForventetInntekt(), dto.getForventetInntekt());
        assertEquals(model.getFramtidigArbeidsinntekt(), dto.getFramtidigArbeidsinntekt());
        assertEquals(model.getYtelse(), dto.getYtelse());
        assertEquals(model.getYrkesskadeTillegg(), dto.getYrkesskadeTillegg());
        assertEquals(model.getFramleggsdato(), dto.getFramleggsdato());
        assertEquals(model.getFramleggskode(), dto.getFramleggskode());
        assertEquals(model.getFodselsnummerEktefelle(), dto.getFodselsnummerEktefelle());
        assertEquals(model.getNavnEktefelle(), dto.getNavnEktefelle());
        assertEquals(model.getDodsdato(), dto.getDodsdato());
        assertEquals(model.getBosattNorgeEktefelle(), dto.getBosattNorgeEktefelle());
        assertEquals(model.getVilkaarPar8Pkt3Ledd3bokstavA(), dto.getVilkaarPar8Pkt3Ledd3bokstavA());
        assertEquals(model.getVernepliktaar1(), dto.getVernepliktaar1());
        assertEquals(model.getVernepliktaar2(), dto.getVernepliktaar2());
        assertEquals(model.getVernepliktaar3(), dto.getVernepliktaar3());
        assertEquals(model.getVernepliktaar4(), dto.getVernepliktaar4());
        assertEquals(model.getPensjonsgivendeInntektSisteLeveaar(), dto.getPensjonsgivendeInntektSisteLeveaar());
        assertEquals(model.getStatsborgerskap(), dto.getStatsborgerskap());
        assertEquals(model.getBosattLand(), dto.getBosattLand());
        assertEquals(model.getPensjonstrygdet(), dto.getPensjonstrygdet());
        assertEquals(model.getMinst20AarBotid(), dto.getMinst20AarBotid());
        assertEquals(model.getFravikPgaKonvensjonAnnetLand(), dto.getFravikPgaKonvensjonAnnetLand());
        assertEquals(model.getFlyktning(), dto.getFlyktning());
        assertEquals(model.getOverkompensasjonUtland(), dto.getOverkompensasjonUtland());
        assertEquals(model.getSkalIkkeBeregnesGrunnpenson(), dto.getSkalIkkeBeregnesGrunnpenson());
        assertEquals(model.getPensjonBeregnesEtterKonvensjonsregler(), dto.getPensjonBeregnesEtterKonvensjonsregler());
        assertEquals(model.getGrunnpensjonBeregnesEtterAnnenSamletTrygdetid(), dto.getGrunnpensjonBeregnesEtterAnnenSamletTrygdetid());
        assertEquals(model.getFramtidigTrygdetidFraDod(), dto.getFramtidigTrygdetidFraDod());
        assertEquals(model.getFaktiskTrygdetidAar(), dto.getFaktiskTrygdetidAar());
        assertEquals(model.getFaktiskTrygdetidMaaneder(), dto.getFaktiskTrygdetidMaaneder());
        assertEquals(model.getBeregnesEtterNordiskKonvensjon(), dto.getBeregnesEtterNordiskKonvensjon());
        assertEquals(model.getVilkaarPar10Pkt5nr2(), dto.getVilkaarPar10Pkt5nr2());
        assertEquals(model.getMedlemFolketrygdenFra(), dto.getMedlemFolketrygdenFra());
        assertEquals(model.getStatsborgerskapEktefelle(), dto.getStatsborgerskapEktefelle());
        assertEquals(model.getBosattEktefelle(), dto.getBosattEktefelle());
        assertEquals(model.getErEktefelleFlyktning(), dto.getErEktefelleFlyktning());
        assertEquals(model.getTrygdetidFra1937EktefelleAar(), dto.getTrygdetidFra1937EktefelleAar());
        assertEquals(model.getTrygdetidFra1937EktefelleMaaneder(), dto.getTrygdetidFra1937EktefelleMaaneder());
        assertEquals(model.getOverkompensasjonUtlandEktefelle(), dto.getOverkompensasjonUtlandEktefelle());
    }

    @Test
    public void thatGrunnblankettEtterlattEktefelleDtoIsMappedCorrectlyToJson() {
        Map<String, Object> expected = new HashMap<>();
        expected.put("bosattNorge", "??");
        expected.put("omsorgAvdodesBarn", "??");
        expected.put("vilkaarPar10Pkt5", "??");
        expected.put("forventetInntekt", 1010);
        expected.put("framtidigArbeidsinntekt", 1111);
        expected.put("ytelse", "??");
        expected.put("yrkesskadeTillegg", "??");
        expected.put("framleggsdato", 1212);
        expected.put("framleggskode", "??");
        expected.put("fodselsnummerEktefelle", "1313");
        expected.put("navnEktefelle", "??");
        expected.put("dodsdato", 1414);
        expected.put("bosattNorgeEktefelle", "??");
        expected.put("vilkaarPar8Pkt3Ledd3bokstavA", "??");
        expected.put("vernepliktaar1", 1515);
        expected.put("vernepliktaar2", 1616);
        expected.put("vernepliktaar3", 1717);
        expected.put("vernepliktaar4", 1818);
        expected.put("pensjonsgivendeInntektSisteLeveaar", 1919);
        expected.put("statsborgerskap", 2020);
        expected.put("bosattLand", 2121);
        expected.put("pensjonstrygdet", "??");
        expected.put("minst20AarBotid", "??");
        expected.put("fravikPgaKonvensjonAnnetLand", "??");
        expected.put("flyktning", "??");
        expected.put("overkompensasjonUtland", "??");
        expected.put("skalIkkeBeregnesGrunnpenson", "??");
        expected.put("pensjonBeregnesEtterKonvensjonsregler", "??");
        expected.put("grunnpensjonBeregnesEtterAnnenSamletTrygdetid", 2222);
        expected.put("framtidigTrygdetidFraDod", 2323);
        expected.put("faktiskTrygdetidAar", 2424);
        expected.put("faktiskTrygdetidMaaneder", 2525);
        expected.put("beregnesEtterNordiskKonvensjon", "??");
        expected.put("vilkaarPar10Pkt5nr2", "??");
        expected.put("medlemFolketrygdenFra", 2626);
        expected.put("statsborgerskapEktefelle", 2727);
        expected.put("bosattEktefelle", 2828);
        expected.put("erEktefelleFlyktning", "??");
        expected.put("trygdetidFra1937EktefelleAar", 2929);
        expected.put("trygdetidFra1937EktefelleMaaneder", 3030);
        expected.put("overkompensasjonUtlandEktefelle", "??");

        assertThatJson(dto).isEqualTo(expected);

    }

}