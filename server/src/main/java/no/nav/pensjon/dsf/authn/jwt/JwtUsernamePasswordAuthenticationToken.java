package no.nav.pensjon.dsf.authn.jwt;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class JwtUsernamePasswordAuthenticationToken extends UsernamePasswordAuthenticationToken {
    public JwtUsernamePasswordAuthenticationToken(Object principal, Object credentials) {
        super(principal, credentials);
    }
}
