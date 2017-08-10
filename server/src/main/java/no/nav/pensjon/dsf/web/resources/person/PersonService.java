package no.nav.pensjon.dsf.web.resources.person;

import no.nav.pensjon.dsf.domene.grunnblanketter.TranHist;
import no.nav.pensjon.dsf.domene.status.Status;
import no.nav.pensjon.dsf.dto.*;
import no.nav.pensjon.dsf.repository.PersonRepository;
import no.nav.pensjon.dsf.web.Exceptions.ResourceNotFound;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.io.IOException;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private static final Logger LOG = LoggerFactory.getLogger("AUDITLOG");

    @Inject
    private PersonRepository repo;

    @Autowired
    private ModelMapper modelMapper;

    public PersonDto hentPerson(String fnr) throws IOException {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        auditlog(userDetails.getUsername(), fnr, "Hentet person-objekt");
        return modelMapper.map(repo.findPerson(fnr), PersonDto.class);
    }

    public List<InntektDto> hentInntekter(String fnr) throws IOException {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        auditlog(userDetails.getUsername(), fnr, "Hentet inntekter for person");
        return repo.findPerson(fnr).getInntekter().stream()
                .map(inntekt -> modelMapper.map(inntekt, InntektDto.class))
                .collect(Collectors.toList());
    }

    public List<EtteroppgjorAFPDto> hentEtteroppgjor(String fnr) throws IOException {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        auditlog(userDetails.getUsername(), fnr, "Hentet etteroppgjør for person");
        return repo.findPerson(fnr).getEtteroppgjor().stream()
                .map(etteroppgjorAFP -> modelMapper.map(etteroppgjorAFP, EtteroppgjorAFPDto.class))
                .collect(Collectors.toList());
    }

    public List<TilberpoDto> hentTilberpo(String fnr) throws IOException {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        auditlog(userDetails.getUsername(), fnr, "Hentet tilhørigheter for person");
        return repo.findPerson(fnr).getTilberpo().stream()
                .map(tilberpo -> modelMapper.map(tilberpo, TilberpoDto.class))
                .collect(Collectors.toList());
    }

    @PreAuthorize("hasAuthority('0000-GA-PENSJON_UFORE')")
    public List<StatusDto> hentStatus(String fnr) throws IOException {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        auditlog(userDetails.getUsername(), fnr, "Hentet statuser for person");
        return repo.findPerson(fnr).getStatus().stream()
                .map(status -> modelMapper.map(status, StatusDto.class))
                .collect(Collectors.toList());
    }

    @PreAuthorize("hasAuthority('0000-GA-PENSJON_UFORE')")
    public StatusDto hentSisteStatus(String fnr) throws IOException {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        auditlog(userDetails.getUsername(), fnr, "Hentet den siste statusen for person");
        return repo.findPerson(fnr).getStatus().stream()
                .filter(Status::erSiste)
                .map(status -> modelMapper.map(status, StatusDto.class))
                .findAny()
                .orElseThrow(ResourceNotFound::new);
    }

    @PreAuthorize("hasAuthority('0000-GA-PENSJON_UFORE')")
    public List<UforeHistorikkDto> hentUforehistorikk(String fnr) throws IOException {
        /* finn siste status og returner uførehistorikken knyttet til denne */
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        auditlog(userDetails.getUsername(), fnr, "Hentet uførehistorikken for siste status for person");
        return repo.findPerson(fnr).getStatus().stream()
                .filter(Status::erSiste)
                .map(Status::getUforehistorikk)
                .flatMap(List::stream)
                .map(uforeHistorikk -> modelMapper.map(uforeHistorikk, UforeHistorikkDto.class))
                .collect(Collectors.toList());
    }

    public List<TranHistDto> hentTranhister(String fnr) throws IOException {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        auditlog(userDetails.getUsername(), fnr, "Hentet tranhist-objekt for person");
        Function<TranHist, TranHistDto> mapper = tranhist ->{
            TranHistDto dto = modelMapper.map(tranhist, TranHistDto.class);
            switch (tranhist.getGrunnblankettkode()){
                case "F7":
                    GrunnblankettForesorgingsTilleggF7Dto grunnblankett= modelMapper.map(tranhist.getGrunnbif().get(0), GrunnblankettForesorgingsTilleggF7Dto.class);
                    PersonDto ektefelle = new PersonDto();
                    ektefelle.setFnr(tranhist.getGrunnbif().get(0).getFnrEktefelle());
                    ektefelle.setNavn(tranhist.getGrunnbif().get(0).getNavnEktefelle());
                    ektefelle.setAvailableForLookup(repo.exists(ektefelle.getFnr()));
                    grunnblankett.setEktefelle(ektefelle);
                    dto.setGrunnblankett(grunnblankett);
            }
            return dto;
        };


        return repo.findPerson(fnr).getTranHister().stream()
                .map(mapper )
                .collect(Collectors.toList());
    }

    /**
     * Hjelpe-metode for å gjøre audit-logging
     *
     * @param user NAV-ident som har aksessert person
     * @param target fodselsnummer til den som har blitt aksessert
     * @param grunn Grunnen til at (hvilke opplysninger om) personen har blitt aksessert.
     */
    private void auditlog(String user, String target, String grunn) {
        MDC.put("user", user);
        MDC.put("target", target);
        LOG.info("Presys gjorde en aksess av (" + target + ") på oppdrag av <" + user + ">. Grunnen var (" + grunn + ")");
        MDC.clear();
    }
}
