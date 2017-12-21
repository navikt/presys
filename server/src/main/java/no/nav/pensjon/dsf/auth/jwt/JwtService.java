package no.nav.pensjon.dsf.auth.jwt;

import io.jsonwebtoken.*;
import no.nav.pensjon.dsf.auth.PresysUser;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class JwtService {

    private final byte[] secret;

    private static final int EXPIRATION_DAYS = 7;

    private final String issuer;

    public JwtService(byte[] secret, String issuer) {
        this.secret = secret;
        this.issuer = issuer;
    }

    public String issueToken(PresysUser user) {
        LocalDateTime dateTime = LocalDateTime.now();
        Date now  = Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
        Date expiration = Date.from(dateTime.plusDays(EXPIRATION_DAYS).atZone(ZoneId.systemDefault()).toInstant());

        Claims claims = user.getClaims();

        claims.setIssuer(issuer);
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
                .requireIssuer(issuer)
                .setSigningKey(secret)
                .parseClaimsJws(rawToken)
                .getBody();
    }
}
