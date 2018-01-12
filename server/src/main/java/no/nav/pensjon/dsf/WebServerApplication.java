package no.nav.pensjon.dsf;

import io.prometheus.client.Collector;
import io.prometheus.client.GaugeMetricFamily;
import io.prometheus.client.hotspot.DefaultExports;
import io.prometheus.client.spring.boot.EnablePrometheusEndpoint;
import io.prometheus.client.spring.boot.EnableSpringBootMetricsCollector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.*;
import org.springframework.util.StopWatch;

import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnablePrometheusEndpoint
@EnableSpringBootMetricsCollector
public class WebServerApplication {

    private static final Logger LOG = LoggerFactory.getLogger(WebServerApplication.class);

    private static final StopWatch startupStopWatch = new StopWatch();

    public static void main(String [] args) {
        startupStopWatch.start();

        ConfigurableApplicationContext context = SpringApplication.run(WebServerApplication.class, args);
        startupStopWatch.stop();

        context.publishEvent(new StartupEvent(startupStopWatch.getTotalTimeSeconds()));
    }

    @Bean
    ApplicationListener applicationListener() {
        return new ApplicationListener();
    }

    private static class ApplicationListener {
        @EventListener
        public void registerMetricExports(StartupEvent event) {
            LOG.info("Registering metric exporters");

            DefaultExports.initialize();

            double jvmStartupTime = ManagementFactory.getRuntimeMXBean().getUptime() / 1000.0;
            new StartupInfoExports(jvmStartupTime, event.getTotalTime()).register();
        }

        @EventListener
        public void handleContextRefreshed (ContextRefreshedEvent event) {
            LOG.info("Context refreshed event fired: {}", event);
        }

        @EventListener
        public void handleContextStarted (ContextStartedEvent event) {
            LOG.info("Context started event fired: {}", event);
        }

        @EventListener
        public void handleContextStopped (ContextStoppedEvent event) {
            LOG.info("Context stopped event fired: {}", event);
        }

        @EventListener
        public void handleContextClosed (ContextClosedEvent event) {
            LOG.info("Context  closed event fired: {}", event);
        }
    }

    private static class StartupEvent {
        private final double totalTime;

        public StartupEvent(double totalTime) {
            this.totalTime = totalTime;
        }

        public double getTotalTime() {
            return totalTime;
        }
    }

    private static class StartupInfoExports extends Collector {
        private final double jvmStartupTime;
        private final double appStartupTime;

        private StartupInfoExports(double jvmStartupTime, double appStartupTime) {
            this.jvmStartupTime = jvmStartupTime;
            this.appStartupTime = appStartupTime;
        }

        public List<MetricFamilySamples> collect() {
            List<MetricFamilySamples> mfs = new ArrayList<>();

            GaugeMetricFamily startupInfo = new GaugeMetricFamily("startup_time", "How long time startup took", Arrays.asList("type"));
            startupInfo.addMetric(Arrays.asList("jvm"), jvmStartupTime);
            startupInfo.addMetric(Arrays.asList("app"), appStartupTime);

            mfs.add(startupInfo);

            return mfs;
        }
    }
}
