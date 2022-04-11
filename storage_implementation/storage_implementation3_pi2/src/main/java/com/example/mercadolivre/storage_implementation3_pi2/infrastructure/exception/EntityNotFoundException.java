package com.example.mercadolivre.storage_implementation3_pi2.infrastructure.exception;

import org.springframework.http.HttpStatus;

public class EntityNotFoundException extends RuntimeException {

    private final HttpStatus codeStatus;

    public EntityNotFoundException(String message) {
        super(message);
        this.codeStatus = HttpStatus.NOT_FOUND;
    }

}
