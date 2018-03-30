package no.nav.abac.core.exception;

public class IndeterminateDecisionException extends RuntimeException {
    public IndeterminateDecisionException() {
        super("Got indeterminate result from ABAC");
    }
}
