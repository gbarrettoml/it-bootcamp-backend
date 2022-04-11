package com.example.mercadolivre.storage_implementation3_pi2.domain.service;

import com.example.mercadolivre.storage_implementation3_pi2.domain.model.Tutorial;

import java.util.List;

public interface ITutorialService {

    Tutorial save(Tutorial entity);
    Tutorial findById(String id);
    List<Tutorial> findAll(String title);
    void delete(String id);
    void deleteAll();
    List<Tutorial> findAllPublished();
}
