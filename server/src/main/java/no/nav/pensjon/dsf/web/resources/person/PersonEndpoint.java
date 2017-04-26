package no.nav.pensjon.dsf.web.resources.person;

import no.nav.pensjon.dsf.repository.PersonRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

import java.io.IOException;


@RestController
@RequestMapping("api/person")
public class PersonEndpoint {

    @Inject
    private PersonRepository repo;

    @RequestMapping("/{fnr}")
    public no.nav.pensjon.dsf.domene.Person findOne(@PathVariable String fnr) throws IOException {
        return repo.findPerson(fnr);
    }
}
