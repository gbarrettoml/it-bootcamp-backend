package com.example.mercadolivre.storage_implementation3_pi1.api.controller.exception;

import com.example.mercadolivre.storage_implementation3_pi1.domain.exception.TestCaseNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(TestCaseNotFoundException.class)
    protected ResponseEntity<?> testCaseNotFoundException(TestCaseNotFoundException err) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err.getMessage());
    }
}
