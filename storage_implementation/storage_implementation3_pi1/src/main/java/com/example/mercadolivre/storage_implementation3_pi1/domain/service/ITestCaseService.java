package com.example.mercadolivre.storage_implementation3_pi1.domain.service;

import com.example.mercadolivre.storage_implementation3_pi1.domain.model.TestCase;
import com.example.mercadolivre.storage_implementation3_pi1.domain.model.filter.TestCaseFilter;

import java.util.List;

public interface ITestCaseService {
    TestCase save(TestCase model);
    TestCase find(String id);
    List<TestCase> findAll(TestCaseFilter testCaseFilter);
    void delete(String id);
}
