package no.nav.pensjon.dsf.dto;

import no.nav.pensjon.dsf.domene.grunnblanketter.GRUNNBKF;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import java.util.HashMap;
import java.util.Map;

import static net.javacrumbs.jsonunit.fluent.JsonFluentAssert.assertThatJson;
import static org.junit.Assert.assertEquals;

public class GrunnblankettNyAFPDtoTest {
    private ModelMapper modelMapper = new ModelMapper();

    private GRUNNBKF model;

    private GrunnblankettNyAFPDto dto;

    @Before
    public void setUp() {
        model = new GRUNNBKF();
        model.setNorskBosatt("??");
        model.setTrygdetidAar(1010);
        model.setTrygdetidMaaneder(1111);
        model.setStatsborger(1212);
        model.setBosattLandkode(1313);
        model.setFravikFlyktning("??");
        model.setOverkompensasjonForUtlending("??");
        model.setPensjonsinntektSisteAar(1414);
        model.setFramtidigArbeidsinntekt(1515);
        model.setTilleggForEktefelle("??");
        model.setPensjonsinntektUtenomFolketrygd(1616);
        model.setAfpTilleggskode("??");
        model.setAfpOrdningskode("??");
        model.setFodselsnummerEktefelle("1717");
        model.setNavnEktefelle("??");
        model.setEktefelleInntektOver2G("??");
        model.setRedusertGrunnpensjonEtterParagraf325("??");

        dto = modelMapper.map(model, GrunnblankettNyAFPDto.class);
    }

    @After
    public void tearDown() {
        model = null;
        dto = null;
    }

    @Test
    public void thatGRUNNBKFIsMappedCorrectlyToDto() {
        assertEquals(model.getNorskBosatt(), dto.getNorskBosatt());
        assertEquals(model.getTrygdetidAar(), dto.getTrygdetidAar());
        assertEquals(model.getTrygdetidMaaneder(), dto.getTrygdetidMaaneder());
        assertEquals(model.getStatsborger(), dto.getStatsborger());
        assertEquals(model.getBosattLandkode(), dto.getBosattLandkode());
        assertEquals(model.getFravikFlyktning(), dto.getFravikFlyktning());
        assertEquals(model.getOverkompensasjonForUtlending(), dto.getOverkompensasjonForUtlending());
        assertEquals(model.getPensjonsinntektSisteAar(), dto.getPensjonsinntektSisteAar());
        assertEquals(model.getFramtidigArbeidsinntekt(), dto.getFramtidigArbeidsinntekt());
        assertEquals(model.getTilleggForEktefelle(), dto.getTilleggForEktefelle());
        assertEquals(model.getPensjonsinntektUtenomFolketrygd(), dto.getPensjonsinntektUtenomFolketrygd());
        assertEquals(model.getAfpTilleggskode(), dto.getAfpTilleggskode());
        assertEquals(model.getAfpOrdningskode(), dto.getAfpOrdningskode());
        assertEquals(model.getFodselsnummerEktefelle(), dto.getFodselsnummerEktefelle());
        assertEquals(model.getNavnEktefelle(), dto.getNavnEktefelle());
        assertEquals(model.getEktefelleInntektOver2G(), dto.getEktefelleInntektOver2G());
        assertEquals(model.getRedusertGrunnpensjonEtterParagraf325(), dto.getRedusertGrunnpensjonEtterParagraf325());
    }

    @Test
    public void thatGrunnblankettNyAFPDtoIsMappedCorrectlyToJson() {
        Map<String, Object> expected = new HashMap<>();
        expected.put("norskBosatt", "??");
        expected.put("trygdetidAar", 1010);
        expected.put("trygdetidMaaneder", 1111);
        expected.put("statsborger", 1212);
        expected.put("bosattLandkode", 1313);
        expected.put("fravikFlyktning", "??");
        expected.put("overkompensasjonForUtlending", "??");
        expected.put("pensjonsinntektSisteAar", 1414);
        expected.put("framtidigArbeidsinntekt", 1515);
        expected.put("tilleggForEktefelle", "??");
        expected.put("pensjonsinntektUtenomFolketrygd", 1616);
        expected.put("afpTilleggskode", "??");
        expected.put("afpOrdningskode", "??");
        expected.put("fodselsnummerEktefelle", "1717");
        expected.put("navnEktefelle", "??");
        expected.put("ektefelleInntektOver2G", "??");
        expected.put("redusertGrunnpensjonEtterParagraf325", "??");

        assertThatJson(dto).isEqualTo(expected);

    }

}