package no.nav.autoconfigure.abac;

import no.nav.autoconfigure.serviceuser.ServiceUserProperties;
import no.nav.abac.core.consumer.AbacConsumer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.autoconfigure.context.PropertyPlaceholderAutoConfiguration;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AbacAutoConfigurationTest {

    private AnnotationConfigApplicationContext context;

    @Before
    public void setup() {
        context = new AnnotationConfigApplicationContext();
    }

    @After
    public void close() {
        if (context == null) {
            return;
        }

        context.close();
    }

    @Test
    public void testSetUsernameAndPasswordFromServiceUser() {
        load("serviceuser.username:foo", "serviceuser.password:bar",
                "abac.url:http://example.tld");
        context.getBean(AbacConsumer.class);
    }

    private void load(String... properties) {
        TestPropertyValues.of(properties).applyTo(context);

        context.register(AbacAutoConfiguration.class,
                ServiceUserProperties.class,
                PropertyPlaceholderAutoConfiguration.class);

        context.refresh();
    }
}
