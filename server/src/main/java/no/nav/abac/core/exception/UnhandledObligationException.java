package no.nav.abac.core.exception;

public class UnhandledObligationException extends RuntimeException {
    public UnhandledObligationException(String obligationId) {
        super("No strategy found to handle obligation with id: " + obligationId);
    }
}
