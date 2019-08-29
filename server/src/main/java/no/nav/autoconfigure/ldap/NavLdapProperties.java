package no.nav.autoconfigure.ldap;

import no.nav.autoconfigure.serviceuser.ServiceUserProperties;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.ldap.LdapProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.ldap.support.LdapEncoder;

import java.text.MessageFormat;

import static org.springframework.ldap.support.LdapUtils.newLdapName;
import static org.springframework.ldap.support.LdapUtils.prepend;
import static org.springframework.util.StringUtils.hasText;
import static org.springframework.util.StringUtils.isEmpty;

/**
 * Configures LDAP properties.
 * URL, base DN, username and password are optional as they can be set via
 * Spring's LdapProperties (spring.ldap) instead. However, we will update LdapProperties
 * if the properties are provided in NavLdapProperties so that the ContextSource bean will still work nicely.
 * <p>
 * Username and password can also be set via a service user:
 * serviceuser.username = foo
 * serviceuser.password = bar
 * <p>
 * Remember to set the correct DN for the service user ({0} is replaced with serviceuser.username):
 * ldap.serviceuser-dn-pattern=CN={0},OU=ServiceAccounts
 */
@ConfigurationProperties(prefix = "ldap")
public class NavLdapProperties implements InitializingBean {

    private final LdapProperties properties;
    private final Environment environment;
    private final LdapProviderProperties providerProperties;
    private final ServiceUserProperties serviceUserProperties;

    public NavLdapProperties(LdapProperties properties,
                             Environment environment,
                             LdapProviderProperties providerProperties,
                             ServiceUserProperties serviceUserProperties) {
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

    public void afterPropertiesSet() {
        if (hasText(getUsername()) && hasText(getPassword())) {
            return;
        }

        String dnPattern = providerProperties.getServiceuserDnPattern();
        String username = serviceUserProperties.getUsername();

        if (hasText(dnPattern)) {
            setUsername(getDistinguishedName(dnPattern, getBasedn(), LdapEncoder.nameEncode(username)));
        } else {
            setUsername(username);
        }

        setPassword(serviceUserProperties.getPassword());
    }

    private static String getDistinguishedName(String pattern, String base, String... args) {
        MessageFormat dnPattern = new MessageFormat(pattern);
        String dn = dnPattern.format(args);
        return isEmpty(base) ? dn : prependName(base, dn);
    }

    private static String prependName(String base, String dn) {
        return prepend(newLdapName(dn), newLdapName(base)).toString();
    }
}
