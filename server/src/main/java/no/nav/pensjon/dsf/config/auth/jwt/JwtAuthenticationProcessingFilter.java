package no.nav.pensjon.dsf.config.auth.jwt;

import org.slf4j.MDC;
import org.springframework.boot.actuate.metrics.CounterService;
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

    private final CounterService counterService;

    public JwtAuthenticationProcessingFilter(RequestMatcher requiresAuthenticationRequestMatcher, CounterService counterService) {
        super(requiresAuthenticationRequestMatcher);
        this.counterService = counterService;

        counterService.reset("counter.login_jwt.attempt");
        counterService.reset("counter.login_jwt.malformed_input");
        counterService.reset("counter.login_jwt.success");
        counterService.reset("counter.login_jwt.failed");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
            throws AuthenticationException, IOException, ServletException {
        counterService.increment("counter.login_jwt.attempt");

        String rawToken = req.getHeader("Authorization");

        if (rawToken == null) {
            counterService.increment("counter.login_jwt.malformed_input");
            throw new BadCredentialsException("Missing Authorization");
        }

        if (!rawToken.startsWith("Bearer ")) {
            counterService.increment("counter.login_jwt.malformed_input");
            throw new BadCredentialsException("Missing Bearer");
        }

        rawToken = rawToken.replace("Bearer ", "");
        return getAuthenticationManager().authenticate(new JwtUsernamePasswordAuthenticationToken(null, rawToken));
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        counterService.increment("counter.login_jwt.success");
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
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        counterService.increment("counter.login_jwt.failed");
        super.unsuccessfulAuthentication(request, response, failed);
    }
}