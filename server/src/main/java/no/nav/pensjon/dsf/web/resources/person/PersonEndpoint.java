package no.nav.pensjon.dsf.web.resources.person;

import no.nav.pensjon.dsf.dto.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("api/person/{fnr}")
public class PersonEndpoint {

    private PersonService personService;

    @Inject
    public PersonEndpoint(PersonService service) {
        personService = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public PersonDto findOne(@PathVariable String fnr) {
        return personService.hentPerson(fnr);
    }

    @RequestMapping(value = "/inntekter", method = RequestMethod.GET)
    public List<InntektDto> findInntekter(@PathVariable String fnr) {
        return personService.hentInntekter(fnr);
    }

    @RequestMapping(value = "/etteroppgjor", method = RequestMethod.GET)
    public List<EtteroppgjorAFPDto> findEtteroppgjor(@PathVariable String fnr) {
        return personService.hentEtteroppgjor(fnr);
    }

    @RequestMapping(value = "/tilberpo", method = RequestMethod.GET)
    public List<TilberpoDto> findTilberpo(@PathVariable String fnr) {
        return personService.hentTilberpo(fnr);
    }

    @RequestMapping(value = "/status", method = RequestMethod.GET)
    public List<StatusDto> findStatus(@PathVariable String fnr) {
        return personService.hentStatus(fnr);
    }

    @RequestMapping(value = "/status/siste", method = RequestMethod.GET)
    public StatusDto findSisteStatus(@PathVariable String fnr) {
        return personService.hentSisteStatus(fnr);
    }

    @RequestMapping(value = "/uforeHistorikk", method = RequestMethod.GET)
    public List<UforeHistorikkDto> findUforeHistorikk(@PathVariable String fnr) {
        return personService.hentUforehistorikk(fnr);
    }

    @RequestMapping(value = "/tranHister", method = RequestMethod.GET)
    public List<TranHistDto> findTranhister(@PathVariable String fnr) {
        return personService.hentTranhister(fnr);
    }
}
