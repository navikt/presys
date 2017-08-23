package no.nav.pensjon.dsf.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import no.nav.pensjon.dsf.domene.Person;
import no.nav.pensjon.test.IsMapWithSize;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import static net.javacrumbs.jsonunit.fluent.JsonFluentAssert.assertThatJson;
import static org.hamcrest.Matchers.hasEntry;
import static org.junit.Assert.assertEquals;

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
    public void thatPersonIsMappedCorrectlyToDto() {
        PersonDto personDto = modelMapper.map(person, PersonDto.class);
        assertEquals(person.getNavn(), personDto.getNavn());
        assertEquals(person.getFnr(), personDto.getFnr());
    }

    @Test
    public void thatPersonDtoIsMappedCorrectlyToJson() {
        PersonDto personDto = modelMapper.map(person, PersonDto.class);
        assertThatJson(personDto).matches(IsMapWithSize.hasSize(2))
                .matches(hasEntry("fnr", "12345"))
                .matches(hasEntry("navn", "Test Person"));
    }
}