package no.nav.pensjon.dsf.auth.abac;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

@Configuration
@Profile("!test")

@EnableGlobalMethodSecurity(prePostEnabled=true)
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {

    @Bean
    public PresysPermissionEvaluator presysPermissionEvaluator() {
        return new PresysPermissionEvaluator();
    }

    @Bean
    public ABACEvaluator abacEvaluator() {
        return new ABACEvaluator();
    }
}
