package no.nav.pensjon.dsf.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.ldap.authentication.ad.ActiveDirectoryLdapAuthenticationProvider;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${ldap.url}")
    private String ldapUrl;

    @Value("${ldap.basedn}")
    private String ldapBase;

    @Value("${ldap.domain}")
    private String ldapDomain;

    @Value("${jwt.password}")
    private String jwtSecret;

    private AuthenticationProvider ldapAuthenticationProvider() {
        ActiveDirectoryLdapAuthenticationProvider provider = new ActiveDirectoryLdapAuthenticationProvider(
                ldapDomain, ldapUrl, ldapBase
        );

        provider.setUserDetailsContextMapper(new NAVLdapUserDetailsMapper());
        provider.setUseAuthenticationRequestCredentials(true);
        provider.setConvertSubErrorCodesToExceptions(true);
        return provider;
    }

    private LdapAuthenticationProcessingFilter ldapAuthenticationProcessingFilter() throws Exception {
        LdapAuthenticationProcessingFilter filter = new LdapAuthenticationProcessingFilter(
                new AntPathRequestMatcher("/api/login")
        );

        filter.setAuthenticationManager(authenticationManager());
        filter.setAuthenticationSuccessHandler(new LdapAuthenticationSuccessHandler(jwtSecret));

        return filter;
    }

    private AuthenticationProvider jwtAuthenticationProvider() {
        return new JwtAuthenticationProvider(jwtSecret);
    }

    private JwtAuthenticationProcessingFilter jwtAuthenticationProcessingFilter() throws Exception {
        JwtAuthenticationProcessingFilter filter = new JwtAuthenticationProcessingFilter(
                new AntPathRequestMatcher("/api/**")
        );

        filter.setAuthenticationManager(authenticationManager());

        return filter;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
                    .antMatchers(HttpMethod.GET, "/", "/public/**").permitAll()
                    .anyRequest().authenticated().and()
                .addFilterBefore(ldapAuthenticationProcessingFilter(), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(jwtAuthenticationProcessingFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(ldapAuthenticationProvider());
        auth.authenticationProvider(jwtAuthenticationProvider());
    }
}
