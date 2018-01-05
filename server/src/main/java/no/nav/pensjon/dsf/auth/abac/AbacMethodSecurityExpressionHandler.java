package no.nav.pensjon.dsf.auth.abac;

import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

public class AbacMethodSecurityExpressionHandler extends DefaultMethodSecurityExpressionHandler {
    private static final Logger LOG = LoggerFactory.getLogger(AbacMethodSecurityExpressionHandler.class);
    private AbacEvaluator abacEvaluator;

    AbacMethodSecurityExpressionHandler(AbacEvaluator abacEvaluator) {
        this.abacEvaluator = abacEvaluator;
    }

    @Override
    protected MethodSecurityExpressionOperations createSecurityExpressionRoot(
            Authentication authentication, MethodInvocation invocation) {
        AbacMethodSecurityExpressionRoot root = new AbacMethodSecurityExpressionRoot(abacEvaluator, authentication);
        root.setThis(invocation.getThis());
        root.setPermissionEvaluator(getPermissionEvaluator());
        root.setTrustResolver(getTrustResolver());
        root.setRoleHierarchy(getRoleHierarchy());
        root.setDefaultRolePrefix(getDefaultRolePrefix());

        return root;
    }

    private static class AbacMethodSecurityExpressionRoot extends SecurityExpressionRoot implements MethodSecurityExpressionOperations {

        private final AbacEvaluator abacEvaluator;
        private Object filterObject;
        private Object returnObject;
        private Object target;

        AbacMethodSecurityExpressionRoot(AbacEvaluator abacEvaluator, Authentication a) {
            super(a);
            this.abacEvaluator = abacEvaluator;
        }

        public boolean harTilgangTilPerson(String fnr) {
            LOG.debug("Sjekker om tilgang til {} for {}", fnr, ((UserDetails)getPrincipal()).getUsername());
            return abacEvaluator.harTilgangTilPerson(((UserDetails)getPrincipal()).getUsername(), fnr);
        }

        public void setFilterObject(Object filterObject) {
            this.filterObject = filterObject;
        }

        public Object getFilterObject() {
            return filterObject;
        }

        public void setReturnObject(Object returnObject) {
            this.returnObject = returnObject;
        }

        public Object getReturnObject() {
            return returnObject;
        }

        /**
         * Sets the "this" property for use in expressions. Typically this will be the "this"
         * property of the {@code JoinPoint} representing the method invocation which is being
         * protected.
         *
         * @param target the target object on which the method in is being invoked.
         */
        void setThis(Object target) {
            this.target = target;
        }

        public Object getThis() {
            return target;
        }
    }
}

