package no.nav.abac.core.annotation.attribute;

import no.nav.abac.core.annotation.Abac;
import no.nav.abac.core.dto.request.XacmlRequest;

public interface AbacAttributePopulator {

    void populate(XacmlRequest request, Abac abac);
}
