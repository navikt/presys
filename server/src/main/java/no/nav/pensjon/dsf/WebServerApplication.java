package no.nav.pensjon.dsf;

import io.micrometer.core.instrument.Metrics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.*;
import org.springframework.util.StopWatch;

import java.lang.management.ManagementFactory;

@SpringBootApplication
public class WebServerApplication {

    private static final Logger LOG = LoggerFactory.getLogger(WebServerApplication.class);
    private static final StopWatch STARTUP_TIMER = new StopWatch();

    public static void main(String[] args) {
        STARTUP_TIMER.start();

        new SpringApplicationBuilder(WebServerApplication.class)
                .initializers(ctx -> {
                    Map<String, Object> props = new HashMap<>();

                    props.putAll(loadEnvFile("/var/run/secrets/nais.io/vault/abac.env"));
                    props.putAll(loadEnvFile("/var/run/secrets/nais.io/vault/credential.env"));
                    props.putAll(loadEnvFile("/var/run/secrets/nais.io/vault/database.env"));
                    props.putAll(loadEnvFile("/var/run/secrets/nais.io/vault/jwt.env"));
                    props.putAll(loadEnvFile("/var/run/secrets/nais.io/vault/ldap.env"));

                    ctx.getEnvironment()
                            .getPropertySources()
                            .addFirst(new MapPropertySource("vault-env", props));
                })
                .run(args);

                STARTUP_TIMER.stop();
        context.publishEvent(new StartupEvent(STARTUP_TIMER.getTotalTimeSeconds()));
    }

    @Bean
    ApplicationListener applicationListener() {
        return new ApplicationListener();
    }

    private static class ApplicationListener {

        @EventListener
        public void handleStartup(StartupEvent event) {
            LOG.info("Startup event received");
            double jvmStartupTime = ManagementFactory.getRuntimeMXBean().getUptime() / 1000.0;
            Metrics.gauge("startup.time.jvm", jvmStartupTime);
            Metrics.gauge("startup.time.app", event.getTotalTime());
        }

        @EventListener
        public void handleContextRefreshed(ContextRefreshedEvent event) {
            LOG.info("Context refreshed event fired: {}", event);
        }

        @EventListener
        public void handleContextStarted(ContextStartedEvent event) {
            LOG.info("Context started event fired: {}", event);
        }

        @EventListener
        public void handleContextStopped(ContextStoppedEvent event) {
            LOG.info("Context stopped event fired: {}", event);
        }

        @EventListener
        public void handleContextClosed(ContextClosedEvent event) {
            LOG.info("Context closed event fired: {}", event);
        }
    }

    private static class StartupEvent {

        private final double totalTime;

        StartupEvent(double totalTime) {
            this.totalTime = totalTime;
        }

        double getTotalTime() {
            return totalTime;
        }
    }

    private static Map<String, Object> loadEnvFile(String path) {
        try {
            Map<String, Object> result = new HashMap<>();

            for (String line : Files.readAllLines(Path.of(path))) {
                line = line.trim();

                // hopp over tomme linjer og kommentarer
                if (line.isEmpty() || line.startsWith("#")) {
                    continue;
                }

                int idx = line.indexOf('=');
                if (idx < 0) {
                    continue;
                }

                String key = line.substring(0, idx).trim();
                String value = line.substring(idx + 1).trim();

                // fjern evt. quotes
                value = value.replaceAll("^['\"]|['\"]$", "");

                result.put(key, value);
            }

            return result;
        } catch (IOException e) {
            throw new IllegalStateException("Failed to read env file: " + path, e);
        }
    }
}
