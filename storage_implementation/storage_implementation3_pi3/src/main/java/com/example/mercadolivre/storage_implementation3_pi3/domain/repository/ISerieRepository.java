package com.example.mercadolivre.storage_implementation3_pi3.domain.repository;

import com.example.mercadolivre.storage_implementation3_pi3.domain.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISerieRepository extends JpaRepository<Serie, Integer> {
}
