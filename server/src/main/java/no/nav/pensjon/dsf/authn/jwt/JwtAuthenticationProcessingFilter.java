package no.nav.pensjon.dsf.authn.jwt;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.slf4j.MDC;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationProcessingFilter extends AbstractAuthenticationProcessingFilter {

    private final Counter loginJwtAttemptCounter;
    private final Counter loginJwtFailedCounter;
    private final Counter loginJwtMalformedInputCounter;
    private final Counter loginJwtSuccessCounter;

    public JwtAuthenticationProcessingFilter(RequestMatcher requiresAuthenticationRequestMatcher, MeterRegistry meterRegistry) {
        super(requiresAuthenticationRequestMatcher);
        this.loginJwtAttemptCounter = meterRegistry.counter("counter.login_jwt.attempt");
        this.loginJwtFailedCounter = meterRegistry.counter("counter.login_jwt.failed");
        this.loginJwtMalformedInputCounter = meterRegistry.counter("counter.login_jwt.malformed_input");
        this.loginJwtSuccessCounter = meterRegistry.counter("counter.login_jwt.success");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        loginJwtAttemptCounter.increment();
        String authHeader = getAuthHeader(request);

        if (!authHeader.startsWith("Bearer ")) {
            loginJwtMalformedInputCounter.increment();
            throw new BadCredentialsException("Missing Bearer");
        }

        String token = authHeader.replace("Bearer ", "");
        return getAuthenticationManager().authenticate(new JwtUsernamePasswordAuthenticationToken(null, token));
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult)
            throws IOException, ServletException {
        loginJwtSuccessCounter.increment();
        SecurityContextHolder.getContext().setAuthentication(authResult);
        /* continue with the request processing */
        try {
            UserDetails userDetails = (UserDetails) authResult.getPrincipal();
            MDC.put("saksbehandler", userDetails.getUsername());
            chain.doFilter(request, response);
        } finally {
            MDC.clear();
        }
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed)
            throws IOException, ServletException {
        loginJwtFailedCounter.increment();
        super.unsuccessfulAuthentication(request, response, failed);
    }

    private String getAuthHeader(HttpServletRequest request) {
        String header = request.getHeader("Authorization");

        if (header == null) {
            loginJwtMalformedInputCounter.increment();
            throw new BadCredentialsException("Missing Authorization");
        }

        return header;
    }
}
