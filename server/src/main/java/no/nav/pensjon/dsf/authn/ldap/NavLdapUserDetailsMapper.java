package no.nav.pensjon.dsf.authn.ldap;

import no.nav.pensjon.dsf.authn.PresysUser;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.ldap.userdetails.LdapUserDetailsMapper;

import java.util.Collection;

class NavLdapUserDetailsMapper extends LdapUserDetailsMapper {

    @Override
    public UserDetails mapUserFromContext(DirContextOperations context,
                                          String username,
                                          Collection<? extends GrantedAuthority> authorities) {
        return new PresysUser(
                context.getStringAttribute("sAMAccountName"),
                "",
                context.getStringAttribute("givenName"),
                context.getStringAttribute("sn"),
                context.getStringAttribute("mail"),
                authorities);
    }
}
