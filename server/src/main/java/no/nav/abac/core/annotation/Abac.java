package no.nav.abac.core.annotation;

import no.nav.abac.core.dto.response.Decision;

import java.lang.annotation.*;

@Inherited
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Abac {
    Attr[] resources() default {};
    Attr[] subjects() default {};
    Attr[] actions() default {};
    Attr[] environments() default {};

    boolean failOnIndeterminate() default false;
    Decision bias() default Decision.PERMIT;

    @interface Attr {
        String key();
        String value() default "";
    }
}
