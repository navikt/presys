package no.nav.abac.core.dto.response;

public class AttributeAssignment {
    private String attributeId;
    private String value;
    private String category;
    private String dataType;

    private AttributeAssignment(String attributeId, String value, String category, String dataType) {
        this.attributeId = attributeId;
        this.value = value;
        this.category = category;
        this.dataType = dataType;
    }

    public String getAttributeId() {
        return attributeId;
    }

    public String getValue() {
        return value;
    }

    public String getCategory() {
        return category;
    }

    public String getDataType() {
        return dataType;
    }

    public static AttributeAssignmentBuilder builder() {
        return new AttributeAssignmentBuilder();
    }

    public static final class AttributeAssignmentBuilder {
        private String attributeId;
        private String value;
        private String category;
        private String dataType;

        private AttributeAssignmentBuilder() {
        }

        public AttributeAssignmentBuilder attributeId(String attributeId) {
            this.attributeId = attributeId;
            return this;
        }

        public AttributeAssignmentBuilder value(String value) {
            this.value = value;
            return this;
        }

        public AttributeAssignmentBuilder category(String category) {
            this.category = category;
            return this;
        }

        public AttributeAssignmentBuilder dataType(String dataType) {
            this.dataType = dataType;
            return this;
        }

        public AttributeAssignment build() {
            return new AttributeAssignment(attributeId, value, category, dataType);
        }
    }
}
