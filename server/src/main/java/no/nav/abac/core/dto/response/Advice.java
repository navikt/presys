package no.nav.abac.core.dto.response;

import java.util.List;

public class Advice {
    private String id;
    private List<AttributeAssignment> attributeAssignments;

    public Advice(String id, List<AttributeAssignment> attributeAssignments) {
        this.id = id;
        this.attributeAssignments = attributeAssignments;
    }

    public String getId() {
        return id;
    }

    public List<AttributeAssignment> getAttributeAssignments() {
        return attributeAssignments;
    }

    public static AdviceBuilder builder() {
        return new AdviceBuilder();
    }

    public static final class AdviceBuilder {
        private String id;
        private List<AttributeAssignment> attributeAssignments;

        private AdviceBuilder() {
        }

        public AdviceBuilder id(String id) {
            this.id = id;
            return this;
        }

        public AdviceBuilder attributeAssignments(List<AttributeAssignment> attributeAssignments) {
            this.attributeAssignments = attributeAssignments;
            return this;
        }

        public Advice build() {
            return new Advice(id, attributeAssignments);
        }
    }
}
