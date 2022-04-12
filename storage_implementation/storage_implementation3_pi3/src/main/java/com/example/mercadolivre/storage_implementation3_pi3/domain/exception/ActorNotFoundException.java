package com.example.mercadolivre.storage_implementation3_pi3.domain.exception;

import com.example.mercadolivre.storage_implementation3_pi3.infrastructure.exception.EntityNotFoundException;

public class ActorNotFoundException extends EntityNotFoundException {

    public ActorNotFoundException (Integer id) {
        super("Actor searched by " + id + " is not found in our database.");
    }
}
