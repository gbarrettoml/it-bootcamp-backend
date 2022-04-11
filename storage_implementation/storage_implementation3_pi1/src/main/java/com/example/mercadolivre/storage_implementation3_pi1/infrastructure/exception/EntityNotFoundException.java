package com.example.mercadolivre.storage_implementation3_pi1.infrastructure.exception;

import org.springframework.http.HttpStatus;

public class EntityNotFoundException extends RuntimeException {

    private HttpStatus httpStatus;

    public EntityNotFoundException (String message) {
        super(message);
        httpStatus = HttpStatus.BAD_REQUEST;
    }
}
