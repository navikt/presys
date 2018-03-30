package no.nav.autoconfigure.abac;

import no.nav.autoconfigure.serviceuser.ServiceUserProperties;
import no.nav.abac.core.consumer.AbacConsumer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.autoconfigure.context.PropertyPlaceholderAutoConfiguration;
import org.springframework.boot.test.util.EnvironmentTestUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AbacAutoConfigurationTest {

    private AnnotationConfigApplicationContext context;

    @Before
    public void setup() {
        this.context = new AnnotationConfigApplicationContext();
    }

    @After
    public void close() {
        if (this.context != null) {
            this.context.close();
        }
    }

    @Test
    public void testSetUsernameAndPasswordFromServiceUser() throws Exception {
        load("serviceuser.username:foo", "serviceuser.password:bar",
                "abac.url:http://example.tld");
        AbacConsumer abacConsumer = this.context.getBean(AbacConsumer.class);
    }

    private void load(String... properties) {
        EnvironmentTestUtils.addEnvironment(this.context, properties);
        this.context.register(AbacAutoConfiguration.class,
                ServiceUserProperties.class,
                PropertyPlaceholderAutoConfiguration.class);
        this.context.refresh();
    }
}
