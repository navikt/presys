package no.nav.pensjon.dsf.config.auth.ldap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.ldap.authentication.ad.ActiveDirectoryLdapAuthenticationProvider;
import org.springframework.security.ldap.userdetails.UserDetailsContextMapper;

@Configuration
public class ActiveDirectoryLdapAuthenticationProviderBean {

    @Autowired
    private UserDetailsContextMapper detailsMapper;

    @Bean
    public ActiveDirectoryLdapAuthenticationProvider bean(
            @Value("${ldap.domain}") String ldapDomain,
            @Value("${ldap.url}") String ldapUrl,
            @Value("${ldap.basedn}") String ldapBase
    ) {
        ActiveDirectoryLdapAuthenticationProvider provider = new ActiveDirectoryLdapAuthenticationProvider(
                ldapDomain, ldapUrl, ldapBase
        );

        provider.setUserDetailsContextMapper(detailsMapper);
        provider.setUseAuthenticationRequestCredentials(true);
        provider.setConvertSubErrorCodesToExceptions(true);

        return provider;
    }
}
