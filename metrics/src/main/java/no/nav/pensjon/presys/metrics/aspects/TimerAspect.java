package no.nav.pensjon.presys.metrics.aspects;

import no.nav.pensjon.presys.metrics.MetodeTimer;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static no.nav.pensjon.presys.metrics.aspects.AspectUtil.*;

/**
 * HOWTO:
 * - aspectjweaver som en runtime dependency
 * - @EnableAspectJAutoProxy i Spring-config
 * - Gjør TimerAspect tilgjengelig som en Spring-bean
 * - Sørg for at klassen der du bruker @Timed er managed av Spring
 */
@Aspect
@Component
public class TimerAspect {
    @Pointcut("execution(public * *(..))")
    public void publicMethod() {
    }

    @SuppressWarnings("ProhibitedExceptionThrown")
    @Around("publicMethod() && @annotation(timed)")
    public Object timerPaMetode(final ProceedingJoinPoint joinPoint, final Timed timed) throws Throwable {
        AspectMetodekall metodekall = new AspectMetodekall(joinPoint);
        boolean logMethodAsUniqueMeasurement = timed.logMethodAsUniqueMeasurement();
        String timerName = lagMetodeTimernavn(joinPoint, timed.name(), logMethodAsUniqueMeasurement);
        Map<String, String> felt = new HashMap<>();
        if(!logMethodAsUniqueMeasurement) {
            felt = leggPaaMetodeNavnSomTag(joinPoint, felt);
        }

        return MetodeTimer.timeMetode(metodekall, timerName, felt); // test metode feiler fordi metode med 2 parametre blir ikke lenger kalt.
    }

    @SuppressWarnings("ProhibitedExceptionThrown")
    @Around("publicMethod() && @within(timed)")
    public Object timerPaKlasse(final ProceedingJoinPoint joinPoint, final Timed timed) throws Throwable {
        if (metodeSkalIgnoreres(getMetodenavn(joinPoint), timed.ignoredMethods())) {
            return joinPoint.proceed();
        }

        AspectMetodekall metodekall = new AspectMetodekall(joinPoint);
        boolean logMethodAsUniqueMeasurement = timed.logMethodAsUniqueMeasurement();

        String timerNavn = lagKlasseTimernavn(joinPoint, timed.name(), logMethodAsUniqueMeasurement);
        Map<String, String> felt = new HashMap<>();
        if(!logMethodAsUniqueMeasurement) {
            felt = leggPaaMetodeNavnSomTag(joinPoint, felt);
        }

        return MetodeTimer.timeMetode(metodekall, timerNavn, felt);
    }
}
