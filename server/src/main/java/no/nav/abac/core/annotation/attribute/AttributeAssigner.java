package no.nav.abac.core.annotation.attribute;

import no.nav.abac.core.dto.request.XacmlRequest;

interface AttributeAssigner {
    void assign(XacmlRequest request, String id, Object value);
}
