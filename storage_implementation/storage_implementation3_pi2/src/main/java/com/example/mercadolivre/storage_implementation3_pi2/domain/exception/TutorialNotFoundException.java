package com.example.mercadolivre.storage_implementation3_pi2.domain.exception;

import com.example.mercadolivre.storage_implementation3_pi2.infrastructure.exception.EntityNotFoundException;

public class TutorialNotFoundException extends EntityNotFoundException {

    public TutorialNotFoundException(String id) {
        super("Tutorial requested by id " + id + " is not found in our database.");
    }
}
