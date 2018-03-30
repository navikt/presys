package no.nav.abac.core.annotation;

import no.nav.abac.core.annotation.attribute.AbacAttributePopulator;
import no.nav.abac.core.annotation.context.AbacContext;
import no.nav.abac.core.dto.request.XacmlRequest;
import org.aopalliance.intercept.MethodInvocation;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.lang.reflect.Method;

import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AbacMethodInterceptorTest {

    @Mock
    private AbacContext contextMock;

    @Mock
    private AbacAttributePopulator populatorMock;

    @Mock
    private MethodInvocation miMock;

    @Mock
    private XacmlRequest requestMock;

    private AbacMethodInterceptor interceptor;

    @Before
    public void before() throws Exception {
        interceptor = new AbacMethodInterceptor(contextMock, populatorMock);
        stubMethod();
        when(contextMock.getRequest()).thenReturn(requestMock);
    }

    @Test
    public void callsPopulatorThenProceedThenCleanUp() throws Throwable { // NOSONAR
        interceptor.invoke(miMock);

        Abac annotation = getAnnotation();
        InOrder inOrder = Mockito.inOrder(populatorMock, miMock, contextMock);
        inOrder.verify(contextMock).getRequest();
        inOrder.verify(populatorMock).populate(requestMock, annotation);
        inOrder.verify(miMock).proceed();
        inOrder.verify(contextMock).cleanUp();
    }

    @Test
    public void returnsResultFromMethodInterceptorProceed() throws Throwable { // NOSONAR
        Object obj = new Object();
        when(miMock.proceed()).thenReturn(obj);

        Object result = interceptor.invoke(miMock);

        assertThat(result, is(sameInstance(obj)));
    }

    @Test(expected = NullPointerException.class)
    public void callsAbacContextCleanUpWhenExceptionIsThrown() throws Throwable { // NOSONAR
        NullPointerException npe = new NullPointerException();
        when(miMock.proceed()).thenThrow(npe);

        try {
            interceptor.invoke(miMock);
        } finally {
            verify(contextMock).cleanUp();
        }
    }

    @Test(expected = NullPointerException.class)
    public void throwsExceptionFromMethodInterceptorProceed() throws Throwable { // NOSONAR
        NullPointerException npe = new NullPointerException();
        when(miMock.proceed()).thenThrow(npe);

        interceptor.invoke(miMock);
    }

    private void stubMethod() throws Exception {
        Method method = TestClass.class.getMethod("testMethod");
        when(miMock.getMethod()).thenReturn(method);
    }

    private Abac getAnnotation() {
        return miMock.getMethod().getAnnotation(Abac.class);
    }

    static class TestClass {
        @Abac
        public Object testMethod() {
            return null;
        }
    }
}
