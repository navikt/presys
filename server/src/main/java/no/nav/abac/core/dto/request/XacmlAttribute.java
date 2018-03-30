package no.nav.abac.core.dto.request;

public class XacmlAttribute {
    private String attributeId;
    private Object value;

    XacmlAttribute(String attributeId, Object value) {
        this.attributeId = attributeId;
        this.value = value;
    }

    public String getAttributeId() {
        return attributeId;
    }

    public Object getValue() {
        return value;
    }
}
