package no.nav.pensjon.dsf.web.resources.person;

import no.nav.pensjon.dsf.domene.status.Status;
import no.nav.pensjon.dsf.dto.*;
import no.nav.pensjon.dsf.repository.PersonRepository;
import no.nav.pensjon.dsf.web.Exceptions.ResourceNotFound;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    @Inject
    private PersonRepository repo;

    @Autowired
    private ModelMapper modelMapper;

    public PersonDto hentPerson(String fnr) throws IOException {
        return modelMapper.map(repo.findPerson(fnr), PersonDto.class);
    }

    public List<InntektDto> hentInntekter(String fnr) throws IOException {
        return repo.findPerson(fnr).getInntekter().stream()
                .map(inntekt -> modelMapper.map(inntekt, InntektDto.class))
                .collect(Collectors.toList());
    }

    public List<EtteroppgjorAFPDto> hentEtteroppgjor(String fnr) throws IOException {
        return repo.findPerson(fnr).getEtteroppgjor().stream()
                .map(etteroppgjorAFP -> modelMapper.map(etteroppgjorAFP, EtteroppgjorAFPDto.class))
                .collect(Collectors.toList());
    }

    public List<TilberpoDto> hentTilberpo(String fnr) throws IOException {
        return repo.findPerson(fnr).getTilberpo().stream()
                .map(tilberpo -> modelMapper.map(tilberpo, TilberpoDto.class))
                .collect(Collectors.toList());
    }

    @PreAuthorize("hasAuthority('0000-GA-PENSJON_UFORE')")
    public List<StatusDto> hentStatus(String fnr) throws IOException {
        return repo.findPerson(fnr).getStatus().stream()
                .map(status -> modelMapper.map(status, StatusDto.class))
                .collect(Collectors.toList());
    }

    @PreAuthorize("hasAuthority('0000-GA-PENSJON_UFORE')")
    public StatusDto hentSisteStatus(String fnr) throws IOException {
        return repo.findPerson(fnr).getStatus().stream()
                .filter(Status::erSiste)
                .map(status -> modelMapper.map(status, StatusDto.class))
                .findAny()
                .orElseThrow(ResourceNotFound::new);
    }

    @PreAuthorize("hasAuthority('0000-GA-PENSJON_UFORE')")
    public List<UforeHistorikkDto> hentUforehistorikk(String fnr) throws IOException {
        /* finn siste status og returner uførehistorikken knyttet til denne */
        return repo.findPerson(fnr).getStatus().stream()
                .filter(Status::erSiste)
                .map(Status::getUforehistorikk)
                .flatMap(List::stream)
                .map(uforeHistorikk -> modelMapper.map(uforeHistorikk, UforeHistorikkDto.class))
                .collect(Collectors.toList());
    }

    public List<TranHistDto> hentTranhister(String fnr) throws IOException {
        return repo.findPerson(fnr).getTranHister().stream()
                .map(tranhist -> modelMapper.map(tranhist, TranHistDto.class))
                .collect(Collectors.toList());
    }
}
