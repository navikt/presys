package no.nav.pensjon.dsf.config.auth.ldap;

import no.nav.pensjon.dsf.config.auth.PresysUser;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.ldap.userdetails.LdapUserDetailsMapper;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
class NAVLdapUserDetailsMapper extends LdapUserDetailsMapper {

    @Override
    public UserDetails mapUserFromContext(DirContextOperations ctx, String username, Collection<? extends GrantedAuthority> authorities) {
        String email = ctx.getStringAttribute("mail");
        String firstName = ctx.getStringAttribute("givenName");
        String lastName = ctx.getStringAttribute("sn");

        return new PresysUser(
            username,
            "",
            firstName,
            lastName,
            email,
            authorities
        );

    }

}