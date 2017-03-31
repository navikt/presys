package no.nav.pensjon.dsf.web.resources;

import no.nav.pensjon.dsf.web.Exceptions.ResourceNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by d132988 on 31.03.2017.
 */
@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(ResourceNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    void resourceNotFound(){

    }



}
