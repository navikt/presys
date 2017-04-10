package no.nav.pensjon.dsf.web.resources;


import no.nav.pensjon.dsf.web.Exceptions.ResourceNotFound;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Supplier;

@RestController
@RequestMapping("api/person")
public class PersonEndpoint {

    private final List<Person> repo = new ArrayList<>();

    PersonEndpoint(){
        repo.add(new Person("123", "Lars", 31, Person.Kjonn.MANN, Person.SivilStatus.PARTNER));
        repo.add(new Person("321", "Bernt", 78, Person.Kjonn.KVINNE, Person.SivilStatus.SAMBOER));

    }

    @RequestMapping("/{fnr}")
    public Person findOne(@PathVariable String fnr){
        return repo.stream().filter(p->p.getFnr().equals(fnr)).findAny().orElseThrow(ResourceNotFound::new);
    }
}
