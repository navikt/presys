package no.nav.pensjon.presys.metrics;


import java.util.Map;
import java.util.stream.Stream;

public class MetodeExceptionEvent {
    public static Object exceptionEventForMetode(Metodekall metodekall, String exceptionEventNavn, Class<? extends Throwable> cause, boolean logCause, Class<? extends Throwable>[] ignoreExceptions, Map<String, String> verdier) throws Throwable {
        try {
            return metodekall.kallMetode();
        } catch (Throwable throwable) {
            // Sjekker at exception er av samme type (eller subtype) av den som skal logges.
            if(cause.isAssignableFrom(throwable.getClass())) {
                // Sjekker at exception ikke er av samme type (eller subtype) av en av dem som ikke skal logges
                if(Stream.of(ignoreExceptions).noneMatch(e -> e.isAssignableFrom(throwable.getClass()))) {
                    ExceptionEvent exceptionEvent = MetricsFactory.createExceptionEvent(exceptionEventNavn);
                    if (verdier != null) {
                        for (Map.Entry<String, String> verdi : verdier.entrySet()) {
                            exceptionEvent.addFieldToReport(verdi.getKey(), verdi.getValue());
                        }
                    }
                    if (logCause) {
                        exceptionEvent.addFieldToReport("cause", throwable.getClass().getName());
                    }
                    exceptionEvent.report();
                }
            }
            throw throwable;
        }
    }

    public static Object exceptionEventForMetode(Metodekall metodekall, String exceptionEventNavn, Class<? extends Throwable> cause, boolean logCause, Class<? extends Throwable>[] ignoreExceptions) throws Throwable {
        return exceptionEventForMetode(metodekall, exceptionEventNavn, cause, logCause, ignoreExceptions, null);
    }

    // TODO trøbbel?
    public static Object exceptionEventForMetode(Metodekall metodekall, String exceptionEventNavn) throws Throwable {
        return exceptionEventForMetode(metodekall, exceptionEventNavn, Exception.class, true, new Class[0]);
    }
}
