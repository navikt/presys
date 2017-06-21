package no.nav.pensjon.dsf.config.auth;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
public class JwtService {

    private final byte[] secret;

    private static final int EXPIRATION_DAYS = 7;

    public JwtService(@Value("${jwt.password}") byte[] secret) {
        this.secret = secret;
    }

    public String issueToken(PresysUser user) {
        LocalDateTime dateTime = LocalDateTime.now();
        Date now  = Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
        Date expiration = Date.from(dateTime.plusDays(EXPIRATION_DAYS).atZone(ZoneId.systemDefault()).toInstant());

        Claims claims = user.getClaims();

        claims.setIssuer("presys");
        claims.setNotBefore(now);
        claims.setIssuedAt(now);
        claims.setExpiration(expiration);

        return issueToken(claims);
    }

    public String issueToken(Claims claims) {
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
