package no.nav.pensjon.dsf.dto;

import no.nav.pensjon.dsf.domene.Person;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import java.util.HashMap;
import java.util.Map;

import static net.javacrumbs.jsonunit.fluent.JsonFluentAssert.assertThatJson;
import static org.junit.Assert.assertEquals;

public class PersonDtoTest {
    private ModelMapper modelMapper = new ModelMapper();

    private Person person;

    private PersonDto personDto;

    @Before
    public void setUp() {
        person = new Person();
        person.setNavn("Test Person");
        person.setAi67(100);
        person.setFnr("12345");

        personDto = modelMapper.map(person, PersonDto.class);
    }

    @After
    public void tearDown() {
        person = null;
        personDto = null;
    }

    @Test
    public void thatPersonIsMappedCorrectlyToDto() {
        assertEquals(person.getNavn(), personDto.getNavn());
        assertEquals(person.getFnr(), personDto.getFnr());
    }

    @Test
    public void thatPersonDtoIsMappedCorrectlyToJson() {
        Map<String, Object> expected = new HashMap<>();
        expected.put("fnr", "12345");
        expected.put("navn", "Test Person");

        assertThatJson(personDto).isEqualTo(expected);
    }
}