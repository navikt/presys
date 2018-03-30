package no.nav.abac.spring.config;

import no.nav.abac.spring.consumer.AbacRequestMapper;
import no.nav.abac.spring.consumer.AbacRestTemplateConsumer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.client.RestTemplate;

import no.nav.abac.spring.consumer.AbacResponseMapper;

@Configuration
public class AbacRestTemplateConfig {

    @Value("${abac.url}")
    private String url;

    @Value("${abac.username}")
    private String username;

    @Value("${abac.password}")
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
}
