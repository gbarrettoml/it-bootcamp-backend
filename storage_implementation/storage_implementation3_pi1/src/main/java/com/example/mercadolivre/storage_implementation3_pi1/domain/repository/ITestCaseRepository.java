package com.example.mercadolivre.storage_implementation3_pi1.domain.repository;

import com.example.mercadolivre.storage_implementation3_pi1.domain.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITestCaseRepository extends JpaRepository<TestCase, String> {
}
