package ch.iw.edumago.controller;

import ch.iw.edumago.exceptions.BadRequestException;
import ch.iw.edumago.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public NotFoundException handleNotFound(){
        return new NotFoundException("not found");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    public BadRequestException handleBadRequest(){
        return new BadRequestException("Bad Request");
    }
}
