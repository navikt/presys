package no.nav.abac.core.service;

import no.nav.abac.core.dto.request.XacmlRequest;
import no.nav.abac.core.dto.response.XacmlResponse;

public interface AbacService {

    XacmlResponse evaluate(XacmlRequest request);
}
