package no.nav.abac.core.dto.response;

public enum Decision {
    PERMIT("Permit"),
    DENY("Deny"),
    INDETERMINATE("Indeterminate"),
    NOT_APPLICABLE("NotApplicable");

    private final String value;

    public static Decision findByValue(String value) {
        for (Decision decision : Decision.values()) {
            if (decision.getValue().equals(value)) {
                return decision;
            }
        }
        return null;
    }

    Decision(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
