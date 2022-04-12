package com.example.mercadolivre.storage_implementation3_pi3.domain.exception;

import com.example.mercadolivre.storage_implementation3_pi3.infrastructure.exception.EntityNotFoundException;

public class GenreNotFoundException extends EntityNotFoundException {

    public GenreNotFoundException(Integer id) {
        super("Genre searched by id " + id + " is not found in our database.");
    }
}
