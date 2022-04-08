package com.mercadolivre.storage_implementation2_pi1.domain.exception;

import com.mercadolivre.storage_implementation2_pi1.infrastructure.exception.EntityNotFoundException;

public class JewelNotFoundException extends EntityNotFoundException {

    public JewelNotFoundException(String id) {
        super("Jewel with id " + id + " is not found.");
    }
}
