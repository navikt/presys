package no.nav.abac.core.annotation.context;

import no.nav.abac.core.dto.request.XacmlRequest;

public interface AbacContext {

    XacmlRequest getRequest();

    void cleanUp();
}
