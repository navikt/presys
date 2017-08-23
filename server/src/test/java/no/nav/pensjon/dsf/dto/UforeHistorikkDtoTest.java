package no.nav.pensjon.dsf.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import no.nav.pensjon.dsf.domene.Uforegrad;
import no.nav.pensjon.dsf.domene.status.UforeHistorikk;
import no.nav.pensjon.test.IsMapWithSize;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;

import static net.javacrumbs.jsonunit.fluent.JsonFluentAssert.assertThatJson;
import static org.hamcrest.Matchers.emptyCollectionOf;
import static org.hamcrest.Matchers.hasEntry;
import static org.junit.Assert.assertEquals;

public class UforeHistorikkDtoTest {

    private ModelMapper modelMapper = new ModelMapper();

    private ObjectMapper objectMapper = new ObjectMapper();

    private UforeHistorikk uforeHistorikk;

    @Before
    public void setUp() {
        uforeHistorikk = new UforeHistorikk();
        uforeHistorikk.setUfg(1010);
        uforeHistorikk.setUftMaaned(1111);
        uforeHistorikk.setUfKriterier(1212);
        uforeHistorikk.setBup(BigDecimal.ONE);
        uforeHistorikk.setBupGarantiKode("??");
        uforeHistorikk.setOpphørsdatoMaaned(1313);
        uforeHistorikk.setOpphørsKode("??");
        uforeHistorikk.setRedusertAntallBupAar(1414);
        uforeHistorikk.setFoedselsaarYngsteBarn(1515);
        uforeHistorikk.setVirkningsdatoUfrHistorie(1616);
    }

    @After
    public void tearDown() {
        uforeHistorikk = null;
    }

    @Test
    public void thatUforehistorikkIsMappedCorrectlyToDto() throws Exception {
        UforeHistorikkDto uforeHistorikkDto = modelMapper.map(uforeHistorikk, UforeHistorikkDto.class);

        assertEquals(uforeHistorikk.getUfg(), uforeHistorikkDto.getUfg());
        assertEquals(uforeHistorikk.getUftMaaned(), uforeHistorikkDto.getUftMaaned());
        assertEquals(uforeHistorikk.getUfKriterier(), uforeHistorikkDto.getUfKriterier());
        assertEquals(uforeHistorikk.getBup(), uforeHistorikkDto.getBup());
        assertEquals(uforeHistorikk.getBupGarantiKode(), uforeHistorikkDto.getBupGarantiKode());
        assertEquals(uforeHistorikk.getOpphørsdatoMaaned(), uforeHistorikkDto.getOpphørsdatoMaaned());
        assertEquals(uforeHistorikk.getOpphørsKode(), uforeHistorikkDto.getOpphørsKode());
        assertEquals(uforeHistorikk.getRedusertAntallBupAar(), uforeHistorikkDto.getRedusertAntallBupAar());
        assertEquals(uforeHistorikk.getFoedselsaarYngsteBarn(), uforeHistorikkDto.getFoedselsaarYngsteBarn());
        assertEquals(uforeHistorikk.getVirkningsdatoUfrHistorie(), uforeHistorikkDto.getVirkningsdatoUfrHistorie());

    }

    @Test
    public void thatUforehistorikkDtoIsMappedCorrectlyToJson() throws Exception {
        UforeHistorikkDto uforeHistorikkDto = modelMapper.map(uforeHistorikk, UforeHistorikkDto.class);
        assertThatJson(uforeHistorikkDto).matches(IsMapWithSize.hasSize(11))
                .matches(hasEntry("uftMaaned", BigDecimal.valueOf(1111)))
                .matches(hasEntry("ufg", BigDecimal.valueOf(1010)))
                .matches(hasEntry("ufKriterier", BigDecimal.valueOf(1212)))
                .matches(hasEntry("bup", BigDecimal.valueOf(1)))
                .matches(hasEntry("bupGarantiKode", "??"))
                .matches(hasEntry("opphørsdatoMaaned", BigDecimal.valueOf(1313)))
                .matches(hasEntry("opphørsKode", "??"))
                .matches(hasEntry("redusertAntallBupAar", BigDecimal.valueOf(1414)))
                .matches(hasEntry("foedselsaarYngsteBarn", BigDecimal.valueOf(1515)))
                .matches(hasEntry("virkningsdatoUfrHistorie", BigDecimal.valueOf(1616)))
                .node("uforegrader").matches(emptyCollectionOf(Uforegrad.class));
    }
}