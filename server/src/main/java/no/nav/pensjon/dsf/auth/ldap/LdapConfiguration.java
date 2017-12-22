package no.nav.pensjon.dsf.auth.ldap;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.ldap.authentication.AbstractLdapAuthenticationProvider;
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
    public UserDetailsContextMapper userDetailsContextMapper() {
        return new NAVLdapUserDetailsMapper();
    }

    @Bean
    @ConditionalOnMissingBean
    public AbstractLdapAuthenticationProvider activeDirectoryAuthenticationProvider(UserDetailsContextMapper contextMapper) {
        ActiveDirectoryLdapAuthenticationProvider provider = new ActiveDirectoryLdapAuthenticationProvider(
                getDomain(), getUrl(), getBasedn()
        );

        provider.setUserDetailsContextMapper(contextMapper);
        provider.setUseAuthenticationRequestCredentials(true);
        provider.setConvertSubErrorCodesToExceptions(true);

        return provider;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getDomain() {
        return domain;
    }

    public String getBasedn() {
        return basedn;
    }

    public Basedn getUser() {
        return user;
    }

    public Basedn getServiceuser() {
        return serviceuser;
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
