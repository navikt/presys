package no.nav.pensjon.presys.utils.ebcdic.annotations;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Repeatable(UnmappedFields.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface UnmappedField {
    String name();
    int start();
    int length();
}
