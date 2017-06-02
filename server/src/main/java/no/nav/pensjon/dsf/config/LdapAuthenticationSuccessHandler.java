package no.nav.pensjon.dsf.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.ldap.userdetails.LdapUserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by s150563 on 02.06.2017.
 */
public class LdapAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private byte[] secret;

    public LdapAuthenticationSuccessHandler(String jwtSecret) {
        secret = jwtSecret.getBytes();
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authResult) throws IOException, ServletException {
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken)authResult;

        LdapUserDetails details = (LdapUserDetails)authResult.getPrincipal();

        LocalDateTime dateTime = LocalDateTime.now();

        Claims claims = Jwts.claims();
        claims.setSubject(details.getUsername());
        claims.setIssuer("presys");
        claims.setIssuedAt(Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant()));
        claims.setExpiration(Date.from(dateTime.plusDays(7).atZone(ZoneId.systemDefault()).toInstant()));

        claims.put("name", details.getDn());
        claims.put("enabled", details.isEnabled());
        claims.put("accountNonExpired", details.isAccountNonExpired());
        claims.put("credentialsNonExpired", details.isCredentialsNonExpired());
        claims.put("accountNonLocked", details.isAccountNonLocked());
        claims.put("scopes", token.getAuthorities().stream().map(a -> a.toString()).collect(Collectors.toList()));

        String rawToken = Jwts.builder()
            .setClaims(claims)
            .signWith(SignatureAlgorithm.HS512, secret)
            .compact();

        response.setStatus(HttpStatus.OK.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);

        Map<String, String> result = new HashMap<>();
        result.put("token", rawToken);

        new ObjectMapper().writeValue(response.getWriter(), result);
    }
}
