package no.nav.pensjon.dsf.config.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import no.nav.pensjon.dsf.config.JwtService;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.stream.Collectors;

public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    private JwtService jwtService;

    public JwtAuthenticationProvider(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        /* when we parse the JWT, we implicitly check that the JWT claims is valid (issue date, not valid before,
            not valid after). so there's nothing left for us to do */
    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        /* because we are using JWT, the username will not be set. Instead we have to use
            the authentication.getCredentials(), which is the JWT, to authenticate the user
         */
        String rawToken = (String)authentication.getCredentials();

        try {
            Claims claims = jwtService.parseToken(rawToken);

            /* update authentication object with claims, so we can fetch it later */
            authentication.setDetails(claims);

            List<String> scopes = claims.get("scopes", List.class);
            List<GrantedAuthority> authorities = scopes.stream()
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toList());

            return new User(
                claims.getSubject(),
                rawToken,
                (boolean)claims.get("enabled"),
                (boolean)claims.get("accountNonExpired"),
                (boolean)claims.get("credentialsNonExpired"),
                (boolean)claims.get("accountNonLocked"),
                authorities
            );
        } catch (ExpiredJwtException | SignatureException | MalformedJwtException e) {
            throw new BadCredentialsException(e.getMessage());
        }
    }
}
