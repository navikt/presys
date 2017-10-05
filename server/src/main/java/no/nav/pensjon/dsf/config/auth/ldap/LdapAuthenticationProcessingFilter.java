package no.nav.pensjon.dsf.config.auth.ldap;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import no.nav.metrics.Event;
import no.nav.metrics.MetricsFactory;
import org.springframework.ldap.NamingException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
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

    Event eventAttempt = createLoginEvent("attempt");
    Event eventSuccess = createLoginEvent("success");
    Event eventFailure = createLoginEvent("failure");

    public LdapAuthenticationProcessingFilter(RequestMatcher requiresAuthenticationRequestMatcher) {
        super(requiresAuthenticationRequestMatcher);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
            throws AuthenticationException, IOException {

        eventAttempt.report();
        try {
            LoginRequest loginRequest = new ObjectMapper()
                    .readValue(req.getInputStream(), LoginRequest.class);

            return getAuthenticationManager().authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPassword()
                    )
            );
        } catch (JsonMappingException e) {
            throw new BadCredentialsException("Malformed JSON", e);
        } catch (NamingException e) {
            throw new InternalAuthenticationServiceException("Error while contacting LDAP server", e);
        }
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

    private Event createLoginEvent(String type) {
        Event event = MetricsFactory.createEvent("Presys.loginevent");
        event.addTagToReport("loginEventTypeTag", type);
        return event;
    }
}
