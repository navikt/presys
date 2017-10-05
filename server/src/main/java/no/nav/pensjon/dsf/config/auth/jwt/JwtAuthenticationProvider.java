package no.nav.pensjon.dsf.config.auth.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import no.nav.pensjon.dsf.config.auth.JwtService;
import no.nav.pensjon.dsf.config.auth.PresysUser;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    private JwtService jwtService;

    public JwtAuthenticationProvider(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return JwtUsernamePasswordAuthenticationToken.class.equals(authentication);
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

            return PresysUser.fromClaims(rawToken, claims);
        } catch (ExpiredJwtException e) {
            throw new CredentialsExpiredException("JWT has expired", e);
        } catch (IllegalArgumentException | SignatureException | MalformedJwtException e) {
            throw new BadCredentialsException(e.getMessage(), e);
        }
    }
}
