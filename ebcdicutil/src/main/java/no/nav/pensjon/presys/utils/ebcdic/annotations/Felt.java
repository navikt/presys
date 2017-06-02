package no.nav.pensjon.presys.utils.ebcdic.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Felt {
    String name();
    int start();
    int length();
}


