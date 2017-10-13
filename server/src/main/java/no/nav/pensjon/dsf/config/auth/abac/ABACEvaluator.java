package no.nav.pensjon.dsf.config.auth.abac;

import no.nav.abac.xacml.NavAttributter;
import no.nav.freg.abac.core.annotation.Abac;
import no.nav.freg.abac.core.annotation.context.AbacContext;
import no.nav.freg.abac.core.dto.response.Decision;
import no.nav.freg.abac.core.dto.response.XacmlResponse;
import no.nav.freg.abac.core.service.AbacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class ABACEvaluator {

    @Autowired
    private AbacService abacService;

    @Autowired
    private AbacContext abacContext;

    @Abac(bias = Decision.DENY, failOnIndeterminate = true)
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        abacContext.getRequest().resource(NavAttributter.RESOURCE_FELLES_PERSON_FNR, targetDomainObject);
        abacContext.getRequest().resource(NavAttributter.RESOURCE_FELLES_RESOURCE_TYPE, permission);

        XacmlResponse response = abacService.evaluate(abacContext.getRequest());
        return response.getDecision() == Decision.PERMIT;
    }
}
