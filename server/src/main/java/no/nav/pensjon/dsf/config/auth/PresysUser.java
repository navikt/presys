package no.nav.pensjon.dsf.config.auth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class PresysUser extends User {

    private final String givenName;

    private final String surname;

    private final String email;

    public PresysUser(String username,
                      String password,
                      String givenName,
                      String surname,
                      String email,
                      Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.givenName = givenName;
        this.surname = surname;
        this.email = email;
    }

    public PresysUser(String username,
                      String password,
                      String givenName,
                      String surname,
                      String email,
                      boolean enabled,
                      boolean accountNonExpired,
                      boolean credentialsNonExpired,
                      boolean accountNonLocked,
                      Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.givenName = givenName;
        this.surname = surname;
        this.email = email;
    }

    public static PresysUser fromClaims(String rawToken, Claims claims) {
        List<String> scopes = claims.get("scopes", List.class);
        List<GrantedAuthority> authorities = scopes.stream()
                .map(String::toUpperCase)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        return new PresysUser(
                claims.getSubject(),
                rawToken,
                claims.get("givenName", String.class),
                claims.get("surname", String.class),
                claims.get("email", String.class),
                claims.get("enabled", Boolean.class),
                claims.get("accountNonExpired", Boolean.class),
                claims.get("credentialsNonExpired", Boolean.class),
                claims.get("accountNonLocked", Boolean.class),
                authorities
        );
    }

    @JsonIgnore
    public Claims getClaims() {
        Claims claims = Jwts.claims();

        claims.setSubject(getUsername());

        claims.put("givenName", getGivenName());
        claims.put("surname", getSurname());
        claims.put("name", getName());
        claims.put("email", getEmail());
        claims.put("enabled", isEnabled());
        claims.put("accountNonExpired", isAccountNonExpired());
        claims.put("credentialsNonExpired", isCredentialsNonExpired());
        claims.put("accountNonLocked", isAccountNonLocked());

        claims.put("scopes", getAuthorities().stream()
                .map(GrantedAuthority::toString)
                .collect(Collectors.toList()));

        return claims;
    }

    public String getGivenName() {
        return givenName;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return givenName + " " + surname;
    }

    public String getEmail() {
        return email;
    }
}
