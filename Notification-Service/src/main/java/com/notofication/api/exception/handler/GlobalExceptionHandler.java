package com.notofication.api.exception.handler;

import java.util.function.Supplier;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.notofication.api.exception.AbstractException;
import com.notofication.api.exception.ResourceNotFoundException;
import com.notofication.api.exception.ValidationException;
import com.notofication.api.utils.CommonUtils;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return genericExceptionHandler(ex, () -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage()));
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<String> handleValidationException(ValidationException ex) {
        return genericExceptionHandler(ex, () -> ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage()));

    }

    public ResponseEntity<String> genericExceptionHandler(final AbstractException ex,
            Supplier<ResponseEntity<String>> supplier) {
        if (CommonUtils.isNotEmpty(ex.getStatusCode())) {
            return ResponseEntity.status(ex.getStatusCode()).body(ex.getErrorMessage());
        }
        return supplier.get();
    }

}
