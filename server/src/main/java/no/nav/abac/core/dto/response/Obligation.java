package no.nav.abac.core.dto.response;

import java.util.List;

public class Obligation {
    private String id;
    private List<AttributeAssignment> attributeAssignments;

    public Obligation(String id, List<AttributeAssignment> attributeAssignments) {
        this.id = id;
        this.attributeAssignments = attributeAssignments;
    }

    public String getId() {
        return id;
    }

    public List<AttributeAssignment> getAttributeAssignments() {
        return attributeAssignments;
    }

    public static ObligationBuilder builder() {
        return new ObligationBuilder();
    }

    public static final class ObligationBuilder {
        private String id;
        private List<AttributeAssignment> attributeAssignments;

        private ObligationBuilder() {
        }

        public ObligationBuilder id(String id) {
            this.id = id;
            return this;
        }

        public ObligationBuilder attributeAssignments(List<AttributeAssignment> attributeAssignments) {
            this.attributeAssignments = attributeAssignments;
            return this;
        }

        public Obligation build() {
            return new Obligation(id, attributeAssignments);
        }
    }
}
