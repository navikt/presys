package no.nav.autoconfigure.ldap;

import no.nav.autoconfigure.serviceuser.ServiceUserProperties;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.UnsatisfiedDependencyException;
import org.springframework.boot.autoconfigure.context.PropertyPlaceholderAutoConfiguration;
import org.springframework.boot.autoconfigure.ldap.LdapAutoConfiguration;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.security.ldap.authentication.AbstractLdapAuthenticationProvider;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertNotNull;

public class LdapProviderAutoConfigurationTest {

    private AnnotationConfigApplicationContext context;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setup() {
        context = new AnnotationConfigApplicationContext();
    }

    @After
    public void close() {
        if (context == null) {
            return;
        }

        context.close();
    }

    @Test
    public void thatNoLdapUserSearchOrDNPatternThrows() {
        thrown.expect(UnsatisfiedDependencyException.class);
        thrown.expectMessage(containsString("Either an LdapUserSearch or DN pattern (or both) must be supplied"));

        load("");
        AbstractLdapAuthenticationProvider ldapProvider = context.getBean(AbstractLdapAuthenticationProvider.class);
        assertNotNull(ldapProvider);
    }

    @Test
    public void testBindUsingUser() {
        load("ldap.provider.user-dn-pattern:CN={0},OU=Users");
        AbstractLdapAuthenticationProvider ldapProvider = context.getBean(AbstractLdapAuthenticationProvider.class);
        assertNotNull(ldapProvider);
    }

    @Test
    public void thatMissingUserSearchThrows() {
        thrown.expect(UnsatisfiedDependencyException.class);
        thrown.expectMessage(containsString(" searchBase must not be null (an empty string is acceptable)"));

        load("ldap.username:CN=foo,OU=ServiceAccounts", "ldap.password:bar");
        AbstractLdapAuthenticationProvider ldapProvider = context.getBean(AbstractLdapAuthenticationProvider.class);
        assertNotNull(ldapProvider);
    }

    @Test
    public void testBindAsManagerUsingUsernameAndPassword() {
        load("ldap.username:CN=foo,OU=ServiceAccounts", "ldap.password:bar",
                "ldap.provider.user-search-base:OU=NAV,OU=BusinessUnits",
                "ldap.provider.group-search-base:OU=NAV,OU=BusinessUnits");
        AbstractLdapAuthenticationProvider ldapProvider = context.getBean(AbstractLdapAuthenticationProvider.class);
        assertNotNull(ldapProvider);
    }

    @Test
    public void testBindAsManagerUsingServiceUser() {
        load("serviceuser.username:foo", "serviceuser.password:bar",
                "ldap.provider.serviceuser-dn-pattern:CN={0},OU=ServiceAccounts",
                "ldap.provider.user-search-base:OU=NAV,OU=BusinessUnits",
                "ldap.provider.group-search-base:OU=NAV,OU=BusinessUnits");

        AbstractLdapAuthenticationProvider ldapProvider = context.getBean(AbstractLdapAuthenticationProvider.class);
        assertNotNull(ldapProvider);
    }

    private void load(String... properties) {
        TestPropertyValues.of(properties).applyTo(context);

        context.register(LdapProviderAutoConfiguration.class,
                LdapAutoConfiguration.class,
                ServiceUserProperties.class,
                NAVLdapAutoConfiguration.class,
                PropertyPlaceholderAutoConfiguration.class);

        context.refresh();
    }
}
