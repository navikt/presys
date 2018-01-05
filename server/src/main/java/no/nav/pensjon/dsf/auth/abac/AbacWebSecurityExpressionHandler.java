package no.nav.pensjon.dsf.auth.abac;

import org.springframework.security.access.expression.SecurityExpressionOperations;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.access.expression.WebSecurityExpressionRoot;

public class AbacWebSecurityExpressionHandler extends DefaultWebSecurityExpressionHandler {

    private AbacEvaluator abacEvaluator;

    AbacWebSecurityExpressionHandler(AbacEvaluator abacEvaluator) {
        this.abacEvaluator = abacEvaluator;
    }

    @Override
    protected SecurityExpressionOperations createSecurityExpressionRoot(Authentication authentication, FilterInvocation fi) {
        WebSecurityExpressionRoot root = new AbacWebSecurityExpressionRoot(abacEvaluator, authentication, fi);
        root.setPermissionEvaluator(getPermissionEvaluator());
        root.setTrustResolver(new AuthenticationTrustResolverImpl());
        root.setRoleHierarchy(getRoleHierarchy());
        root.setDefaultRolePrefix("ROLE_");

        return root;
    }

    private static class AbacWebSecurityExpressionRoot extends WebSecurityExpressionRoot {

        private final AbacEvaluator abacEvaluator;

        AbacWebSecurityExpressionRoot(AbacEvaluator abacEvaluator, Authentication a, FilterInvocation fi) {
            super(a, fi);
            this.abacEvaluator = abacEvaluator;
        }

        public boolean harTilgangTilPerson(String fnr) {
            return abacEvaluator.harTilgangTilPerson(((UserDetails)getPrincipal()).getUsername(), fnr);
        }
    }
}
