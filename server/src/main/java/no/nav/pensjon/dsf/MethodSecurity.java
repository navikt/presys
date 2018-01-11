package no.nav.pensjon.dsf;

import no.nav.pensjon.dsf.auth.abac.AbacMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

// deaktiverer method security for å teste startup-tid
//@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MethodSecurity extends GlobalMethodSecurityConfiguration {
    private final AbacMethodSecurityExpressionHandler expressionHandler;

    public MethodSecurity(AbacMethodSecurityExpressionHandler expressionHandler) {
        this.expressionHandler = expressionHandler;
    }

    @Override
    protected MethodSecurityExpressionHandler createExpressionHandler() {
        return expressionHandler;
    }
}
