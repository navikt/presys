package no.nav.abac.core.dto.response;

import java.util.List;

public class XacmlResponse {
    private final Decision decision;
    private final Decision originalDecision;
    private final List<Obligation> obligations;
    private final List<Advice> advices;

    public XacmlResponse(Decision decision, Decision originalDecision, List<Obligation> obligations, List<Advice> advices) {
        this.decision = decision;
        this.originalDecision = originalDecision;
        this.obligations = obligations;
        this.advices = advices;
    }

    public Decision getDecision() {
        return decision;
    }

    public Decision getOriginalDecision() {
        return originalDecision;
    }

    public List<Obligation> getObligations() {
        return obligations;
    }

    public List<Advice> getAdvices() {
        return advices;
    }
}
