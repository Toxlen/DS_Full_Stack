package fr.polytech.ds.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import fr.polytech.ds.dto.ErrorMessageDto;
import fr.polytech.ds.exception.NoRestaurantFoundException;
import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class ExceptionsConfig {

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorMessageDto internalServerError(Exception ex) {
        ex.printStackTrace();
        return new ErrorMessageDto("INTERNAL_ERROR", null);
    }

    @ExceptionHandler(value = NoRestaurantFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorMessageDto methodArgumentNotValidExceptionError(NoRestaurantFoundException ex) {
        log.info(ex.getMessage());
        return new ErrorMessageDto("BAD_REQUEST", ex.getMessage());
    }
}
