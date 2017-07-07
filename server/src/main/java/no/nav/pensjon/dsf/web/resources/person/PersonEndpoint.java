package no.nav.pensjon.dsf.web.resources.person;

//import com.codahale.metrics.annotation.ExceptionMetered;
//import com.codahale.metrics.annotation.Timed;
import no.nav.pensjon.dsf.dto.*;
import no.nav.pensjon.presys.metrics.aspects.Count;
import no.nav.pensjon.presys.metrics.aspects.Field;
import no.nav.pensjon.presys.metrics.aspects.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("api/person/{fnr}")
public class PersonEndpoint {

    @Autowired
    private PersonService personService;

    @Timed
    @Count(fields = @Field(key = "fnr", argumentNumber = "1"))
    @RequestMapping(method = RequestMethod.GET)
    public PersonDto findOne(@PathVariable String fnr) throws IOException {
        return personService.hentPerson(fnr);
    }

    @Timed
    @Count(fields = @Field(key = "fnr", argumentNumber = "1"))
    //@ExceptionMetered(name = "findInntekter.exceptions")
    @RequestMapping(value = "/inntekter", method = RequestMethod.GET)
    public List<InntektDto> findInntekter(@PathVariable String fnr) throws IOException {
        return personService.hentInntekter(fnr);
    }

    @Timed
    @Count(fields = @Field(key = "fnr", argumentNumber = "1"))
    @RequestMapping(value = "/etteroppgjor", method = RequestMethod.GET)
    public List<EtteroppgjorAFPDto> findEtteroppgjor(@PathVariable String fnr) throws IOException {
        return personService.hentEtteroppgjor(fnr);
    }

    @Timed
    @Count(fields = @Field(key = "fnr", argumentNumber = "1"))
    @RequestMapping(value = "/tilberpo", method = RequestMethod.GET)
    public List<TilberpoDto> findTilberpo(@PathVariable String fnr) throws IOException {
        return personService.hentTilberpo(fnr);
    }

    @Timed
    @Count(fields = @Field(key = "fnr", argumentNumber = "1"))
    @RequestMapping(value = "/status", method = RequestMethod.GET)
    public List<StatusDto> findStatus(@PathVariable String fnr) throws IOException {
        return personService.hentStatus(fnr);
    }

    @Timed
    @Count(fields = @Field(key = "fnr", argumentNumber = "1"))
    @RequestMapping(value = "/status/siste", method = RequestMethod.GET)
    public StatusDto findSisteStatus(@PathVariable String fnr) throws IOException {
        return personService.hentSisteStatus(fnr);
    }

    @Timed
    @Count(fields = @Field(key = "fnr", argumentNumber = "1"))
    @RequestMapping(value = "/uforeHistorikk", method = RequestMethod.GET)
    public List<UforeHistorikkDto> findUforeHistorikk(@PathVariable String fnr) throws IOException {
        return personService.hentUforehistorikk(fnr);
    }

    @Timed
    @Count(fields = @Field(key = "fnr", argumentNumber = "1"))
    @RequestMapping(value = "/tranHister", method = RequestMethod.GET)
    public List<TranHistDto> findTranhister(@PathVariable String fnr) throws IOException {
        return personService.hentTranhister(fnr);
    }
}
