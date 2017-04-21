package no.nav.pensjon.dsf.repository;

import no.nav.pensjon.dsf.domene.Person;
import no.nav.pensjon.dsf.ebcdic.ScrollableArray;
import no.nav.pensjon.dsf.ebcdic.segmenter.RF0PersonSegment;
import no.nav.pensjon.dsf.ebcdic.segmenter.Segment;
import no.nav.pensjon.dsf.web.Exceptions.ResourceNotFound;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Component
public class PersonRepository {

    @Inject
    private DbRepo repo;

    @Inject
    private JdbcTemplate db;

    private Segment<Person> personsegment = new RF0PersonSegment();

    public Person findPerson(String fnr) throws IOException {
        return personsegment.readSegment(new ScrollableArray(
                        Base64.getDecoder().decode(
                                Optional.ofNullable(repo.findOne(fnr)).orElseThrow(ResourceNotFound::new).getData()
                        )));
    }

    public List<String> personer(){
        return db.queryForList("select fnr from Db_Person", String.class);
    }
}
