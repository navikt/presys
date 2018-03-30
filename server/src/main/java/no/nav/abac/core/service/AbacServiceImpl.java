package no.nav.abac.core.service;

import no.nav.abac.core.consumer.AbacConsumer;
import no.nav.abac.core.dto.request.XacmlRequest;
import no.nav.abac.core.dto.response.Decision;
import no.nav.abac.core.dto.response.Obligation;
import no.nav.abac.core.dto.response.XacmlResponse;
import no.nav.abac.core.exception.IndeterminateDecisionException;
import no.nav.abac.core.exception.UnhandledObligationException;
import no.nav.abac.core.service.advice.AdviceStrategy;
import no.nav.abac.core.service.common.AttributeStrategy;
import no.nav.abac.core.service.obligation.ObligationStrategy;
import no.nav.abac.core.dto.response.Advice;

import java.util.List;

public class AbacServiceImpl implements AbacService {

    private final List<ObligationStrategy> obligationStrategies;
    private final List<AdviceStrategy> adviceStrategies;
    private final AbacConsumer consumer;

    public AbacServiceImpl(List<ObligationStrategy> obligationStrategies, List<AdviceStrategy> adviceStrategies, AbacConsumer consumer) {
        this.obligationStrategies = obligationStrategies;
        this.adviceStrategies = adviceStrategies;
        this.consumer = consumer;
    }

    @Override
    public XacmlResponse evaluate(XacmlRequest request) {
        XacmlResponse response = consumer.evaluate(request);
        response = assignResultBasedOnBias(request, response);

        handleObligations(response);
        handleAdvice(response);

        return response;
    }

    private XacmlResponse assignResultBasedOnBias(XacmlRequest request, XacmlResponse response) {
        if (response.getOriginalDecision() == Decision.INDETERMINATE && request.isFailOnIndeterminate()) {
            throw new IndeterminateDecisionException();
        } else if (response.getOriginalDecision() != Decision.PERMIT && response.getOriginalDecision() != Decision.DENY) {
            return new XacmlResponse(request.getBias(), response.getOriginalDecision(), response.getObligations(), response.getAdvices());
        }
        return response;
    }

    private void handleObligations(XacmlResponse response) {
        for (Obligation obligation : response.getObligations()) {
            ObligationStrategy strategy = findSupportedStrategy(obligation.getId(), obligationStrategies);
            if (strategy == null) {
                throw new UnhandledObligationException(obligation.getId());
            }
            strategy.perform(obligation);
        }
    }

    private void handleAdvice(XacmlResponse response) {
        for (Advice advice : response.getAdvices()) {
            AdviceStrategy strategy = findSupportedStrategy(advice.getId(), adviceStrategies);
            if (strategy != null) {
                strategy.perform(advice);
            }
        }
    }

    private <T extends AttributeStrategy<?>> T findSupportedStrategy(String id, List<T> strategies) {
        for (T strategy : strategies) {
            if (strategy.isSupported(id)) {
                return strategy;
            }
        }
        return null;
    }
}
