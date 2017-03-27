package no.nav.pensjon.dsf.web.resources;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/person")
public class PersonEndpoint {

    List<Person> repo = new ArrayList<>();

    PersonEndpoint(){
        repo.add(new Person("123", "Lars", 31, Person.Kjonn.MANN));
        repo.add(new Person("321", "Bernt", 78, Person.Kjonn.KVINNE));

    }


    @RequestMapping("/{fnr}")
    public Person findOne(@PathVariable String fnr){
        return repo.stream().filter(p->p.getFnr().equals(fnr)).findAny().get();
    }
}
