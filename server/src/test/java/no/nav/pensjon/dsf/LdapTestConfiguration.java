package no.nav.pensjon.dsf;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.ContextSource;
import org.springframework.ldap.core.support.BaseLdapPathContextSource;
import org.springframework.security.ldap.authentication.AbstractLdapAuthenticationProvider;
import org.springframework.security.ldap.authentication.BindAuthenticator;
import org.springframework.security.ldap.authentication.LdapAuthenticationProvider;
import org.springframework.security.ldap.userdetails.DefaultLdapAuthoritiesPopulator;
import org.springframework.security.ldap.userdetails.UserDetailsContextMapper;

@Configuration
@ConditionalOnClass(name="com.unboundid.ldap.listener.InMemoryDirectoryServer")
public class LdapTestConfiguration {
    @Bean
    public AbstractLdapAuthenticationProvider ldapAuthenticationProvider(ContextSource contextSource, UserDetailsContextMapper contextMapper) {

        BindAuthenticator authenticator = new BindAuthenticator((BaseLdapPathContextSource) contextSource);
        authenticator.setUserDnPatterns(new String[]{"CN={0},OU=Users,OU=MyOrganization,OU=BusinessUnits,DC=test,DC=local"});

        DefaultLdapAuthoritiesPopulator populator = new DefaultLdapAuthoritiesPopulator(
                contextSource, "OU=AccountGroups,OU=Groups,OU=MyOrganization,OU=BusinessUnits,DC=test,DC=local");

        LdapAuthenticationProvider provider = new LdapAuthenticationProvider(authenticator, populator);

        provider.setHideUserNotFoundExceptions(false);
        provider.setUserDetailsContextMapper(contextMapper);
        provider.setUseAuthenticationRequestCredentials(true);

        return provider;
    }
}
