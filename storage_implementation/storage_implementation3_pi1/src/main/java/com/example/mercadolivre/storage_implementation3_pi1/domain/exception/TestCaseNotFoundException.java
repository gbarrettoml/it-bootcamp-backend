package com.example.mercadolivre.storage_implementation3_pi1.domain.exception;

import com.example.mercadolivre.storage_implementation3_pi1.infrastructure.exception.EntityNotFoundException;

public class TestCaseNotFoundException extends EntityNotFoundException {

    public TestCaseNotFoundException(String id) {
        super("TestCase with id " + id + " is not found.");
    }


}
