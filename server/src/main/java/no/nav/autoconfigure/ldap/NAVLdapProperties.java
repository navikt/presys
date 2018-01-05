package no.nav.autoconfigure.ldap;

import no.nav.autoconfigure.serviceuser.ServiceUserProperties;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.ldap.LdapProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.ldap.support.LdapEncoder;
import org.springframework.ldap.support.LdapUtils;
import org.springframework.util.StringUtils;

import java.text.MessageFormat;

/**
 * Configures LDAP properties.
 * URL, basedn, username and password are optional as they can be set via
 * Spring's LdapProperties (spring.ldap) instead. However, we will update LdapProperties
 * if the properties are provided in NAVLdapProperties so that the ContextSource bean will still work nicely.
 *
 * Username and password can also be set via a Service user:
 * serviceuser.username = foo
 * serviceuser.password = bar
 *
 * Remember to set the correct DN for the service user ({0} is replaced with serviceuser.username):
 * ldap.serviceuser-dn-pattern=CN={0},OU=ServiceAccounts
 */
@ConfigurationProperties(prefix = "ldap")
public class NAVLdapProperties implements InitializingBean {

    private final LdapProperties properties;

    private final Environment environment;

    private final LdapProviderProperties providerProperties;
    private final ServiceUserProperties serviceUserProperties;

    public NAVLdapProperties(LdapProperties properties, Environment environment, LdapProviderProperties providerProperties, ServiceUserProperties serviceUserProperties) {
        this.properties = properties;
        this.environment = environment;
        this.providerProperties = providerProperties;
        this.serviceUserProperties = serviceUserProperties;
    }

    public String getUrl() {
        return properties.determineUrls(environment)[0];
    }

    public String getUsername() {
        return properties.getUsername();
    }

    public String getPassword() {
        return properties.getPassword();
    }

    public String getBasedn() {
        return properties.getBase();
    }

    public void setUrl(String url) {
        properties.setUrls(new String[]{url});
    }

    public void setBasedn(String basedn) {
        properties.setBase(basedn);
    }

    public void setUsername(String username) {
        properties.setUsername(username);
    }

    public void setPassword(String password) {
        properties.setPassword(password);
    }

    private String getDistinguishedName(String pattern, String base, String... args) {
        MessageFormat dnPattern = new MessageFormat(pattern);
        String dn = dnPattern.format(args);

        if (base != null && base.length() > 0) {
            return LdapUtils.prepend(
                    LdapUtils.newLdapName(dn),
                    LdapUtils.newLdapName(base)
            ).toString();
        }

        return dn;
    }

    public void afterPropertiesSet() throws Exception {
        if (StringUtils.hasText(getUsername()) && StringUtils.hasText(getPassword())) {
            return;
        }

        if (StringUtils.hasText(providerProperties.getServiceuserDnPattern())) {
            setUsername(getDistinguishedName(providerProperties.getServiceuserDnPattern(),
                    getBasedn(), LdapEncoder.nameEncode(serviceUserProperties.getUsername())));
        } else {
            setUsername(serviceUserProperties.getUsername());
        }

        setPassword(serviceUserProperties.getPassword());
    }
}
