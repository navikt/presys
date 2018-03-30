package no.nav.abac.core.annotation.attribute;

public class ResolvingAbacAttributeLocator implements AbacAttributeLocator {
    private String attribute;
    private AttributeSupplier supplier;

    public ResolvingAbacAttributeLocator(String attribute, AttributeSupplier supplier) {
        this.attribute = attribute;
        this.supplier = supplier;
    }

    @Override
    public String getAttribute() {
        return attribute;
    }

    @Override
    public Object getValue() {
        return supplier.get();
    }
}
