package com.example.mercadolivre.storage_implementation3_pi3.domain.repository;

import com.example.mercadolivre.storage_implementation3_pi3.domain.model.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISeasonRepository extends JpaRepository<Season, Integer> {
}
