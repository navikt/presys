package no.nav.pensjon.dsf.config.jwt;

import io.jsonwebtoken.*;
import no.nav.pensjon.dsf.config.JwtService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by s150563 on 01.06.2017.
 */
public class JwtAuthenticationProvider implements AuthenticationProvider {

    private JwtService jwtService;

    public JwtAuthenticationProvider(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        JwtAuthenticationToken jwtToken = (JwtAuthenticationToken)authentication;

        String rawToken = (String)jwtToken.getCredentials();

        try {
            Jws<Claims> claims = jwtService.parseToken(rawToken);

            List<String> scopes = claims.getBody().get("scopes", List.class);
            if (scopes == null) {
                scopes = Collections.emptyList();
            }

            List<GrantedAuthority> authorities = scopes.stream()
                    .map(authority -> new SimpleGrantedAuthority(authority))
                    .collect(Collectors.toList());

            return new JwtAuthenticationToken(rawToken, claims, authorities);
        } catch (SignatureException | MalformedJwtException e) {
            throw new BadCredentialsException(e.getMessage());
        }
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return JwtAuthenticationToken.class.equals(aClass);
    }
}
