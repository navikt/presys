package no.nav.pensjon.dsf.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import no.nav.pensjon.dsf.domene.status.UforeHistorikk;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;

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
        String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(uforeHistorikkDto);

        String expected = "{\r\n" +
                "  \"uftMaaned\" : 1111,\r\n" +
                "  \"ufg\" : 1010,\r\n" +
                "  \"ufKriterier\" : 1212,\r\n" +
                "  \"bup\" : 1,\r\n" +
                "  \"bupGarantiKode\" : \"??\",\r\n" +
                "  \"opphørsdatoMaaned\" : 1313,\r\n" +
                "  \"opphørsKode\" : \"??\",\r\n" +
                "  \"redusertAntallBupAar\" : 1414,\r\n" +
                "  \"foedselsaarYngsteBarn\" : 1515,\r\n" +
                "  \"virkningsdatoUfrHistorie\" : 1616,\r\n" +
                "  \"uforegrader\" : [ ]\r\n" +
                "}";
        assertEquals(expected, json);
    }
}