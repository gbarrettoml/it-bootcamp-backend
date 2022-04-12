package com.example.mercadolivre.storage_implementation3_pi3.domain.service;

import com.example.mercadolivre.storage_implementation3_pi3.domain.model.Genre;

import java.util.List;

public interface IGenreService {
    Genre save(Genre genre);
    Genre findById(Integer id);
    List<Genre> findAll();
    void deleteById(Integer id);
}
