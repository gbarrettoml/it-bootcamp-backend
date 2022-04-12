package com.example.mercadolivre.storage_implementation3_pi3.domain.service;



import com.example.mercadolivre.storage_implementation3_pi3.domain.model.Serie;

import java.util.List;

public interface ISerieService {
    Serie save(Serie serie);
    Serie findById(Integer id);
    List<Serie> findAll();
    void deleteById(Integer id);
}
