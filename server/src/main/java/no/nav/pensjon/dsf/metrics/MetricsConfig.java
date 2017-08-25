package no.nav.pensjon.dsf.metrics;

import no.nav.metrics.aspects.CountAspect;
import no.nav.metrics.aspects.ExceptionMeteredAspect;
import no.nav.metrics.aspects.TimerAspect;
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

    @Bean
    public ExceptionMeteredAspect exceptionMeteredAspect() {
        return new ExceptionMeteredAspect();
    }
}