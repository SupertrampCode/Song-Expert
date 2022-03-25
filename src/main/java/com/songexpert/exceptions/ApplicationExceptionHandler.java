package com.songexpert.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AplicationExceptionHandler {

        @ExceptionHandler(ElementAlreadyExistException.class)
        @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
        public ResponseEntity<String> entityNotFoundExceptionHandler(ElementAlreadyExistException exception) {
        return getStatusAndModel(HttpStatus.NOT_ACCEPTABLE, exception);
        }

        private ResponseEntity<String> getStatusAndModel(HttpStatus httpStatus, Exception exception) {
        return new ResponseEntity<>(exception.getMessage(), httpStatus);
    }
}
