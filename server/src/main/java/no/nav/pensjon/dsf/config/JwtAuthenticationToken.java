package no.nav.pensjon.dsf.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * Created by s150563 on 01.06.2017.
 */
public class JwtAuthenticationToken extends AbstractAuthenticationToken {

    private String rawToken;

    private Jws<Claims> token;

    public JwtAuthenticationToken(String token) {
        super(null);
        super.setAuthenticated(false);
        this.rawToken = token;
    }

    public JwtAuthenticationToken(String rawToken, Jws<Claims> token, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.setAuthenticated(true);
        this.rawToken = rawToken;
        this.token = token;
    }

    @Override
    public String getName() {
        return token.getBody().get("name", String.class);
    }

    @Override
    public Object getCredentials() {
        return rawToken;
    }

    @Override
    public Object getPrincipal() {
        Claims claims = token.getBody();

        return new PresysUserDetails(
                claims.getSubject(),
                claims.get("name", String.class),
                (boolean)claims.get("enabled"),
                (boolean)claims.get("accountNonExpired"),
                (boolean)claims.get("credentialsNonExpired"),
                (boolean)claims.get("accountNonLocked"),
                getAuthorities()
        );
    }
}
