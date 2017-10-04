package no.nav.pensjon.dsf.config.auth.jwt;

import org.slf4j.MDC;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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

    public JwtAuthenticationProcessingFilter(RequestMatcher requiresAuthenticationRequestMatcher) {
        super(requiresAuthenticationRequestMatcher);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
            throws AuthenticationException, IOException, ServletException {
        String rawToken = req.getHeader("Authorization");

        if (rawToken == null) {
            throw new BadCredentialsException("Missing Authorization");
        }

        if (!rawToken.startsWith("Bearer ")) {
            throw new BadCredentialsException("Missing Bearer");
        }

        rawToken = rawToken.replace("Bearer ", "");
        return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(null, rawToken));
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
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
}