package no.nav.pensjon.dsf.config;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.ldap.userdetails.LdapUserDetails;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.stream.Collectors;

/**
 * Created by s150563 on 02.06.2017.
 */
@Service
public class JwtService {

    private final byte[] secret;

    public JwtService(@Value("${jwt.password}") byte[] secret) {
        this.secret = secret;
    }

    public String issueToken(UsernamePasswordAuthenticationToken token) {
        LdapUserDetails details = (LdapUserDetails)token.getPrincipal();

        LocalDateTime dateTime = LocalDateTime.now();

        Claims claims = Jwts.claims();
        claims.setSubject(details.getUsername());
        claims.setIssuer("presys");
        claims.setNotBefore(Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant()));
        claims.setIssuedAt(Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant()));
        claims.setExpiration(Date.from(dateTime.plusDays(7).atZone(ZoneId.systemDefault()).toInstant()));

        claims.put("name", details.getDn());
        claims.put("enabled", details.isEnabled());
        claims.put("accountNonExpired", details.isAccountNonExpired());
        claims.put("credentialsNonExpired", details.isCredentialsNonExpired());
        claims.put("accountNonLocked", details.isAccountNonLocked());
        claims.put("scopes", token.getAuthorities().stream()
                .map(GrantedAuthority::toString)
                .collect(Collectors.toList()));

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public Claims parseToken(String rawToken) throws ExpiredJwtException, MalformedJwtException, SignatureException {
        return Jwts.parser()
                .requireIssuer("presys")
                .setSigningKey(secret)
                .parseClaimsJws(rawToken)
                .getBody();
    }
}
