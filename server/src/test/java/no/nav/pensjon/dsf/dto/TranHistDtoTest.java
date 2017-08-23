package no.nav.pensjon.dsf.dto;

import no.nav.pensjon.dsf.domene.grunnblanketter.TranHist;
import no.nav.pensjon.test.IsMapWithSize;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;

import static net.javacrumbs.jsonunit.fluent.JsonFluentAssert.assertThatJson;
import static org.hamcrest.Matchers.hasEntry;
import static org.junit.Assert.assertEquals;

public class TranHistDtoTest {
    private ModelMapper modelMapper = new ModelMapper();

    private TranHist tranHist;

    private TranHistDto tranHistDto;

    @Before
    public void setUp() throws Exception {
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
        tranHist.setVtp_key(1313);

        tranHistDto = modelMapper.map(tranHist, TranHistDto.class);
    }

    @After
    public void tearDown() throws Exception {
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
        assertEquals(tranHist.getVtp_key(), tranHistDto.getVtp_key());
    }

    @Test
    public void thatTranHistDtoIsMappedCorrectlyToJson() {
        assertThatJson(tranHistDto)
                .matches(IsMapWithSize.hasSize(12))
                .matches(hasEntry("autoTerminalId", "??"))
                .matches(hasEntry("grunnblankettkode", "??"))
                .matches(hasEntry("prioritetskode", "??"))
                .matches(hasEntry("sivilstand", "??"))
                .matches(hasEntry("spraak", "??"))
                .matches(hasEntry("terminalId", "??"))
                .matches(hasEntry("transaksjonsreturkode", "??"))
                .matches(hasEntry("registreringsdato", BigDecimal.valueOf(1010)))
                .matches(hasEntry("trygdekontornummer", BigDecimal.valueOf(1111)))
                .matches(hasEntry("virkningsdato", BigDecimal.valueOf(1212)))
                .matches(hasEntry("vtp_key", BigDecimal.valueOf(1313)));
    }

}