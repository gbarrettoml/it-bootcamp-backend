package com.example.mercadolivre.storage_implementation3_pi3.domain.repository;

import com.example.mercadolivre.storage_implementation3_pi3.domain.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IActorRepository extends JpaRepository<Actor, Integer> {

    Actor findByFirst_name(String first_name);
    Actor findyByLast_name(String last_name);
}
