package no.nav.pensjon.dsf.dto;

import no.nav.pensjon.dsf.domene.grunnblanketter.GRUNNBAP;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import java.util.HashMap;
import java.util.Map;

import static net.javacrumbs.jsonunit.fluent.JsonFluentAssert.assertThatJson;
import static org.junit.Assert.assertEquals;

public class GrunnblankettAlderspensjonDtoTest {
    private ModelMapper modelMapper = new ModelMapper();

    private GRUNNBAP model;

    private GrunnblankettAlderspensjonDto dto;

    @Before
    public void setUp() {
        model = new GRUNNBAP();
        model.setEktefelleTillegg("??");
        model.setFramtidigArbeidsinntekt(1010);
        model.setBosattNorge("??");
        model.setStatsborgerskap(1111);
        model.setBosattLand(1212);
        model.setErFlyktning("??");
        model.setFravikPar19Pkt3("??");
        model.setTrygdetidVentetUtlandMaaneder(1313);
        model.setTrygdetidFor1967(1414);
        model.setTrygdetidEtter1966Aar(1515);
        model.setTrygdetidEtter1966Maaneder(1616);
        model.setAntallBarnetillegg(1717);
        model.setAlderspensjonsdel(1818);
        model.setFodselsnummerEktefelle("??");
        model.setNavnEktefelle("??");
        model.setTrygdetidFor1967Ektefelle(1919);
        model.setTrygdetidEtter1966AarEktefelle(2020);
        model.setTrygdetidEtter1966MaanederEktefelle(2121);
        model.setOverkompensasjonUtland("??");
        model.setIkkeGrunnpensjon("??");
        model.setInntektMinst4G("??");

        dto = modelMapper.map(model, GrunnblankettAlderspensjonDto.class);
    }

    @After
    public void tearDown() {
        model = null;
        dto = null;
    }

    @Test
    public void thatGRUNNBAPIsMappedCorrectlyToDto() {
        assertEquals(model.getEktefelleTillegg(), dto.getEktefelleTillegg());
        assertEquals(model.getFramtidigArbeidsinntekt() * 100, dto.getFramtidigArbeidsinntekt());
        assertEquals(model.getBosattNorge(), dto.getBosattNorge());
        assertEquals(model.getStatsborgerskap(), dto.getStatsborgerskap());
        assertEquals(model.getBosattLand(), dto.getBosattLand());
        assertEquals(model.getErFlyktning(), dto.getErFlyktning());
        assertEquals(model.getFravikPar19Pkt3(), dto.getFravikPar19Pkt3());
        assertEquals(model.getTrygdetidVentetUtlandMaaneder(), dto.getTrygdetidVentetUtlandMaaneder());
        assertEquals(model.getTrygdetidFor1967(), dto.getTrygdetidFor1967());
        assertEquals(model.getTrygdetidEtter1966Aar(), dto.getTrygdetidEtter1966Aar());
        assertEquals(model.getTrygdetidEtter1966Maaneder(), dto.getTrygdetidEtter1966Maaneder());
        assertEquals(model.getAntallBarnetillegg(), dto.getAntallBarnetillegg());
        assertEquals(model.getAlderspensjonsdel(), dto.getAlderspensjonsdel());
        assertEquals(model.getFodselsnummerEktefelle(), dto.getFodselsnummerEktefelle());
        assertEquals(model.getNavnEktefelle(), dto.getNavnEktefelle());
        assertEquals(model.getTrygdetidFor1967Ektefelle(), dto.getTrygdetidFor1967Ektefelle());
        assertEquals(model.getTrygdetidEtter1966AarEktefelle(), dto.getTrygdetidEtter1966AarEktefelle());
        assertEquals(model.getTrygdetidEtter1966MaanederEktefelle(), dto.getTrygdetidEtter1966MaanederEktefelle());
        assertEquals(model.getOverkompensasjonUtland(), dto.getOverkompensasjonUtland());
        assertEquals(model.getIkkeGrunnpensjon(), dto.getIkkeGrunnpensjon());
        assertEquals(model.getInntektMinst4G(), dto.getInntektMinst4G());
    }

    @Test
    public void thatGrunnblankettAlderspensjonDtoIsMappedCorrectlyToJson() {
        Map<String, Object> expected = new HashMap<>();
        expected.put("ektefelleTillegg", "??");
        expected.put("framtidigArbeidsinntekt", 101000);
        expected.put("bosattNorge", "??");
        expected.put("statsborgerskap", 1111);
        expected.put("bosattLand", 1212);
        expected.put("erFlyktning", "??");
        expected.put("fravikPar19Pkt3", "??");
        expected.put("trygdetidVentetUtlandMaaneder", 1313);
        expected.put("trygdetidFor1967", 1414);
        expected.put("trygdetidEtter1966Aar", 1515);
        expected.put("trygdetidEtter1966Maaneder", 1616);
        expected.put("antallBarnetillegg", 1717);
        expected.put("alderspensjonsdel", 1818);
        expected.put("fodselsnummerEktefelle", "??");
        expected.put("navnEktefelle", "??");
        expected.put("trygdetidFor1967Ektefelle", 1919);
        expected.put("trygdetidEtter1966AarEktefelle", 2020);
        expected.put("trygdetidEtter1966MaanederEktefelle", 2121);
        expected.put("overkompensasjonUtland", "??");
        expected.put("ikkeGrunnpensjon", "??");
        expected.put("inntektMinst4G", "??");

        assertThatJson(dto).isEqualTo(expected);

    }

}