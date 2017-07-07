/*package no.nav.pensjon.dsf.metrics;

import com.codahale.metrics.MetricRegistry;
import com.ryantenney.metrics.spring.config.annotation.EnableMetrics;
import com.ryantenney.metrics.spring.config.annotation.MetricsConfigurerAdapter;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableMetrics(proxyTargetClass = true)
public class MetricsConfig extends MetricsConfigurerAdapter {

    private MetricRegistry metricRegistry = new MetricRegistry();

    @Override
    public MetricRegistry getMetricRegistry() {
        return metricRegistry;
    }
}
*/
package no.nav.pensjon.dsf.metrics;

import no.nav.pensjon.presys.metrics.aspects.CountAspect;
import no.nav.pensjon.presys.metrics.aspects.TimerAspect;
import org.springframework.context.annotation.Bean;

public class MetricsConfig {

    @Bean
    public TimerAspect timerAspect() {
        return new TimerAspect();
    }

    @Bean
    public CountAspect countAspect() {
        return new CountAspect();
    }
}