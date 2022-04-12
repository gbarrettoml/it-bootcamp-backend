package com.example.mercadolivre.storage_implementation3_pi3.domain.service;

import com.example.mercadolivre.storage_implementation3_pi3.domain.model.Actor;
import com.example.mercadolivre.storage_implementation3_pi3.domain.model.Movie;

import java.util.List;

public interface IMovieService {
    Movie save(Movie movie);
    Movie findById(Integer id);
    List<Movie> findAll();
    void deleteById(Integer id);
}
