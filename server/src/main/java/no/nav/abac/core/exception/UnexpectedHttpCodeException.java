package no.nav.abac.core.exception;

public class UnexpectedHttpCodeException extends RuntimeException {
    public UnexpectedHttpCodeException(int got, int expected, String reason) {
        super("Got http code: " + got + ". Expected: " + expected + ". Reason: " + reason);
    }
}
