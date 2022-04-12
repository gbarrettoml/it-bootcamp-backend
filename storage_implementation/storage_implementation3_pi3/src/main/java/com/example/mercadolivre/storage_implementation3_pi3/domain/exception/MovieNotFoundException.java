package com.example.mercadolivre.storage_implementation3_pi3.domain.exception;

import com.example.mercadolivre.storage_implementation3_pi3.infrastructure.exception.EntityNotFoundException;

public class MovieNotFoundException extends EntityNotFoundException {

    public MovieNotFoundException(Integer id) {
        super("Movie searched by id " + id + " is not found in our database.");
    }
}
