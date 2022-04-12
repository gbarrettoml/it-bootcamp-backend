package com.example.mercadolivre.storage_implementation3_pi3.domain.service;

import com.example.mercadolivre.storage_implementation3_pi3.domain.model.Actor;

import java.util.List;

public interface IActorService {
    Actor save(Actor actor);
    Actor findById(Integer id);
    List<Actor> findAll();
    void deleteById(Integer id);
}
