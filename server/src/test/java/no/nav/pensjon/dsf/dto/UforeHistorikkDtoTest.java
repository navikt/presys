package no.nav.pensjon.dsf.dto;

import no.nav.pensjon.dsf.domene.status.UforeHistorikk;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static net.javacrumbs.jsonunit.fluent.JsonFluentAssert.assertThatJson;
import static org.junit.Assert.assertEquals;

public class UforeHistorikkDtoTest {

    private ModelMapper modelMapper = new ModelMapper();

    private UforeHistorikk uforeHistorikk;

    private UforeHistorikkDto uforeHistorikkDto;

    @Before
    public void setUp() {
        uforeHistorikk = new UforeHistorikk();
        uforeHistorikk.setUfg(1010);
        uforeHistorikk.setUftMaaned(1111);
        uforeHistorikk.setUfKriterier(1212);
        uforeHistorikk.setBup(BigDecimal.ONE);
        uforeHistorikk.setBupGarantiKode("??");
        uforeHistorikk.setOpphorsdatoMaaned(1313);
        uforeHistorikk.setOpphorsKode("??");
        uforeHistorikk.setRedusertAntallBupAar(1414);
        uforeHistorikk.setFoedselsaarYngsteBarn(1515);
        uforeHistorikk.setVirkningsdatoUfrHistorie(1616);

        uforeHistorikkDto = modelMapper.map(uforeHistorikk, UforeHistorikkDto.class);
    }

    @After
    public void tearDown() {
        uforeHistorikk = null;
        uforeHistorikkDto = null;
    }

    @Test
    public void thatUforehistorikkIsMappedCorrectlyToDto() {
        assertEquals(uforeHistorikk.getUfg(), uforeHistorikkDto.getUfg());
        assertEquals(uforeHistorikk.getUftMaaned(), uforeHistorikkDto.getUftMaaned());
        assertEquals(uforeHistorikk.getUfKriterier(), uforeHistorikkDto.getUfKriterier());
        assertEquals(uforeHistorikk.getBup(), uforeHistorikkDto.getBup());
        assertEquals(uforeHistorikk.getBupGarantiKode(), uforeHistorikkDto.getBupGarantiKode());
        assertEquals(uforeHistorikk.getOpphorsdatoMaaned(), uforeHistorikkDto.getOpphorsdatoMaaned());
        assertEquals(uforeHistorikk.getOpphorsKode(), uforeHistorikkDto.getOpphorsKode());
        assertEquals(uforeHistorikk.getRedusertAntallBupAar(), uforeHistorikkDto.getRedusertAntallBupAar());
        assertEquals(uforeHistorikk.getFoedselsaarYngsteBarn(), uforeHistorikkDto.getFoedselsaarYngsteBarn());
        assertEquals(uforeHistorikk.getVirkningsdatoUfrHistorie(), uforeHistorikkDto.getVirkningsdatoUfrHistorie());
    }

    @Test
    public void thatUforehistorikkDtoIsMappedCorrectlyToJson() {
        Map<String, Object> expected = new HashMap<>();
        expected.put("uftMaaned", 1111);
        expected.put("ufg", 1010);
        expected.put("ufKriterier", 1212);
        expected.put("bup", 1);
        expected.put("bupGarantiKode", "??");
        expected.put("opphorsdatoMaaned", 1313);
        expected.put("opphorsKode", "??");
        expected.put("redusertAntallBupAar", 1414);
        expected.put("foedselsaarYngsteBarn", 1515);
        expected.put("virkningsdatoUfrHistorie", 1616);
        expected.put("uforegrader", Collections.EMPTY_LIST);

        assertThatJson(uforeHistorikkDto).isEqualTo(expected);
    }
}