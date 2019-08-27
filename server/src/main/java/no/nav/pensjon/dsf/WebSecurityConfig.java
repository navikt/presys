package no.nav.pensjon.dsf;

import io.micrometer.core.instrument.MeterRegistry;
import no.nav.pensjon.dsf.authz.abac.AbacWebSecurityExpressionHandler;
import no.nav.pensjon.dsf.authn.jwt.JwtAuthenticationProcessingFilter;
import no.nav.pensjon.dsf.authn.jwt.JwtAuthenticationProvider;
import no.nav.pensjon.dsf.authn.ldap.LdapAuthenticationProcessingFilter;
import no.nav.pensjon.dsf.authn.ldap.LdapAuthenticationSuccessHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.ldap.authentication.AbstractLdapAuthenticationProvider;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final AbstractLdapAuthenticationProvider ldapProvider;
    private final JwtAuthenticationProvider jwtProvider;
    private final LdapAuthenticationSuccessHandler ldapSuccessHandler;
    private final MeterRegistry meterRegistry;
    private final AbacWebSecurityExpressionHandler expressionHandler;

    public WebSecurityConfig(AbstractLdapAuthenticationProvider ldapProvider,
                             JwtAuthenticationProvider jwtProvider,
                             LdapAuthenticationSuccessHandler ldapSuccessHandler,
                             AbacWebSecurityExpressionHandler expressionHandler,
                             MeterRegistry meterRegistry) {
        this.ldapProvider = ldapProvider;
        this.jwtProvider = jwtProvider;
        this.ldapSuccessHandler = ldapSuccessHandler;
        this.expressionHandler = expressionHandler;
        this.meterRegistry = meterRegistry;
    }

    private LdapAuthenticationProcessingFilter ldapAuthenticationProcessingFilter() throws Exception {
        LdapAuthenticationProcessingFilter filter = new LdapAuthenticationProcessingFilter(
                new AntPathRequestMatcher("/api/login", "POST"),
                meterRegistry);
        filter.setAuthenticationManager(authenticationManager());
        filter.setAuthenticationSuccessHandler(ldapSuccessHandler);
        return filter;
    }

    private JwtAuthenticationProcessingFilter jwtAuthenticationProcessingFilter() throws Exception {
        JwtAuthenticationProcessingFilter filter = new JwtAuthenticationProcessingFilter(
                new AntPathRequestMatcher("/api/**"),
                meterRegistry);
        filter.setAuthenticationManager(authenticationManager());
        return filter;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .expressionHandler(expressionHandler)
                .antMatchers("/api/**")
                .authenticated()
                .anyRequest()
                .permitAll()
                .and()
                .logout()
                .disable()
                .addFilterBefore(ldapAuthenticationProcessingFilter(), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(jwtAuthenticationProcessingFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(ldapProvider);
        auth.authenticationProvider(jwtProvider);
    }
}
