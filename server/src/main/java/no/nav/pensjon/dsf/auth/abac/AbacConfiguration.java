package no.nav.pensjon.dsf.auth.abac;

import no.nav.freg.abac.core.consumer.AbacConsumer;
import no.nav.freg.abac.core.service.AbacService;
import no.nav.freg.abac.core.service.AbacServiceImpl;
import no.nav.freg.abac.spring.consumer.AbacRequestMapper;
import no.nav.freg.abac.spring.consumer.AbacResponseMapper;
import no.nav.freg.abac.spring.consumer.AbacRestTemplateConsumer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Configuration
@ConfigurationProperties(prefix = "abac")
class AbacConfiguration {

    private String url;

    private String username;

    private String password;

    @Bean
    AbacRestTemplateConsumer abacRestTemplateConsumer() {
        return new AbacRestTemplateConsumer(abacRestTemplate(), url, new AbacRequestMapper(), new AbacResponseMapper());
    }

    private RestTemplate abacRestTemplate() {
        RestTemplate template = new RestTemplate();
        template.getInterceptors().add(new BasicAuthorizationInterceptor(username, password));
        return template;
    }

    @Bean
    AbacService abacService(AbacConsumer consumer) {
        return new AbacServiceImpl(Collections.emptyList(), Collections.emptyList(), consumer);
    }

    @Bean
    public AbacEvaluator abacEvaluator(AbacService abacService) {
        return new AbacEvaluator(abacService);
    }

    @Bean
    public AbacSecurityExpressionHandler abacSecurityExpressionHandler(AbacEvaluator abacEvaluator) {
        return new AbacSecurityExpressionHandler(abacEvaluator);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
