package no.nav.pensjon.dsf.web.resources.person;

//import com.codahale.metrics.annotation.ExceptionMetered;
//import com.codahale.metrics.annotation.Timed;
import no.nav.pensjon.dsf.dto.*;
import no.nav.pensjon.dsf.web.Exceptions.ResourceNotFound;
import no.nav.pensjon.presys.metrics.aspects.Count;
import no.nav.pensjon.presys.metrics.aspects.ExceptionMetered;
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
@Timed
@ExceptionMetered(ignoreExceptions = {ResourceNotFound.class})
public class PersonEndpoint {

    @Autowired
    private PersonService personService;

    @ExceptionMetered(name = "PersonEndpoint.findOne.ResourceNotFound", cause = ResourceNotFound.class, fields = @Field(key = "fnr", argumentNumber = "1"))
    @Count(fields = @Field(key = "fnr", argumentNumber = "1"))
    @RequestMapping(method = RequestMethod.GET)
    public PersonDto findOne(@PathVariable String fnr) throws IOException {
        return personService.hentPerson(fnr);
    }

    @ExceptionMetered(name = "PersonEndpoint.findInntekter.ResourceNotFound", cause = ResourceNotFound.class, fields = @Field(key = "fnr", argumentNumber = "1"))
    @Count(fields = @Field(key = "fnr", argumentNumber = "1"))
    //@ExceptionMetered(name = "findInntekter.exceptions")
    @RequestMapping(value = "/inntekter", method = RequestMethod.GET)
    public List<InntektDto> findInntekter(@PathVariable String fnr) throws IOException {
        return personService.hentInntekter(fnr);
    }

    @ExceptionMetered(name = "PersonEndpoint.findEtteroppgjor.ResourceNotFound", cause = ResourceNotFound.class, fields = @Field(key = "fnr", argumentNumber = "1"))
    @Count(fields = @Field(key = "fnr", argumentNumber = "1"))
    @RequestMapping(value = "/etteroppgjor", method = RequestMethod.GET)
    public List<EtteroppgjorAFPDto> findEtteroppgjor(@PathVariable String fnr) throws IOException {
        return personService.hentEtteroppgjor(fnr);
    }

    @ExceptionMetered(name = "PersonEndpoint.findTilberpo.ResourceNotFound", cause = ResourceNotFound.class, fields = @Field(key = "fnr", argumentNumber = "1"))
    @Count(fields = @Field(key = "fnr", argumentNumber = "1"))
    @RequestMapping(value = "/tilberpo", method = RequestMethod.GET)
    public List<TilberpoDto> findTilberpo(@PathVariable String fnr) throws IOException {
        return personService.hentTilberpo(fnr);
    }

    @ExceptionMetered(name = "PersonEndpoint.findStatus.ResourceNotFound", cause = ResourceNotFound.class, fields = @Field(key = "fnr", argumentNumber = "1"))
    @Count(fields = @Field(key = "fnr", argumentNumber = "1"))
    @RequestMapping(value = "/status", method = RequestMethod.GET)
    public List<StatusDto> findStatus(@PathVariable String fnr) throws IOException {
        return personService.hentStatus(fnr);
    }

    @ExceptionMetered(name = "PersonEndpoint.findSisteStatus.ResourceNotFound", cause = ResourceNotFound.class, fields = @Field(key = "fnr", argumentNumber = "1"))
    @Count(fields = @Field(key = "fnr", argumentNumber = "1"))
    @RequestMapping(value = "/status/siste", method = RequestMethod.GET)
    public StatusDto findSisteStatus(@PathVariable String fnr) throws IOException {
        return personService.hentSisteStatus(fnr);
    }

    @ExceptionMetered(name = "PersonEndpoint.findUforeHistorikk.ResourceNotFound", cause = ResourceNotFound.class, fields = @Field(key = "fnr", argumentNumber = "1"))
    @Count(fields = @Field(key = "fnr", argumentNumber = "1"))
    @RequestMapping(value = "/uforeHistorikk", method = RequestMethod.GET)
    public List<UforeHistorikkDto> findUforeHistorikk(@PathVariable String fnr) throws IOException {
        return personService.hentUforehistorikk(fnr);
    }

    @ExceptionMetered(name = "PersonEndpoint.findTranhister.ResourceNotFound", cause = ResourceNotFound.class, fields = @Field(key = "fnr", argumentNumber = "1"))
    @Count(fields = @Field(key = "fnr", argumentNumber = "1"))
    @RequestMapping(value = "/tranHister", method = RequestMethod.GET)
    public List<TranHistDto> findTranhister(@PathVariable String fnr) throws IOException {
        return personService.hentTranhister(fnr);
    }
}
