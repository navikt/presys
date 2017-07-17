package no.nav.pensjon.presys.metrics.aspects;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;

import static no.nav.pensjon.presys.metrics.proxy.MetricProxy.DO_NOT_MEASURE_METHOD_NAMES;
import java.util.Map;

public class AspectUtil {

    public static  Map<String, String> leggPaaMetodeNavnSomTag(JoinPoint joinPoint, Map<String, String> felt) {
        felt.put("metodenavnTag", getMetodenavn(joinPoint));
        return felt;
    }

    public static String lagMetodeTimernavn(JoinPoint joinPoint, String sattNavn, boolean logMethodAsUniqueMeasurement) {
        if (StringUtils.isBlank(sattNavn)) {
            if(logMethodAsUniqueMeasurement) {
                return getKlassenavn(joinPoint) + "." + getMetodenavn(joinPoint);
            } else {
                return getKlassenavn(joinPoint);
            }
        } else {
            return sattNavn;
        }
    }

    public static String lagKlasseTimernavn(JoinPoint joinPoint, String sattNavn, boolean logMethodAsUniqueMeasurement) {
        String navn;
        if (StringUtils.isBlank(sattNavn)) {
            navn = getKlassenavn(joinPoint);
        } else {
            navn = sattNavn;
        }
        if(logMethodAsUniqueMeasurement) {
            navn+= "." + getMetodenavn(joinPoint);
        }
        return navn;
    }

    public static String getKlassenavn(JoinPoint joinPoint) {
        return joinPoint.getSignature().getDeclaringType().getSimpleName();
    }

    public static String getMetodenavn(JoinPoint joinPoint) {
        return joinPoint.getSignature().getName();
    }

    public static boolean metodeSkalIgnoreres(String metodeNavn, String[] ignorerteMetoder) {
        for (String ignorert : ignorerteMetoder) {
            if (metodeNavn.equals(ignorert)) {
                return true;
            }
        }

        return DO_NOT_MEASURE_METHOD_NAMES.contains(metodeNavn);
    }
}
