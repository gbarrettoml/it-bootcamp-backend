package com.mercadolivre.storage_implementation2_pi1.api.controller.exception;

import com.mercadolivre.storage_implementation2_pi1.domain.exception.JewelNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(JewelNotFoundException.class)
    protected ResponseEntity<?> jewelNotFoundException(JewelNotFoundException err) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err.getMessage());
    }
}
