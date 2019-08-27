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
        ConfigurableApplicationContext context = SpringApplication.run(WebServerApplication.class, args);
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
}
