package com.mercadolivre.storage_implementation2_pi1.domain.repository;

import com.mercadolivre.storage_implementation2_pi1.domain.model.Jewel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJewelRepository extends JpaRepository<Jewel, String> {
}
