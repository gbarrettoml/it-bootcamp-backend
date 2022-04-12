package com.example.mercadolivre.storage_implementation3_pi3.domain.exception;

import com.example.mercadolivre.storage_implementation3_pi3.infrastructure.exception.EntityNotFoundException;

public class SeasonNotFoundException extends EntityNotFoundException {

    public SeasonNotFoundException(Integer id) {
        super("Season searched by id " + id + " is not found in our database.");
    }
}
