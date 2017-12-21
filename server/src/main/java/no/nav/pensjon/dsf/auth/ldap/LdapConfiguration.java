package no.nav.pensjon.dsf.auth.ldap;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.ldap.authentication.ad.ActiveDirectoryLdapAuthenticationProvider;
import org.springframework.security.ldap.userdetails.UserDetailsContextMapper;

@Configuration
@ConfigurationProperties(prefix = "ldap")
public class LdapConfiguration {

    private String url;

    private String username;

    private String password;

    private String domain;

    private String basedn;

    private final Basedn user = new Basedn();

    private final Basedn serviceuser = new Basedn();

    @Bean
    public ActiveDirectoryLdapAuthenticationProvider ldapAuthenticationProvider(UserDetailsContextMapper contextMapper) {
        ActiveDirectoryLdapAuthenticationProvider provider = new ActiveDirectoryLdapAuthenticationProvider(
                domain, url, basedn
        );

        provider.setUserDetailsContextMapper(contextMapper);
        provider.setUseAuthenticationRequestCredentials(true);
        provider.setConvertSubErrorCodesToExceptions(true);

        return provider;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void setBasedn(String basedn) {
        this.basedn = basedn;
    }

    public static class Basedn {
        private String basedn;

        public void setBasedn(String basedn) {
            this.basedn = basedn;
        }
    }
}
