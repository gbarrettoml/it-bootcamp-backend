package com.example.mercadolivre.storage_implementation3_pi3.domain.service.impl;

import com.example.mercadolivre.storage_implementation3_pi3.domain.exception.MovieNotFoundException;
import com.example.mercadolivre.storage_implementation3_pi3.domain.model.Movie;
import com.example.mercadolivre.storage_implementation3_pi3.domain.repository.IMovieRepository;
import com.example.mercadolivre.storage_implementation3_pi3.domain.service.IService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements IService<Movie> {

    private final IMovieRepository repository;


    @Override
    public Movie save(Movie movie) {

        if(repository.findByTitle(movie.getTitle()) != null) {
            movie.setId(repository.findByTitle(movie.getTitle()).getId());
        }

        movie.setActors(movie.getActors()
                .stream()
                .map(actor -> {
                    a
                }));



        return repository.save(movie);
    }

    @Override
    public Movie findById(Integer id) {
        return repository.findById(id).orElseThrow( () -> new MovieNotFoundException(id));
    }

    @Override
    public List<Movie> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        repository.findById(id).orElseThrow( () -> new MovieNotFoundException(id));
        repository.deleteById(id);
    }
}
