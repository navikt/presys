package no.nav.pensjon.dsf.web.resources.person;

import no.nav.metrics.aspects.Count;
import no.nav.pensjon.dsf.dto.*;
import no.nav.metrics.aspects.ExceptionMetered;
import no.nav.metrics.aspects.Field;
import no.nav.metrics.aspects.Timed;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/person/{fnr}")
@Timed
@ExceptionMetered(cause = Throwable.class, logMethodAsUniqueMeasurement = false)
public class PersonEndpoint {

    private PersonService personService;

    @Inject
    public PersonEndpoint(PersonService service) {
        personService = service;
    }

    @Count(fields = @Field(key = "fnr", argumentNumber = "1"), logMethodAsUniqueMeasurement = false)
    @RequestMapping(method = RequestMethod.GET)
    public PersonDto findOne(@PathVariable String fnr) throws IOException {
        return personService.hentPerson(fnr);
    }

    @Count(fields = @Field(key = "fnr", argumentNumber = "1"), logMethodAsUniqueMeasurement = false)
    //@ExceptionMetered(name = "findInntekter.exceptions")
    @RequestMapping(value = "/inntekter", method = RequestMethod.GET)
    public List<InntektDto> findInntekter(@PathVariable String fnr) throws IOException {
        return personService.hentInntekter(fnr);
    }

    @Count(fields = @Field(key = "fnr", argumentNumber = "1"), logMethodAsUniqueMeasurement = false)
    @RequestMapping(value = "/etteroppgjor", method = RequestMethod.GET)
    public List<EtteroppgjorAFPDto> findEtteroppgjor(@PathVariable String fnr) throws IOException {
        return personService.hentEtteroppgjor(fnr);
    }

    @Count(fields = @Field(key = "fnr", argumentNumber = "1"), logMethodAsUniqueMeasurement = false)
    @RequestMapping(value = "/tilberpo", method = RequestMethod.GET)
    public List<TilberpoDto> findTilberpo(@PathVariable String fnr) throws IOException {
        return personService.hentTilberpo(fnr);
    }

    @Count(fields = @Field(key = "fnr", argumentNumber = "1"), logMethodAsUniqueMeasurement = false)
    @RequestMapping(value = "/status", method = RequestMethod.GET)
    public List<StatusDto> findStatus(@PathVariable String fnr) throws IOException {
        return personService.hentStatus(fnr);
    }

    @Count(fields = @Field(key = "fnr", argumentNumber = "1"), logMethodAsUniqueMeasurement = false)
    @RequestMapping(value = "/status/siste", method = RequestMethod.GET)
    public StatusDto findSisteStatus(@PathVariable String fnr) throws IOException {
        return personService.hentSisteStatus(fnr);
    }

    @Count(fields = @Field(key = "fnr", argumentNumber = "1"), logMethodAsUniqueMeasurement = false)
    @RequestMapping(value = "/uforeHistorikk", method = RequestMethod.GET)
    public List<UforeHistorikkDto> findUforeHistorikk(@PathVariable String fnr) throws IOException {
        return personService.hentUforehistorikk(fnr);
    }

    @Count(fields = @Field(key = "fnr", argumentNumber = "1"), logMethodAsUniqueMeasurement = false)
    @RequestMapping(value = "/tranHister", method = RequestMethod.GET)
    public List<TranHistDto> findTranhister(@PathVariable String fnr) throws IOException {
        return personService.hentTranhister(fnr);
    }
}
