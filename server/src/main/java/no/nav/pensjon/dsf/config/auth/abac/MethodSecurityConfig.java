package no.nav.pensjon.dsf.config.auth.abac;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

@Configuration
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
