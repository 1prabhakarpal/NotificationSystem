package com.notofication.api.exception;

public class ValidationException extends RuntimeException implements AbstractException {

    Integer statusCode;

    public ValidationException(Integer statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
    }

    public ValidationException(String message) {
        super(message);
    }

    @Override
    public int getStatusCode() {
        return this.statusCode;
    }

    @Override
    public String getErrorMessage() {
        return this.getMessage();
    }
}
