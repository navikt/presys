package no.nav.pensjon.dsf;

import io.micrometer.core.instrument.Metrics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.*;
import org.springframework.core.env.MapPropertySource;
import org.springframework.util.StopWatch;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.HashMap;
import java.nio.file.Paths;
import java.util.List;

@SpringBootApplication
public class WebServerApplication {

    private static final Logger LOG = LoggerFactory.getLogger(WebServerApplication.class);
    private static final StopWatch STARTUP_TIMER = new StopWatch();

    public static void main(String[] args) {
        STARTUP_TIMER.start();

        ConfigurableApplicationContext context =
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

    private static Map<String, Object> loadEnvFile(String filePath) {
        Map<String, Object> envMap = new HashMap<>();
        Path path = Paths.get(filePath);

        try {
            List<String> lines = Files.readAllLines(path);
            for (String line : lines) {
                line = line.trim();
                // hopp over tomme linjer og kommentarer
                if (line.isEmpty() || line.startsWith("#")) continue;

                // del på første '='
                int idx = line.indexOf('=');
                if (idx == -1) {
                    System.err.println("Warning: line in env file has no '=': " + line);
                    continue;
                }

                String key = line.substring(0, idx).trim();
                String value = line.substring(idx + 1).trim();

                // fjern eventuelle " eller ' rundt verdien
                if ((value.startsWith("\"") && value.endsWith("\"")) ||
                        (value.startsWith("'") && value.endsWith("'"))) {
                    value = value.substring(1, value.length() - 1);
                }

                envMap.put(key, value);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read env file: " + filePath, e);
        }

        return envMap;
    }
}
