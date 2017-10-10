package edu.mum.mpp.exceptions;

public class BadRequestException extends AbstractException {

    public BadRequestException(String code, String message) {
        super(code, message);
    }
}