package no.nav.pensjon.dsf.web.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class ResourceNotFound extends IllegalArgumentException {
    public ResourceNotFound(){

    }
    public ResourceNotFound(Exception cause){
        super(cause);
    }
}
