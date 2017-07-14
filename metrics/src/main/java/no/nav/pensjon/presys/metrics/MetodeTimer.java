package no.nav.pensjon.presys.metrics;

import java.util.Map;

public class MetodeTimer {

    public static Object timeMetode(Metodekall metodekall, String timerNavn) throws Throwable {
        return timeMetode(metodekall, timerNavn, null);
    }

    public static Object timeMetode(Metodekall metodekall, String timerNavn, Map<String, String> verdier) throws Throwable {
        Timer timer = MetricsFactory.createTimer(timerNavn);

        if (verdier != null) {
            for (Map.Entry<String, String> verdi : verdier.entrySet()) {
                timer.addFieldToReport(verdi.getKey(), verdi.getValue());
            }
        }

        try {
            timer.start();
            return metodekall.kallMetode();
        } catch (Throwable throwable) {
            timer.setFailed();
            throw throwable;
        } finally {
            timer.stop();
            timer.report();
        }

    }
}
