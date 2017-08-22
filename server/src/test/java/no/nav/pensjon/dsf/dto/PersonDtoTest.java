package no.nav.pensjon.dsf.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import no.nav.pensjon.dsf.domene.Person;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import static org.junit.Assert.*;

public class PersonDtoTest {
    private ModelMapper modelMapper = new ModelMapper();

    private ObjectMapper objectMapper = new ObjectMapper();

    private Person person;

    @Before
    public void setUp() {
        person = new Person();
        person.setNavn("Test Person");
        person.setAi67(100);
        person.setFnr("12345");
    }

    @After
    public void tearDown() {
        person = null;
    }

    @Test
    public void thatPersonIsMappedCorrectlyToDto() throws Exception {
        PersonDto personDto = modelMapper.map(person, PersonDto.class);
        assertEquals(person.getNavn(), personDto.getNavn());
        assertEquals(person.getFnr(), personDto.getFnr());
    }

    @Test
    public void thatPersonDtoIsMappedCorrectlyToJson() throws Exception {
        PersonDto personDto = modelMapper.map(person, PersonDto.class);
        String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(personDto);
        String expected = "{\r\n" +
                "  \"fnr\" : \"12345\",\r\n" +
                "  \"navn\" : \"Test Person\",\r\n" +
                "  \"availableForLookup\" : false\r\n" +
                "}";
        assertEquals(expected, json);
    }

}