package com.example.mercadolivre.storage_implementation3_pi3.domain.exception;

import com.example.mercadolivre.storage_implementation3_pi3.infrastructure.exception.EntityNotFoundException;

public class SerieNotFoundException extends EntityNotFoundException {

    public SerieNotFoundException(Integer id) {
        super("Serie searched by id " + id + " is not found in our database.");
    }
}
