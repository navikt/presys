package no.nav.pensjon.presys.metrics;

import java.util.Map;

public class MetodeEvent {

    public static Object eventForMetode(Metodekall metodekall, String eventNavn) throws Throwable {
        return eventForMetode(metodekall, eventNavn, null);
    }

    public static Object eventForMetode(Metodekall metodekall, String eventNavn, Map<String, String> verdier) throws Throwable {
        Event event = MetricsFactory.createEvent(eventNavn);

        if (verdier != null) {
            for (Map.Entry<String, String> verdi : verdier.entrySet()) {
                event.addFieldToReport(verdi.getKey(), verdi.getValue());
            }
        }

        try {
            return metodekall.kallMetode();
        } catch (Throwable throwable) {
            event.setFailed();
            throw throwable;
        } finally {
            event.report();
        }
    }
}
