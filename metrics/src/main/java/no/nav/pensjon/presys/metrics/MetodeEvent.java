package no.nav.pensjon.presys.metrics;

import java.util.Map;

public class MetodeEvent {

    public static Object eventForMetode(Metodekall metodekall, String eventNavn) throws Throwable {
        return eventForMetode(metodekall, eventNavn, null, null);
    }

    public static Object eventForMetode(Metodekall metodekall, String eventNavn, Map<String, String> verdier, Map<String, String> tags) throws Throwable {
        Event event = MetricsFactory.createEvent(eventNavn);

        if (verdier != null) {
            for (Map.Entry<String, String> verdi : verdier.entrySet()) {
                event.addFieldToReport(verdi.getKey(), verdi.getValue());
            }
        }

        if (tags != null) {
            for (Map.Entry<String, String> tag : tags.entrySet()) {
                event.addTagToReport(tag.getKey(), tag.getValue());
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
