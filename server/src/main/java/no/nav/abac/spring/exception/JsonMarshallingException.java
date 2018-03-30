package no.nav.abac.spring.exception;

public class JsonMarshallingException extends RuntimeException {
    public JsonMarshallingException(String message, Throwable cause) {
        super(message, cause);
    }
}
