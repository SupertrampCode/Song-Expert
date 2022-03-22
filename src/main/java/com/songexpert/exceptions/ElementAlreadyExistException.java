package com.songexpert.exceptions;

public class ElementAlreadyExistException extends RuntimeException {
    public ElementAlreadyExistException(String message) {
        super(message);
    }
}
