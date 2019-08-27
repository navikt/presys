package no.nav.pensjon.dsf.authn.ldap;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
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

    private final Counter loginAttemptCounter;
    private final Counter loginErrorCounter;
    private final Counter loginFailedCounter;
    private final Counter loginMalformedInputCounter;
    private final Counter loginSuccessCounter;

    public LdapAuthenticationProcessingFilter(RequestMatcher requiresAuthenticationRequestMatcher, MeterRegistry meterRegistry) {
        super(requiresAuthenticationRequestMatcher);
        this.loginAttemptCounter = meterRegistry.counter("counter.login.attempt");
        this.loginErrorCounter = meterRegistry.counter("counter.login.error");
        this.loginFailedCounter = meterRegistry.counter("counter.login.failed");
        this.loginMalformedInputCounter = meterRegistry.counter("counter.login.malformed_input");
        this.loginSuccessCounter = meterRegistry.counter("counter.login.success");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException, IOException {
        loginAttemptCounter.increment();

        try {
            LoginRequest loginRequest = new ObjectMapper()
                    .readValue(request.getInputStream(), LoginRequest.class);

            return getAuthenticationManager().authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPassword()));
        } catch (JsonMappingException e) {
            loginMalformedInputCounter.increment();
            throw new BadCredentialsException("Malformed JSON", e);
        } catch (NamingException e) {
            loginErrorCounter.increment();
            throw new InternalAuthenticationServiceException("Error while contacting LDAP server", e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        loginSuccessCounter.increment();
        SecurityContextHolder.getContext().setAuthentication(authResult);
        getSuccessHandler().onAuthenticationSuccess(request, response, authResult);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        loginFailedCounter.increment();
        super.unsuccessfulAuthentication(request, response, failed);
    }
}
