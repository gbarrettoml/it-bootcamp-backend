package com.example.mercadolivre.storage_implementation3_pi3.domain.exception;

import com.example.mercadolivre.storage_implementation3_pi3.infrastructure.exception.EntityNotFoundException;

public class EpisodeNotFoundException extends EntityNotFoundException {

    public EpisodeNotFoundException(Integer id) {
        super("Episode searched by id " + id + " is not found in our database.");
    }
}
