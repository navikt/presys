package no.nav.pensjon.presys.metrics.aspects;


import java.lang.annotation.*;

/**
 * Se {@link ExceptionMeteredAspect} for eksempler på bruk.
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExceptionMetered {
    /**
     * Navnet på eventet genereres automatisk, men kan overskrives her.
     * Om name settes på Count på en klasse, vil et punktum og metodenavnet bli lagt
     * på i tillegg.
     */
    String name() default "";

    /**
     * Brukes bare om annotasjonen er på en klasse.
     * I tilleg blir hashCode, equals og toString alltid ignorert.
     * <p>
     * Finnes ikke en tilsvarende "inkluderteMetoder" som i proxy-versjonen,
     * sett i stedet da annotasjonen direkte kun på de metodene som ønskes
     */
    String[] ignoredMethods() default {};

    /**
     * Om argumenter til metoden skal logges sammen med exceptioneventet.
     * Kan kun brukes når annotasjonen brukes rett på en metode.
     */
    Field[] fields() default {};

    /**
     * Hvilke exceptioner (underklasser inkludert) som skal logges. Default er at alle typer exceptions skal logges.
     */
    Class<? extends Throwable> cause() default Exception.class;

    /**
     * Angir om at det skal logges hvilken type exception som har blitt kastet.
     */
    boolean logCause() default true;

    /**
     * En array av throwables som skal ignoreres.
     */
    Class<? extends Throwable>[] ignoreExceptions() default {};

    /**
     * Kan settes til false for ikke å logge metodenavn som egen measurement, men heller logge metodenavn som et felt i en felles measurement.
     */
    boolean logMethodAsUniqueMeasurement() default true;
}