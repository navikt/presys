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

    private PersonRepository repo;

    private ModelMapper modelMapper;

    @Inject
    public PersonService(PersonRepository repository, ModelMapper mapper) {
        repo = repository;
        modelMapper = mapper;
    }

    public PersonDto hentPerson(String fnr) throws IOException {
        auditlog(fnr, "Hentet person-objekt");
        return modelMapper.map(repo.findPerson(fnr), PersonDto.class);
    }

    public List<InntektDto> hentInntekter(String fnr) throws IOException {
        auditlog(fnr, "Hentet inntekter for person");
        return repo.findPerson(fnr).getInntekter().stream()
                .map(inntekt -> modelMapper.map(inntekt, InntektDto.class))
                .collect(Collectors.toList());
    }

    public List<EtteroppgjorAFPDto> hentEtteroppgjor(String fnr) throws IOException {
        auditlog(fnr, "Hentet etteroppgjør for person");
        return repo.findPerson(fnr).getEtteroppgjor().stream()
                .map(etteroppgjorAFP -> modelMapper.map(etteroppgjorAFP, EtteroppgjorAFPDto.class))
                .collect(Collectors.toList());
    }

    public List<TilberpoDto> hentTilberpo(String fnr) throws IOException {
        auditlog(fnr, "Hentet tilhørigheter for person");
        return repo.findPerson(fnr).getTilberpo().stream()
                .map(tilberpo -> modelMapper.map(tilberpo, TilberpoDto.class))
                .collect(Collectors.toList());
    }

    @PreAuthorize("hasAuthority('0000-GA-PENSJON_UFORE')")
    public List<StatusDto> hentStatus(String fnr) throws IOException {
        auditlog(fnr, "Hentet statuser for person");
        return repo.findPerson(fnr).getStatus().stream()
                .map(status -> modelMapper.map(status, StatusDto.class))
                .collect(Collectors.toList());
    }

    @PreAuthorize("hasAuthority('0000-GA-PENSJON_UFORE')")
    public StatusDto hentSisteStatus(String fnr) throws IOException {
        auditlog(fnr, "Hentet den siste statusen for person");
        return repo.findPerson(fnr).getStatus().stream()
                .filter(Status::erSiste)
                .map(status -> modelMapper.map(status, StatusDto.class))
                .findAny()
                .orElseThrow(ResourceNotFound::new);
    }

    @PreAuthorize("hasAuthority('0000-GA-PENSJON_UFORE')")
    public List<UforeHistorikkDto> hentUforehistorikk(String fnr) throws IOException {
        /* finn siste status og returner uførehistorikken knyttet til denne */
        auditlog(fnr, "Hentet uførehistorikken for siste status for person");
        return repo.findPerson(fnr).getStatus().stream()
                .filter(Status::erSiste)
                .map(Status::getUforehistorikk)
                .flatMap(List::stream)
                .map(uforeHistorikk -> modelMapper.map(uforeHistorikk, UforeHistorikkDto.class))
                .collect(Collectors.toList());
    }

    public List<TranHistDto> hentTranhister(String fnr) throws IOException {
        auditlog(fnr, "Hentet tranhist-objekt for person");
        Function<TranHist, TranHistDto> mapper = tranhist ->{
            TranHistDto dto = modelMapper.map(tranhist, TranHistDto.class);
            switch (tranhist.getGrunnblankettkode()){
                case "F7":
                    GrunnblankettForesorgingsTilleggF7Dto grunnblankett= modelMapper.map(tranhist.getGrunnbif().get(0), GrunnblankettForesorgingsTilleggF7Dto.class);
                    PersonDto ektefelle = new PersonDto();
                    ektefelle.setFnr(tranhist.getGrunnbif().get(0).getFnrEktefelle());
                    ektefelle.setNavn(tranhist.getGrunnbif().get(0).getNavnEktefelle());
                    grunnblankett.setEktefelle(ektefelle);
                    dto.setGrunnblankett(grunnblankett);
                    break;
                case "UP":
                    dto.setGrunnblankett(modelMapper.map(tranhist.getGrunnbuper().get(0), GrunnbupDto.class));
                    break;
                case "O1":
                    dto.setGrunnblankett(modelMapper.map(tranhist.getOpphbl1er().get(0), Opphorsblankett1Dto.class));
                    break;
                case "O2":
                    dto.setGrunnblankett(modelMapper.map(tranhist.getOpphbl2er().get(0), Opphorsblankett2Dto.class));
                    break;
                case "KF":
                    dto.setGrunnblankett(modelMapper.map(tranhist.getGrunnbkfer().get(0), GrunnblankettNyAFPDto.class));
                    break;
                case "U2":
                    dto.setGrunnblankett(modelMapper.map(tranhist.getGrunnbu2er().get(0), GrunnblankettUforepensjon2Dto.class));
                    break;
                case "U3":
                    dto.setGrunnblankett(modelMapper.map(tranhist.getGrunnbu3er().get(0), GrunnblankettUforepensjonDto.class));
                    break;
                case "E3":
                    dto.setGrunnblankett(modelMapper.map(tranhist.getGrunnbe3er().get(0), GrunnblankettEtterlattEktefelleDto.class));
                    break;
                case "E4":
                    dto.setGrunnblankett(modelMapper.map(tranhist.getGrblfae4er().get(0), GrunnblankettEtterlattFamiliepleieE4Dto.class));
                    break;
                case "E1":
                    dto.setGrunnblankett(modelMapper.map(tranhist.getEndringsblankett().get(0), GrunnblankettEndringsblankettDto.class));
                    break;
                case "EN":
                    dto.setGrunnblankett(modelMapper.map(tranhist.getEnblan1er().get(0), GrunnblankettEndringsblankettEnDto.class));
                    break;
                case "AP":
                    dto.setGrunnblankett(modelMapper.map(tranhist.getGrunnbaper().get(0), GrunnblankettAlderspensjonDto.class));
                    break;
                case "A1":
                    dto.setGrunnblankett(modelMapper.map(tranhist.getGrunnba1er().get(0), GrunnblankettAlderspensjon1Dto.class));
                    break;
                case "EP":
                    dto.setGrunnblankett(modelMapper.map(tranhist.getGrunnbeper().get(0), GrunnblankettEtterlattEktefelleEpDto.class));
                    break;
                case "EE":
                    dto.setGrunnblankett(modelMapper.map(tranhist.getGrunnbeeer().get(0), GrunnblankettEtterlattEktefelleEeDto.class));
                    break;
                case "US":
                    dto.setGrunnblankett(modelMapper.map(tranhist.getGrblufster().get(0), GrunnstonadHjelpestonadDto.class));
                    break;
                case "FT":
                    dto.setGrunnblankett(modelMapper.map(tranhist.getGrblforser().get(0), GrunnblankettForsorgertilleggEktefelleBarnDto.class));
                    break;
                case "EF":
                    dto.setGrunnblankett(modelMapper.map(tranhist.getGrblfamper().get(0), GrunnblankettEtterlattFamiliepleieDto.class));
                    break;
                case "BP":
                    dto.setGrunnblankett(modelMapper.map(tranhist.getGrblebener().get(0), GrunnblankettBarnepensjonEnForeldreDodDto.class));
                    break;
                case "B6":
                    dto.setGrunnblankett(modelMapper.map(tranhist.getGrblebb6er().get(0), GrunnblankettBarnepensjonEnForeldreDodB6Dto.class));
                    break;
                case "FB":
                    dto.setGrunnblankett(modelMapper.map(tranhist.getGrblebbeer().get(0), GrunnblankettForeldreloseBarnDto.class));
                    break;
                case "FO":
                    dto.setGrunnblankett(modelMapper.map(tranhist.getGrunnbfer().get(0), GrunnblankettForsorgertilleggEktefelleOgEllerBarnDto.class));
                    break;
                case "MV":
                    dto.setGrunnblankett(modelMapper.map(tranhist.getGrunnbyper().get(0), GrunnblankettYrkesskadePensjonDto.class));
                    break;
                case "UF":
                    dto.setGrunnblankett(modelMapper.map(tranhist.getGrunnbufer().get(0), GrunnblankettUngUforFor1967Dto.class));
                    break;
                case "AF":
                    dto.setGrunnblankett(modelMapper.map(tranhist.getGrunnbafer().get(0), GrunnblankettAvtalefestetPensjonDto.class));
                    break;


                default:
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
     * @param target fodselsnummer til den som har blitt aksessert
     * @param grunn Grunnen til at (hvilke opplysninger om) personen har blitt aksessert.
     */
    private static void auditlog(String target, String grunn) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String user = userDetails.getUsername();
        MDC.put("user", user);
        MDC.put("target", target);
        LOG.info("Presys gjorde en aksess av (" + target + ") på oppdrag av <" + user + ">. Grunnen var (" + grunn + ")");
        MDC.clear();
    }
}
