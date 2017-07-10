package no.nav.pensjon.dsf.config.auth.ldap;

import com.fasterxml.jackson.databind.ObjectMapper;
import no.nav.pensjon.presys.metrics.Event;
import no.nav.pensjon.presys.metrics.MetricsFactory;
import no.nav.pensjon.presys.metrics.Timer;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LdapAuthenticationProcessingFilter extends AbstractAuthenticationProcessingFilter {

    Event eventAttempt = MetricsFactory.createEvent("login.attemptAuthentication");
    Event eventSuccess = MetricsFactory.createEvent("login.successfulAuthentication");
    Event eventFailure = MetricsFactory.createEvent("login.unsuccessfulAuthentication");

    public LdapAuthenticationProcessingFilter(RequestMatcher requiresAuthenticationRequestMatcher) {
        super(requiresAuthenticationRequestMatcher);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
            throws AuthenticationException, IOException, ServletException {

        eventAttempt.report();

        LoginRequest loginRequest = new ObjectMapper()
                .readValue(req.getInputStream(), LoginRequest.class);

        return getAuthenticationManager().authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        eventSuccess.report();
        SecurityContextHolder.getContext().setAuthentication(authResult);
        getSuccessHandler().onAuthenticationSuccess(request, response, authResult);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        eventFailure.report();
        super.unsuccessfulAuthentication(request, response, failed);
    }
}
