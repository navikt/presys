package no.nav.abac.core.annotation.context;

import no.nav.abac.core.dto.request.XacmlRequest;

public class ThreadLocalAbacContext implements AbacContext {
    private final ThreadLocal<XacmlRequest> threadLocalRequest = new ThreadLocal<XacmlRequest>() {
        @Override
        protected XacmlRequest initialValue() {
            return new XacmlRequest();
        }
    };

    @Override
    public XacmlRequest getRequest() {
        return threadLocalRequest.get();
    }

    @Override
    public void cleanUp() {
        threadLocalRequest.remove();
    }
}
