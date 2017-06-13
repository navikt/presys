package no.nav.pensjon.dsf.web.resources.person;

import no.nav.pensjon.dsf.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("api/person/{fnr}")
public class PersonEndpoint {

    @Autowired
    private PersonService personService;

    @RequestMapping()
    public PersonDto findOne(@PathVariable String fnr) throws IOException {
        return personService.hentPerson(fnr);
    }

    @RequestMapping("/inntekter")
    public List<InntektDto> findInntekter(@PathVariable String fnr) throws IOException {
        return personService.hentInntekter(fnr);
    }

    @RequestMapping("/etteroppgjor")
    public List<EtteroppgjorAFPDto> findEtteroppgjor(@PathVariable String fnr) throws IOException {
        return personService.hentEtteroppgjor(fnr);
    }

    @RequestMapping("/tilberpo")
    public List<TilberpoDto> findTilberpo(@PathVariable String fnr) throws IOException {
        return personService.hentTilberpo(fnr);
    }

    @RequestMapping("/status")
    public List<StatusDto> findStatus(@PathVariable String fnr) throws IOException {
        return personService.hentStatus(fnr);
    }

    @RequestMapping("/uforeHistorikk")
    public List<UforeHistorikkDto> findUforeHistorikk(@PathVariable String fnr) throws IOException {
        return personService.hentUforehistorikk(fnr);
    }

    @RequestMapping("/tranHister")
    public List<TranHistDto> findTranhister(@PathVariable String fnr) throws IOException {
        return personService.hentTranhister(fnr);
    }
}
