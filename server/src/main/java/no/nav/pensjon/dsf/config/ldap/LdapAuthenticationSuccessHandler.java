package no.nav.pensjon.dsf.config.ldap;

import com.fasterxml.jackson.databind.ObjectMapper;
import no.nav.pensjon.dsf.config.JwtService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by s150563 on 02.06.2017.
 */
public class LdapAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private JwtService jwtService;

    public LdapAuthenticationSuccessHandler(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authResult) throws IOException, ServletException {
        String rawToken = jwtService.issueToken((UsernamePasswordAuthenticationToken)authResult);

        response.setStatus(HttpStatus.OK.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);

        Map<String, String> result = new HashMap<>();
        result.put("token", rawToken);

        new ObjectMapper().writeValue(response.getWriter(), result);
    }
}
