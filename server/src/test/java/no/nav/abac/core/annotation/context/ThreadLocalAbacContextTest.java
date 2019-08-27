package no.nav.abac.core.annotation.context;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

import no.nav.abac.core.dto.request.XacmlRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ThreadLocalAbacContextTest {

    @InjectMocks
    private ThreadLocalAbacContext context;

    @Test
    public void getRequestReturnsRequest() {
        XacmlRequest result = context.getRequest();

        assertThat(result, is(notNullValue()));
    }

    @Test
    public void getRequestReturnsSameInstanceWhenMultipleCalls() {
        XacmlRequest result1 = context.getRequest();
        XacmlRequest result2 = context.getRequest();

        assertThat(result1, is(sameInstance(result2)));
    }

    @Test
    public void getRequestsReturnsNewInstanceWhenCleanUpCalled() {
        XacmlRequest result1 = context.getRequest();

        context.cleanUp();

        XacmlRequest result2 = context.getRequest();

        assertThat(result1, is(not(sameInstance(result2))));
    }
}
