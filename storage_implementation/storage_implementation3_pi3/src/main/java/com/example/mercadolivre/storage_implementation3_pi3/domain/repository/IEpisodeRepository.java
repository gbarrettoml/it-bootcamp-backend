package com.example.mercadolivre.storage_implementation3_pi3.domain.repository;

import com.example.mercadolivre.storage_implementation3_pi3.domain.model.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEpisodeRepository extends JpaRepository<Episode, Integer> {

    Episode findByTitle(String title);
}
