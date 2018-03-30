package no.nav.abac.core.consumer;

import no.nav.abac.core.dto.request.XacmlRequest;
import no.nav.abac.core.dto.response.XacmlResponse;

public interface AbacConsumer {

    XacmlResponse evaluate(XacmlRequest request);
}
