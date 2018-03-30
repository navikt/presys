package no.nav.abac.spring.exception;

public class JsonUnmarshallingException extends RuntimeException {
    public JsonUnmarshallingException(String message, Throwable cause) {
        super(message, cause);
    }
}
