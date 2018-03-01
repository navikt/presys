package no.nav.pensjon.dsf.authz.abac;

import no.nav.abac.xacml.NavAttributter;
import no.nav.abac.xacml.StandardAttributter;
import no.nav.freg.abac.core.dto.request.XacmlRequest;
import no.nav.freg.abac.core.dto.response.Decision;
import no.nav.freg.abac.core.dto.response.XacmlResponse;
import no.nav.freg.abac.core.service.AbacService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class AbacEvaluator {

    private static final Logger LOG = LoggerFactory.getLogger("AUDITLOG");

    private AbacService abacService;

    public AbacEvaluator(AbacService abacService) {
        this.abacService = abacService;
    }

    public boolean harTilgangTilPerson(String hvem, String hva) {
        LOG.debug("Evaluerer tilgang til {} for {}", hva, hvem);

        XacmlRequest request = new XacmlRequest();

        request.failOnIndeterminate(true);
        request.bias(Decision.DENY);

        request.environment(NavAttributter.ENVIRONMENT_FELLES_PEP_ID, "presys");

        request.accessSubject(StandardAttributter.SUBJECT_ID, hvem);
        request.accessSubject(NavAttributter.SUBJECT_FELLES_SUBJECTTYPE, "InternBruker");

        request.resource(NavAttributter.RESOURCE_FELLES_DOMENE, "pensjon");
        request.resource(NavAttributter.RESOURCE_FELLES_PERSON_FNR, hva);
        request.resource(NavAttributter.RESOURCE_FELLES_RESOURCE_TYPE, NavAttributter.RESOURCE_FELLES_PERSON);

        request.action(StandardAttributter.ACTION_ID, "read");

        try {
            XacmlResponse response = abacService.evaluate(request);
            return response.getDecision() == Decision.PERMIT;
        } catch (RuntimeException e) {
            throw new RuntimeException("Feil ved ABAC-kall", e);
        }
    }
}
