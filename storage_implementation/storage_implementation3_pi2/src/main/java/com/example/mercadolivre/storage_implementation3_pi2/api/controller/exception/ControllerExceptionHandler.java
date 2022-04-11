package com.example.mercadolivre.storage_implementation3_pi2.api.controller.exception;

import com.example.mercadolivre.storage_implementation3_pi2.domain.exception.TutorialNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(TutorialNotFoundException.class)
    protected ResponseEntity<?> tutorialNotFoundException(TutorialNotFoundException err) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err.getMessage());
    }
}
