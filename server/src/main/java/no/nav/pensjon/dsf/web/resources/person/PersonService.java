package no.nav.pensjon.dsf.web.resources.person;

import no.nav.abac.xacml.NavAttributter;
import no.nav.freg.abac.core.annotation.Abac;
import no.nav.freg.abac.core.annotation.context.AbacContext;
import no.nav.freg.abac.core.dto.response.Decision;
import no.nav.freg.abac.core.dto.response.XacmlResponse;
import no.nav.freg.abac.core.service.AbacService;
import no.nav.pensjon.dsf.abac.attributes.PresysAttributes;
import no.nav.pensjon.dsf.domene.Person;
import no.nav.pensjon.dsf.domene.grunnblanketter.GRUNNBIF;
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
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.io.IOException;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private static final Logger LOG = LoggerFactory.getLogger("AUDITLOG");
    private static final Logger LOGG = LoggerFactory.getLogger(PersonService.class);

    private PersonRepository repo;

    private ModelMapper modelMapper;

    @Autowired
    private AbacService abacService;

    @Autowired
    private AbacContext abacContext;


    private  Map<String, BiConsumer<TranHist, TranHistDto>> grunnblankettMappers= new HashMap<>();

    @Inject
    public PersonService(PersonRepository repository, ModelMapper mapper) {
        repo = repository;
        modelMapper = mapper;

        grunnblankettMappers.put("F7", (domene, dto)-> dto.setGrunnblankett(mapGrunnblankettForesorgingsTilleggF7(domene.getGrunnbif().get(0))));
        grunnblankettMappers.put("UP", (domene, dto)->dto.setGrunnblankett(modelMapper.map(domene.getGrunnbuper().get(0), GrunnbupDto.class)));
        grunnblankettMappers.put("O1", (domene, dto)->dto.setGrunnblankett(modelMapper.map(domene.getOpphbl1er().get(0), Opphorsblankett1Dto.class)));
        grunnblankettMappers.put("O2", (domene, dto)->dto.setGrunnblankett(modelMapper.map(domene.getOpphbl2er().get(0), Opphorsblankett2Dto.class)));
        grunnblankettMappers.put("KF", (domene, dto)->dto.setGrunnblankett(modelMapper.map(domene.getGrunnbkfer().get(0), GrunnblankettNyAFPDto.class)));
        grunnblankettMappers.put("U2", (domene, dto)->dto.setGrunnblankett(modelMapper.map(domene.getGrunnbu2er().get(0), GrunnblankettUforepensjon2Dto.class)));
        grunnblankettMappers.put("U3", (domene, dto)->dto.setGrunnblankett(modelMapper.map(domene.getGrunnbu3er().get(0), GrunnblankettUforepensjonDto.class)));
        grunnblankettMappers.put("E3", (domene, dto)->dto.setGrunnblankett(modelMapper.map(domene.getGrunnbe3er().get(0), GrunnblankettEtterlattEktefelleDto.class)));
        grunnblankettMappers.put("E1", (domene, dto)->dto.setGrunnblankett(modelMapper.map(domene.getEndringsblankett().get(0), GrunnblankettEndringsblankettDto.class)));
        grunnblankettMappers.put("EN", (domene, dto)->dto.setGrunnblankett(modelMapper.map(domene.getEnblan1er().get(0), GrunnblankettEndringsblankettEnDto.class)));
        grunnblankettMappers.put("AP", (domene, dto)->dto.setGrunnblankett(modelMapper.map(domene.getGrunnbaper().get(0), GrunnblankettAlderspensjonDto.class)));
        grunnblankettMappers.put("A1", (domene, dto)->dto.setGrunnblankett(modelMapper.map(domene.getGrunnba1er().get(0), GrunnblankettAlderspensjon1Dto.class)));
        grunnblankettMappers.put("EP", (domene, dto)->dto.setGrunnblankett(modelMapper.map(domene.getGrunnbeper().get(0), GrunnblankettEtterlattEktefelleEpDto.class)));
        grunnblankettMappers.put("EE", (domene, dto)->dto.setGrunnblankett(modelMapper.map(domene.getGrunnbeeer().get(0), GrunnblankettEtterlattEktefelleEeDto.class)));
        grunnblankettMappers.put("US", (domene, dto)->dto.setGrunnblankett(modelMapper.map(domene.getGrblufster().get(0), GrunnstonadHjelpestonadDto.class)));
        grunnblankettMappers.put("FT", (domene, dto)->dto.setGrunnblankett(modelMapper.map(domene.getGrblforser().get(0), GrunnblankettForsorgertilleggEktefelleBarnDto.class)));
        grunnblankettMappers.put("EF", (domene, dto)->dto.setGrunnblankett(modelMapper.map(domene.getGrblfamper().get(0), GrunnblankettEtterlattFamiliepleieDto.class)));
        grunnblankettMappers.put("BP", (domene, dto)->dto.setGrunnblankett(modelMapper.map(domene.getGrblebener().get(0), GrunnblankettBarnepensjonEnForeldreDodDto.class)));
        grunnblankettMappers.put("B6", (domene, dto)->dto.setGrunnblankett(modelMapper.map(domene.getGrblebb6er().get(0), GrunnblankettBarnepensjonEnForeldreDodB6Dto.class)));
        grunnblankettMappers.put("FB", (domene, dto)->dto.setGrunnblankett(modelMapper.map(domene.getGrblebbeer().get(0), GrunnblankettForeldreloseBarnDto.class)));
        grunnblankettMappers.put("FO", (domene, dto)->dto.setGrunnblankett(modelMapper.map(domene.getGrunnbfer().get(0), GrunnblankettForsorgertilleggEktefelleOgEllerBarnDto.class)));
        grunnblankettMappers.put("MV", (domene, dto)->dto.setGrunnblankett(modelMapper.map(domene.getGrunnbyper().get(0), GrunnblankettYrkesskadePensjonDto.class)));
        grunnblankettMappers.put("UF", (domene, dto)->dto.setGrunnblankett(modelMapper.map(domene.getGrunnbufer().get(0), GrunnblankettUngUforFor1967Dto.class)));
        grunnblankettMappers.put("AF", (domene, dto)->dto.setGrunnblankett(modelMapper.map(domene.getGrunnbafer().get(0), GrunnblankettAvtalefestetPensjonDto.class)));
    }

    @Abac(bias = Decision.DENY, failOnIndeterminate = true)
    public PersonDto hentPerson(String fnr) throws IOException {

        godkjennerRequesterMedAbac(fnr, NavAttributter.RESOURCE_FELLES_PERSON);

        auditlog(fnr, "Henter person-objekt");
        return modelMapper.map(repo.findPerson(fnr), PersonDto.class);
    }

    /**
     * Gjør request mot abac om leserequesten fra saksbehandler til bruker godkjennes. Hvis requesten ikke godkjennes av
     * ABAC kastes en AccessDeniedException. Hvis det returneres en obligation Presys ikke vet hvordan behandle kastes en
     * UnhandledObligationException. (Ingen ObligationStrategy'er er laget siden det ikke er innført noen obligations per
     * dd.
     * @param fnr fødselsnummer som det skal sjekkes om saksbehandler har tilgang på.
     */
    private void godkjennerRequesterMedAbac(String fnr, String resourceType) {
        abacContext.getRequest().resource(NavAttributter.RESOURCE_FELLES_PERSON_FNR, fnr);
        abacContext.getRequest().resource(NavAttributter.RESOURCE_FELLES_RESOURCE_TYPE, resourceType);

        XacmlResponse response = abacService.evaluate(abacContext.getRequest());
        if(response.getDecision() != Decision.PERMIT) {
            throw new AccessDeniedException("Abac har ikke returnert en PERMIT. Den returnerte Decision er: " + response.getOriginalDecision());
        }
    }

    @Abac(bias = Decision.DENY, failOnIndeterminate = true)
    public List<InntektDto> hentInntekter(String fnr) throws IOException {
        godkjennerRequesterMedAbac(fnr, PresysAttributes.RESOURCE_INNTEKTER);

        auditlog(fnr, "Henter inntekter for person");

        Person person = repo.findPerson(fnr);
        List<InntektDto> inntekter = new ArrayList<>();
        person.getTilberpo().forEach(t->{
            inntekter.add(inntekt(t.getAi63(), 1963, "AI"));
            inntekter.add(inntekt(t.getAi64(), 1964, "AI"));
            inntekter.add(inntekt(t.getAi65(), 1965, "AI"));
            inntekter.add(inntekt(t.getAi66(), 1966, "AI"));
            inntekter.add(inntekt(t.getPi66(), 1966, "PI"));
        });
        if(inntekter.isEmpty()){
            inntekter.add(inntekt(0, 1963, "AI"));
            inntekter.add(inntekt(0, 1964, "AI"));
            inntekter.add(inntekt(0, 1965, "AI"));
            inntekter.add(inntekt(0, 1966, "AI"));
            inntekter.add(inntekt(0, 1966, "PI"));
        }
        inntekter.add(inntekt(person.getAi67() * 100, 1967, "AI"));

        inntekter.addAll(person.getInntekter().stream()
                .map(inntekt -> modelMapper.map(inntekt, InntektDto.class))
                .collect(Collectors.toList()));

        return inntekter;
    }

    private InntektDto inntekt(int belop, int aar, String type){
        InntektDto inntekt = new InntektDto();
        inntekt.setKommune("");
        inntekt.setPersonInntekt(belop);
        inntekt.setPersonInntektMerke("");
        inntekt.setPersonInntektAar(aar);
        inntekt.setPersonInntektType(type);
        inntekt.setRapporteringsDato(0);
        return inntekt;
    }

    @Abac(bias = Decision.DENY, failOnIndeterminate = true)
    public List<EtteroppgjorAFPDto> hentEtteroppgjor(String fnr) throws IOException {
        godkjennerRequesterMedAbac(fnr, PresysAttributes.ETTEROPPGJOR);

        auditlog(fnr, "Henter etteroppgjør for person");
        return repo.findPerson(fnr).getEtteroppgjor().stream()
                .map(etteroppgjorAFP -> modelMapper.map(etteroppgjorAFP, EtteroppgjorAFPDto.class))
                .collect(Collectors.toList());
    }

    @Abac(bias = Decision.DENY, failOnIndeterminate = true)
    public List<TilberpoDto> hentTilberpo(String fnr) throws IOException {
        godkjennerRequesterMedAbac(fnr, PresysAttributes.TILHORIGHETER);

        auditlog(fnr, "Henter tilhørigheter for person");
        return repo.findPerson(fnr).getTilberpo().stream()
                .map(tilberpo -> modelMapper.map(tilberpo, TilberpoDto.class))
                .collect(Collectors.toList());
    }

    @Abac(bias = Decision.DENY, failOnIndeterminate = true)
    public List<StatusDto> hentStatus(String fnr) throws IOException {
        godkjennerRequesterMedAbac(fnr, PresysAttributes.STATUS);

        auditlog(fnr, "Henter statuser for person");
        return repo.findPerson(fnr).getStatus().stream()
                .map(status -> modelMapper.map(status, StatusDto.class))
                .collect(Collectors.toList());
    }

    @Abac(bias = Decision.DENY, failOnIndeterminate = true)
    public StatusDto hentSisteStatus(String fnr) throws IOException {
        godkjennerRequesterMedAbac(fnr, PresysAttributes.STATUS);

        auditlog(fnr, "Henter den siste statusen for person");
        return repo.findPerson(fnr).getStatus().stream()
                .filter(Status::erSiste)
                .map(status -> modelMapper.map(status, StatusDto.class))
                .findAny()
                .orElseThrow(ResourceNotFound::new);
    }

    @Abac(bias = Decision.DENY, failOnIndeterminate = true)
    public List<UforeHistorikkDto> hentUforehistorikk(String fnr) throws IOException {
        /* finn siste status og returner uførehistorikken knyttet til denne */
        godkjennerRequesterMedAbac(fnr, PresysAttributes.UFOREHISTORIKK);

        auditlog(fnr, "Henter uførehistorikken for siste status for person");
        return repo.findPerson(fnr).getStatus().stream()
                .filter(Status::erSiste)
                .map(Status::getUforehistorikk)
                .flatMap(List::stream)
                .map(uforeHistorikk -> modelMapper.map(uforeHistorikk, UforeHistorikkDto.class))
                .collect(Collectors.toList());
    }

    @Abac(bias = Decision.DENY, failOnIndeterminate = true)
    public List<TranHistDto> hentTranhister(String fnr) throws IOException {
        godkjennerRequesterMedAbac(fnr, PresysAttributes.TRANHIST);

        auditlog(fnr, "Henter grunnblanketter for person");
        return repo.findPerson(fnr).getTranHister().stream()
                .map(this::transhistMapper )
                .filter(t->Objects.nonNull(t.getGrunnblankett()))
                .collect(Collectors.toList());
    }

    private GrunnblankettForesorgingsTilleggF7Dto mapGrunnblankettForesorgingsTilleggF7(GRUNNBIF domene) {
        GrunnblankettForesorgingsTilleggF7Dto grunnblankett= modelMapper.map(domene, GrunnblankettForesorgingsTilleggF7Dto.class);
        PersonDto ektefelle = new PersonDto();
        ektefelle.setFnr(domene.getFnrEktefelle());
        ektefelle.setNavn(domene.getNavnEktefelle());
        grunnblankett.setEktefelle(ektefelle);
        return grunnblankett;
    }

    private TranHistDto transhistMapper(TranHist tranhist){
        TranHistDto dto = modelMapper.map(tranhist, TranHistDto.class);
        try {
            Optional.ofNullable(grunnblankettMappers.get(tranhist.getGrunnblankettkode())).ifPresent(c->c.accept(tranhist, dto));
        }catch (IndexOutOfBoundsException e){
            LOGG.warn("Mangler grunnblankett", e);
        }
        return dto;
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
