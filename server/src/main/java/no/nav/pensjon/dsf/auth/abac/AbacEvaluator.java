package no.nav.pensjon.dsf.auth.abac;

import no.nav.abac.xacml.NavAttributter;
import no.nav.abac.xacml.StandardAttributter;
import no.nav.freg.abac.core.dto.request.XacmlRequest;
import no.nav.freg.abac.core.dto.response.Decision;
import no.nav.freg.abac.core.dto.response.XacmlResponse;
import no.nav.freg.abac.core.service.AbacService;

class AbacEvaluator {

    private AbacService abacService;

    public AbacEvaluator(AbacService abacService) {
        this.abacService = abacService;
    }

    public boolean harTilgangTilPerson(String hvem, String hva) {
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

        XacmlResponse response = abacService.evaluate(request);
        return response.getDecision() == Decision.PERMIT;
    }
}
