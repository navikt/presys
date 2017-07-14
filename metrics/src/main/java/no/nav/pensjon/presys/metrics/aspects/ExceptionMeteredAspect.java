package no.nav.pensjon.presys.metrics.aspects;

import no.nav.pensjon.presys.metrics.MetodeExceptionEvent;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Integer.parseInt;
import static no.nav.pensjon.presys.metrics.aspects.AspectUtil.*;

/**
 * HOWTO:
 * - aspectjweaver som en runtime dependency
 * - @EnableAspectJAutoProxy i Spring-config
 * - Gjør ExceptionMeteredAspect tilgjengelig som en Spring-bean
 * - Sørg for at klassen der du bruker @ExceptionMetered er managed av Spring
 * <p>
 * Kan brukes f. eks. slik:
 * <pre>
 *
 * {@literal @}ExceptionMetered
 * public void methodname() {
 *
 * }
 *
 * eller slik:
 *
 * {@literal @}ExceptionMetered(name = "exceptioneventnavn")
 * public void methodname() {
 *
 * }
 *
 * eller om du vil ha med et field i rapporten, slik:
 *
 * {@literal @}ExceptionMetered(name = "exceptioneventnavn", fields = {{@literal @}Field(key = "orgnummer", argumentNumber = "2")})
 * public void methodname(String id, String orgnummer) {
 * }
 * </pre>
 */
@Aspect
@Component
public class ExceptionMeteredAspect {
    @Pointcut("execution(public * *(..))")
    public void publicMethod() {
    }

    @Around("publicMethod() && @annotation(exceptionmetered)")
    public Object exceptionmeteredPaMetode(ProceedingJoinPoint joinPoint, ExceptionMetered exceptionmetered) throws Throwable {
        AspectMetodekall metodekall = new AspectMetodekall(joinPoint);
        boolean logMethodAsUniqueMeasurement = exceptionmetered.logMethodAsUniqueMeasurement();
        String exceptionEventNavn = lagMetodeTimernavn(joinPoint, exceptionmetered.name(), logMethodAsUniqueMeasurement);
        Map<String, String> felt = finnArgumentVerdier(joinPoint, exceptionmetered);
        Map<String, String> tags = new HashMap<>();
        if(!logMethodAsUniqueMeasurement) {
            tags = leggPaaMetodeNavnSomTag(joinPoint, tags);
        }

        Class<? extends Throwable> cause = exceptionmetered.cause();
        boolean logCause = exceptionmetered.logCause();
        Class<? extends Throwable>[] ignoreExceptions = exceptionmetered.ignoreExceptions();

        return MetodeExceptionEvent.exceptionEventForMetode(metodekall, exceptionEventNavn, cause, logCause, ignoreExceptions, felt, tags);
    }

    @Around("publicMethod() && @within(exceptionmetered)")
    public Object exceptionmeteredPaKlasse(ProceedingJoinPoint joinPoint, ExceptionMetered exceptionmetered) throws Throwable {
        if (metodeSkalIgnoreres(getMetodenavn(joinPoint), exceptionmetered.ignoredMethods())) {
            return joinPoint.proceed();
        }

        boolean logMethodAsUniqueMeasurement = exceptionmetered.logMethodAsUniqueMeasurement();

        AspectMetodekall metodekall = new AspectMetodekall(joinPoint);
        String exceptionEventNavn = lagKlasseTimernavn(joinPoint, exceptionmetered.name(), logMethodAsUniqueMeasurement);

        Map<String, String> tag = new HashMap<>();
        if(!logMethodAsUniqueMeasurement) {
            tag = leggPaaMetodeNavnSomTag(joinPoint, tag);
        }

        Class<? extends Throwable> cause = exceptionmetered.cause();
        boolean logCause = exceptionmetered.logCause();
        Class<? extends Throwable>[] ignoreExceptions = exceptionmetered.ignoreExceptions();

        return MetodeExceptionEvent.exceptionEventForMetode(metodekall, exceptionEventNavn, cause, logCause, ignoreExceptions, new HashMap<>(), tag);
    }

    private Map<String, String> finnArgumentVerdier(JoinPoint joinPoint, ExceptionMetered exceptionMetered) {
        if (exceptionMetered.fields().length == 0) {
            return null;
        }

        Map<String, String> verdier = new HashMap<>();

        Object[] args = joinPoint.getArgs();

        for (Field field : exceptionMetered.fields()) {
            String value = args[parseInt(field.argumentNumber()) - 1].toString();
            verdier.put(field.key(), value);
        }

        return verdier;
    }
}
