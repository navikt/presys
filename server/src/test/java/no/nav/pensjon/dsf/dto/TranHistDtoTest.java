package no.nav.pensjon.dsf.dto;

import no.nav.pensjon.dsf.domene.grunnblanketter.TranHist;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static net.javacrumbs.jsonunit.fluent.JsonFluentAssert.assertThatJson;
import static org.junit.Assert.assertEquals;

public class TranHistDtoTest {
    private ModelMapper modelMapper = new ModelMapper();

    private TranHist tranHist;

    private TranHistDto tranHistDto;

    @Before
    public void setUp() {
        tranHist = new TranHist();
        tranHist.setAutoTerminalId("??");
        tranHist.setGrunnblankettkode("??");
        tranHist.setPrioritetskode("??");
        tranHist.setRegistreringsdato(1010);
        tranHist.setSivilstand("??");
        tranHist.setSpraak("??");
        tranHist.setTerminalId("??");
        tranHist.setTransaksjonsreturkode("??");
        tranHist.setTrygdekontornummer(1111);
        tranHist.setVirkningsdato(1212);
        tranHist.setVtpKey(1313);

        tranHistDto = modelMapper.map(tranHist, TranHistDto.class);
    }

    @After
    public void tearDown() {
        tranHist = null;
        tranHistDto = null;
    }

    @Test
    public void thatTranHistIsMappedCorrectlyToDto() {
        assertEquals(tranHist.getAutoTerminalId(), tranHistDto.getAutoTerminalId());
        assertEquals(tranHist.getGrunnblankettkode(), tranHistDto.getGrunnblankettkode());
        assertEquals(tranHist.getPrioritetskode(), tranHistDto.getPrioritetskode());
        assertEquals(tranHist.getSivilstand(), tranHistDto.getSivilstand());
        assertEquals(tranHist.getSpraak(), tranHistDto.getSpraak());
        assertEquals(tranHist.getTerminalId(), tranHistDto.getTerminalId());
        assertEquals(tranHist.getTransaksjonsreturkode(), tranHistDto.getTransaksjonsreturkode());
        assertEquals(tranHist.getRegistreringsdato(), tranHistDto.getRegistreringsdato());
        assertEquals(tranHist.getTrygdekontornummer(), tranHistDto.getTrygdekontornummer());
        assertEquals(tranHist.getVirkningsdato(), tranHistDto.getVirkningsdato());
        assertEquals(tranHist.getVtpKey(), tranHistDto.getVtpKey());
    }

    @Test
    public void thatTranHistDtoIsMappedCorrectlyToJson() {
        Map<String, Object> expected = new HashMap<>();
        expected.put("autoTerminalId", "??");
        expected.put("grunnblankettkode", "??");
        expected.put("prioritetskode", "??");
        expected.put("sivilstand", "??");
        expected.put("spraak", "??");
        expected.put("terminalId", "??");
        expected.put("transaksjonsreturkode", "??");
        expected.put("registreringsdato", 1010);
        expected.put("trygdekontornummer", 1111);
        expected.put("virkningsdato", 1212);
        expected.put("vtpKey", 1313);
        expected.put("grunnblankett", null);
        expected.put("barn", new ArrayList<>());
        expected.put("grunnbyp", new ArrayList<>());
        expected.put("grunnees", new ArrayList<>());


        assertThatJson(tranHistDto).isEqualTo(expected);
    }

}