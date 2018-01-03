package no.nav.autoconfigure.ldap;

import no.nav.autoconfigure.serviceuser.ServiceUserProperties;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.support.LdapEncoder;
import org.springframework.ldap.support.LdapUtils;
import org.springframework.util.StringUtils;

import java.text.MessageFormat;

/**
 * Creates a LdapAuthenticationProvider bean compatible with Active Directory
 * and other LDAP compliant directory servers.
 *
 * Filter based searches are depending on a service username and password, and
 * will only be enabled if they are provided.
 */
@Configuration
@EnableConfigurationProperties(NAVLdapProperties.class)
public class NAVLdapAutoConfiguration implements InitializingBean {

    private final LdapProviderProperties providerProperties;
    private final NAVLdapProperties ldapProperties;
    private final ServiceUserProperties serviceUserProperties;

    public NAVLdapAutoConfiguration(LdapProviderProperties providerProperties, NAVLdapProperties ldapProperties, ServiceUserProperties serviceUserProperties) {
        this.providerProperties = providerProperties;
        this.ldapProperties = ldapProperties;
        this.serviceUserProperties = serviceUserProperties;
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
        if ((StringUtils.hasText(ldapProperties.getUsername()) && StringUtils.hasText(ldapProperties.getPassword()))
                || serviceUserProperties.getUsername() == null || serviceUserProperties.getPassword() == null) {
            return;
        }

        ldapProperties.setUsername(getDistinguishedName(providerProperties.getServiceuserDnPattern(),
                ldapProperties.getBasedn(), LdapEncoder.nameEncode(serviceUserProperties.getUsername())));
        ldapProperties.setPassword(serviceUserProperties.getPassword());
    }
}
