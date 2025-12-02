package com.notofication.api.exception;

public class ResourceNotFoundException extends RuntimeException implements AbstractException {

    Integer statusCode;

    public ResourceNotFoundException(Integer statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }

    @Override
    public String getErrorMessage() {
        return this.getMessage();
    }

    @Override
    public int getStatusCode() {
        return this.statusCode;
    }
}
