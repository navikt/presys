package no.nav.abac.spring.config;

import java.util.ArrayList;
import java.util.List;

import no.nav.abac.core.consumer.AbacConsumer;
import no.nav.abac.core.service.advice.AdviceStrategy;
import no.nav.abac.core.service.obligation.ObligationStrategy;
import no.nav.abac.core.service.AbacService;
import no.nav.abac.core.service.AbacServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ AbacAnnotationConfig.class })
public class AbacConfig {

    @Autowired(required = false)
    private List<ObligationStrategy> obligationStrategies = new ArrayList<>();

    @Autowired(required = false)
    private List<AdviceStrategy> adviceStrategies = new ArrayList<>();

    @Bean
    AbacService abacService(AbacConsumer consumer) {
        return new AbacServiceImpl(obligationStrategies, adviceStrategies, consumer);
    }
}
