package no.nav.pensjon.dsf;

import io.prometheus.client.spring.boot.EnablePrometheusEndpoint;
import io.prometheus.client.spring.boot.EnableSpringBootMetricsCollector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnablePrometheusEndpoint
@EnableSpringBootMetricsCollector
public class WebServerApplication {

    public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(WebServerApplication.class, args);
	}
}
