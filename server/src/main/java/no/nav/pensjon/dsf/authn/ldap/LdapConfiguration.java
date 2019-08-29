package no.nav.pensjon.dsf.authn.ldap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.ldap.userdetails.UserDetailsContextMapper;

@Configuration
public class LdapConfiguration {

    @Bean
    public UserDetailsContextMapper userDetailsContextMapper() {
        return new NavLdapUserDetailsMapper();
    }
}
