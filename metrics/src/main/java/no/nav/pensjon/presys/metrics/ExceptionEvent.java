package no.nav.pensjon.presys.metrics;

public class ExceptionEvent extends Metric {

    ExceptionEvent(MetricsClient metricsClient, String name) {
        super(metricsClient, name + ".exceptionevent");
        addFieldToReport("value", 1);
    }

    @Override
    public void report() {
        metricsClient.report(name, fields, tags, System.currentTimeMillis());
    }
}
