package no.nav.autoconfigure.abac;

import no.nav.freg.abac.core.consumer.AbacConsumer;
import no.nav.freg.abac.core.service.AbacService;
import no.nav.freg.abac.core.service.AbacServiceImpl;
import no.nav.freg.abac.spring.consumer.AbacRequestMapper;
import no.nav.freg.abac.spring.consumer.AbacResponseMapper;
import no.nav.freg.abac.spring.consumer.AbacRestTemplateConsumer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Configuration
@EnableConfigurationProperties(AbacProperties.class)
@ConditionalOnClass(AbacRestTemplateConsumer.class)
public class AbacAutoConfiguration {

    private final AbacProperties abacProperties;

    public AbacAutoConfiguration(AbacProperties abacProperties) {
        this.abacProperties = abacProperties;
    }

    @Bean
    @ConditionalOnMissingBean
    public AbacRestTemplateConsumer abacRestTemplateConsumer() {
        return new AbacRestTemplateConsumer(abacRestTemplate(), abacProperties.getUrl(), new AbacRequestMapper(), new AbacResponseMapper());
    }

    private RestTemplate abacRestTemplate() {
        RestTemplate template = new RestTemplate();
        template.getInterceptors().add(new BasicAuthorizationInterceptor(abacProperties.getUsername(), abacProperties.getPassword()));
        return template;
    }

    @Bean
    @ConditionalOnMissingBean
    public AbacService abacService(AbacConsumer consumer) {
        return new AbacServiceImpl(Collections.emptyList(), Collections.emptyList(), consumer);
    }
}
