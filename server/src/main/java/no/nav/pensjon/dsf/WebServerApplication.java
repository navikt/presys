package no.nav.pensjon.dsf;

import io.prometheus.client.Collector;
import io.prometheus.client.GaugeMetricFamily;
import io.prometheus.client.hotspot.DefaultExports;
import io.prometheus.client.spring.boot.EnablePrometheusEndpoint;
import io.prometheus.client.spring.boot.EnableSpringBootMetricsCollector;
import no.nav.pensjon.dsf.config.WebAppInitializer;
import no.nav.pensjon.dsf.config.WebSecurityConfig;
import no.nav.pensjon.dsf.config.auth.AuditEventListener;
import no.nav.pensjon.dsf.config.auth.JwtService;
import no.nav.pensjon.dsf.config.auth.abac.*;
import no.nav.pensjon.dsf.config.auth.jwt.JwtAuthenticationProvider;
import no.nav.pensjon.dsf.config.auth.ldap.ActiveDirectoryLdapAuthenticationProviderBean;
import no.nav.pensjon.dsf.config.auth.ldap.LdapAuthenticationSuccessHandler;
import no.nav.pensjon.dsf.config.auth.ldap.NAVLdapUserDetailsMapper;
import no.nav.pensjon.dsf.web.resources.PresysController;
import no.nav.pensjon.dsf.web.resources.person.PersonEndpoint;
import no.nav.pensjon.dsf.web.resources.person.PersonRepository;
import no.nav.pensjon.dsf.web.resources.person.PersonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.*;
import org.springframework.boot.autoconfigure.context.ConfigurationPropertiesAutoConfiguration;
import org.springframework.boot.autoconfigure.context.PropertyPlaceholderAutoConfiguration;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration;
import org.springframework.boot.autoconfigure.info.ProjectInfoAutoConfiguration;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.boot.autoconfigure.ldap.LdapAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.SecurityFilterAutoConfiguration;
import org.springframework.boot.autoconfigure.web.*;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.event.EventListener;
import org.springframework.util.StopWatch;

import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@Import(value = {
        ConfigurationPropertiesAutoConfiguration.class,
        PropertyPlaceholderAutoConfiguration.class,
        SpringDataWebAutoConfiguration.class,
        ProjectInfoAutoConfiguration.class,
        JacksonAutoConfiguration.class,
        DataSourceAutoConfiguration.class,
        JdbcTemplateAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class,
        LdapAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class,
        SecurityAutoConfiguration.class,
        SecurityFilterAutoConfiguration.class,
        DispatcherServletAutoConfiguration.class,
        EmbeddedServletContainerAutoConfiguration.class,
        ErrorMvcAutoConfiguration.class,
        HttpEncodingAutoConfiguration.class,
        HttpMessageConvertersAutoConfiguration.class,
        MultipartAutoConfiguration.class,
        ServerPropertiesAutoConfiguration.class,
        WebClientAutoConfiguration.class,
        WebMvcAutoConfiguration.class,
        AuditAutoConfiguration.class,
        MetricExportAutoConfiguration.class,
        MetricRepositoryAutoConfiguration.class,
        PublicMetricsAutoConfiguration.class,
        EndpointWebMvcAutoConfiguration.class,
        ManagementServerProperties.class,

        // Application configs and services
        ABACEvaluator.class,
        MethodSecurityConfig.class,
        PEPAbacConfig.class,
        PresysAttributes.class,
        PresysPermissionEvaluator.class,
        JwtAuthenticationProvider.class,
        ActiveDirectoryLdapAuthenticationProviderBean.class,
        LdapAuthenticationSuccessHandler.class,
        NAVLdapUserDetailsMapper.class,
        AuditEventListener.class,
        JwtService.class,
        WebAppInitializer.class,
        WebSecurityConfig.class,
        PersonRepository.class,
        PersonService.class,
        PersonEndpoint.class,
        PresysController.class
})
@EnablePrometheusEndpoint
@EnableSpringBootMetricsCollector
public class WebServerApplication {

    private static final StopWatch startupStopWatch = new StopWatch();

    public static void main(String [] args) {
        startupStopWatch.start();
        SpringApplication.run(WebServerApplication.class, args);
    }

    @EventListener
    public void registerJvmMetricsOnBoot(ApplicationReadyEvent event) {
        DefaultExports.initialize();
    }

    @EventListener
    public void onApplicationStartup(ApplicationReadyEvent event) {
        if (startupStopWatch.isRunning()) {
            startupStopWatch.stop();
        }

        new StartupInfoExports( ManagementFactory.getRuntimeMXBean().getUptime() / 1000.0, startupStopWatch.getTotalTimeSeconds()).register();
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
