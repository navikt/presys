package no.nav.pensjon.dsf.domene;


import org.junit.Test;

public class PersonTest extends DomeneTest {


    @Test
    public void validerPerson() throws NoSuchMethodException {
        validerSegment(Person.class);
    }
}
