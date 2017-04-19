package no.nav.pensjon.dsf.repository;

import no.nav.pensjon.dsf.domene.Person;
import no.nav.pensjon.dsf.ebcdic.ScrollableArray;
import no.nav.pensjon.dsf.ebcdic.segmenter.RF0PersonSegment;
import no.nav.pensjon.dsf.ebcdic.segmenter.Segment;
import no.nav.pensjon.dsf.web.EbcdicReader;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;

public class PersonRepository {

    public Person findPerson(String fnr) throws IOException {
        String fileName = "database/" +fnr +".txt";
        DataInputStream isPinntekt = new DataInputStream(EbcdicReader.class.getClassLoader().getResourceAsStream(fileName));
        File f = new File("src/main/resources/"+ fileName);
        long lengthOfFile = f.length();

        if(lengthOfFile > Integer.MAX_VALUE)
            throw new IllegalArgumentException();

        Segment<Person> personsegment = new RF0PersonSegment();
        byte[] file = new byte[(int) lengthOfFile];
        isPinntekt.readFully(file);

        isPinntekt.close();
        return personsegment.readSegment(new ScrollableArray(file));
    }
}
