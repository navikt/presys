package no.nav.pensjon.dsf.config.auth.ldap;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.actuate.metrics.CounterService;
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

    private CounterService counterService;

    public LdapAuthenticationProcessingFilter(RequestMatcher requiresAuthenticationRequestMatcher, CounterService counterService) {
        super(requiresAuthenticationRequestMatcher);
        this.counterService = counterService;

        counterService.reset("counter.login.attempt");
        counterService.reset("counter.login.malformed_input");
        counterService.reset("counter.login.error");
        counterService.reset("counter.login.success");
        counterService.reset("counter.login.failed");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
            throws AuthenticationException, IOException {

        counterService.increment("counter.login.attempt");
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
            counterService.increment("counter.login.malformed_input");
            throw new BadCredentialsException("Malformed JSON", e);
        } catch (NamingException e) {
            counterService.increment("counter.login.error");
            throw new InternalAuthenticationServiceException("Error while contacting LDAP server", e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        counterService.increment("counter.login.success");
        SecurityContextHolder.getContext().setAuthentication(authResult);
        getSuccessHandler().onAuthenticationSuccess(request, response, authResult);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        counterService.increment("counter.login.failed");
        super.unsuccessfulAuthentication(request, response, failed);
    }
}
