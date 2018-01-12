package no.nav.autoconfigure.ldap;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(NAVLdapProperties.class)
public class NAVLdapAutoConfiguration {
}
