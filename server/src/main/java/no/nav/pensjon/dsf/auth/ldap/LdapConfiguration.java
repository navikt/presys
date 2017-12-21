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

/*
    "user.basedn": "ou=NAV,ou=BusinessUnits,dc=preprod,dc=local",
    "serviceuser.basedn": "ou=ServiceAccounts,dc=preprod,dc=local",
    "domain": "PREPROD.LOCAL",
    "basedn": "dc=preprod,dc=local",
    "url": "ldaps://ldapgw.preprod.local",
    "username": "srvSSOLinux"
 */

/*
Environment:
      APP_VERSION:			truststore5
      NAV_TRUSTSTORE_KEYSTOREALIAS:	na
      NAV_TRUSTSTORE_PASSWORD:		<set to the key 'nav_truststore_password' in secret 'presys'>	Optional: false
      NAV_TRUSTSTORE_PATH:		/var/run/secrets/naisd.io/nav_truststore_keystore
      JWT_USERNAME:			dummyuser
      JWT_PASSWORD:			<set to the key 'jwt_password' in secret 'presys'>	Optional: false
      LDAP_USER_BASEDN:			ou=NAV,ou=BusinessUnits,dc=preprod,dc=local
      LDAP_SERVICEUSER_BASEDN:		ou=ServiceAccounts,dc=preprod,dc=local
      LDAP_DOMAIN:			PREPROD.LOCAL
      LDAP_BASEDN:			dc=preprod,dc=local
      LDAP_URL:				ldaps://ldapgw.preprod.local
      LDAP_USERNAME:			srvSSOLinux
      LDAP_PASSWORD:			<set to the key 'ldap_password' in secret 'presys'>	Optional: false
      SPRING_DATASOURCE_URL:		jdbc:oracle:thin:@a01dbfl032.adeo.no:1521/presys_q0
      SPRING_DATASOURCE_USERNAME:	presys
      SPRING_DATASOURCE_PASSWORD:	<set to the key 'presysDB_password' in secret 'presys'>	Optional: false
      ABAC_USERNAME:			srvpresys
      ABAC_PASSWORD:			<set to the key 'srvpresys_password' in secret 'presys'>	Optional: false
      ABAC_PDP_ENDPOINT_DESCRIPTION:	The XACML JSON Endpoint for evaluating attributes against policies
      ABAC_URL:				https://wasapp-q0.adeo.no/asm-pdp/authorize
 */
