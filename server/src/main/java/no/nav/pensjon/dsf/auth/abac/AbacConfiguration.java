package no.nav.pensjon.dsf.auth.abac;

import no.nav.freg.abac.core.service.AbacService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class AbacConfiguration {

    @Bean
    public AbacEvaluator abacEvaluator(AbacService abacService) {
        return new AbacEvaluator(abacService);
    }

    @Bean
    public AbacSecurityExpressionHandler abacSecurityExpressionHandler(AbacEvaluator abacEvaluator) {
        return new AbacSecurityExpressionHandler(abacEvaluator);
    }
}
