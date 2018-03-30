package no.nav.abac.core.service;

import no.nav.abac.core.consumer.AbacConsumer;
import no.nav.abac.core.dto.request.XacmlRequest;
import no.nav.abac.core.dto.response.*;
import no.nav.abac.core.exception.IndeterminateDecisionException;
import no.nav.abac.core.exception.UnhandledObligationException;
import no.nav.abac.core.service.advice.AdviceStrategy;
import no.nav.abac.core.service.obligation.ObligationStrategy;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.singletonList;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AbacServiceImplTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Mock
    private ObligationStrategy obligationStrategyMock;

    @Mock
    private AdviceStrategy adviceStrategyMock;

    @Mock
    private AbacConsumer abacConsumerMock;

    @Mock
    private XacmlRequest requestMock;

    @Mock
    private XacmlResponse responseMock;

    private AbacService service;

    @Before
    public void setUp() {
        service = new AbacServiceImpl(singletonList(obligationStrategyMock), singletonList(adviceStrategyMock), abacConsumerMock);
        when(abacConsumerMock.evaluate(requestMock)).thenReturn(responseMock);
        when(responseMock.getOriginalDecision()).thenReturn(Decision.PERMIT);
        when(requestMock.isFailOnIndeterminate()).thenReturn(false);
    }

    @Test
    public void callsConsumerWithRequest() {
        service.evaluate(requestMock);

        verify(abacConsumerMock).evaluate(requestMock);
    }

    @Test
    public void failsWhenDecisionIsIndeterminateAndFailOnIndeterminateIsTrue() {
        when(requestMock.isFailOnIndeterminate()).thenReturn(true);
        when(responseMock.getOriginalDecision()).thenReturn(Decision.INDETERMINATE);

        expectedException.expect(IndeterminateDecisionException.class);

        service.evaluate(requestMock);
    }

    @Test
    public void doesNotFailWhenDecisionIsIndeterminateAndFailOnIndeterminateIsFalse() {
        when(requestMock.isFailOnIndeterminate()).thenReturn(false);
        when(responseMock.getOriginalDecision()).thenReturn(Decision.INDETERMINATE);

        service.evaluate(requestMock);
    }

    @Test
    public void appliesBiasWhenNotApplicable() {
        when(responseMock.getOriginalDecision()).thenReturn(Decision.NOT_APPLICABLE);
        when(requestMock.getBias()).thenReturn(Decision.PERMIT);

        XacmlResponse result = service.evaluate(requestMock);

        assertThat(result.getDecision(), is(Decision.PERMIT));
    }

    @Test
    public void appendsAllInformationFromPreviousXacmlResponseWhenApplyingBias() {
        List<Obligation> obligations = new ArrayList<>();
        List<Advice> advices = new ArrayList<>();
        when(responseMock.getOriginalDecision()).thenReturn(Decision.NOT_APPLICABLE);
        when(responseMock.getObligations()).thenReturn(obligations);
        when(responseMock.getAdvices()).thenReturn(advices);

        XacmlResponse result = service.evaluate(requestMock);

        assertThat(result.getOriginalDecision(), is(Decision.NOT_APPLICABLE));
        assertThat(result.getObligations(), is(sameInstance(obligations)));
        assertThat(result.getAdvices(), is(sameInstance(advices)));
    }

    @Test
    public void returnsSameInstanceWhenNoBiasApplied() {
        XacmlResponse result = service.evaluate(requestMock);

        assertThat(result, is(sameInstance(responseMock)));
    }

    @Test
    public void throwsExceptionWhenObligationNotSupported() {
        Obligation obligation = new Obligation("id", Collections.<AttributeAssignment>emptyList());
        when(responseMock.getObligations()).thenReturn(singletonList(obligation));

        when(obligationStrategyMock.isSupported(anyString())).thenReturn(false);

        expectedException.expect(UnhandledObligationException.class);

        service.evaluate(requestMock);
    }

    @Test
    public void callsObligationStrategyPerformWhenSupported() {
        Obligation obligation = new Obligation("id", Collections.<AttributeAssignment>emptyList());
        when(responseMock.getObligations()).thenReturn(singletonList(obligation));
        when(obligationStrategyMock.isSupported("id")).thenReturn(true);

        service.evaluate(requestMock);

        verify(obligationStrategyMock).isSupported("id");
        verify(obligationStrategyMock).perform(obligation);
    }

    @Test
    public void doesNotCallAdviceStrategyWhenNotSupported() {
        Advice advice = new Advice("id", Collections.<AttributeAssignment>emptyList());
        when(responseMock.getAdvices()).thenReturn(singletonList(advice));

        when(adviceStrategyMock.isSupported(anyString())).thenReturn(false);

        service.evaluate(requestMock);

        verify(adviceStrategyMock).isSupported("id");
        verify(adviceStrategyMock, never()).perform(advice);
    }

    @Test
    public void callsAdviceStrategyPerformWhenSupported() {
        Advice advice = new Advice("id", Collections.<AttributeAssignment>emptyList());
        when(responseMock.getAdvices()).thenReturn(singletonList(advice));

        when(adviceStrategyMock.isSupported("id")).thenReturn(true);

        service.evaluate(requestMock);

        verify(adviceStrategyMock).isSupported("id");
        verify(adviceStrategyMock).perform(advice);
    }
}
