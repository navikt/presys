package no.nav.abac.core.service.common;

public interface AttributeStrategy<T> {
    boolean isSupported(String attributeId);

    void perform(T attribute);
}
