package no.nav.pensjon.dsf.authn.ldap;

import no.nav.pensjon.dsf.authn.PresysUser;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.ldap.userdetails.LdapUserDetailsMapper;

import java.util.Collection;

class NAVLdapUserDetailsMapper extends LdapUserDetailsMapper {

    @Override
    public UserDetails mapUserFromContext(DirContextOperations ctx, String username, Collection<? extends GrantedAuthority> authorities) {
        String email = ctx.getStringAttribute("mail");
        String firstName = ctx.getStringAttribute("givenName");
        String lastName = ctx.getStringAttribute("sn");

        return new PresysUser(
            ctx.getStringAttribute("sAMAccountName"),
            "",
            firstName,
            lastName,
            email,
            authorities
        );

    }

}
