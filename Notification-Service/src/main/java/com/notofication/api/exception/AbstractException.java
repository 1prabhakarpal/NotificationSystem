package com.notofication.api.exception;

public interface AbstractException {

    int getStatusCode();

    String getErrorMessage();
}
