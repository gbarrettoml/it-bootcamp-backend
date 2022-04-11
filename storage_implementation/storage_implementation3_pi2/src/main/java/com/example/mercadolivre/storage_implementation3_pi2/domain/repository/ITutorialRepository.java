package com.example.mercadolivre.storage_implementation3_pi2.domain.repository;

import com.example.mercadolivre.storage_implementation3_pi2.domain.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITutorialRepository extends JpaRepository<Tutorial, String> {

    List<Tutorial> findAllByPublished(Boolean status);
}
