package no.nav.pensjon.dsf.config.auth.jwt;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class JwtUsernamePasswordAuthenticationToken extends UsernamePasswordAuthenticationToken {
    public JwtUsernamePasswordAuthenticationToken(Object principal, Object credentials) {
        super(principal, credentials);
    }
}
