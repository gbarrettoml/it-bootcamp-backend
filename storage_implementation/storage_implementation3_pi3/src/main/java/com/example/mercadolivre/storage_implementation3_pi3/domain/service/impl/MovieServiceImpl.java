package com.example.mercadolivre.storage_implementation3_pi3.domain.service.impl;

import com.example.mercadolivre.storage_implementation3_pi3.domain.exception.MovieNotFoundException;
import com.example.mercadolivre.storage_implementation3_pi3.domain.model.Actor;
import com.example.mercadolivre.storage_implementation3_pi3.domain.model.Movie;
import com.example.mercadolivre.storage_implementation3_pi3.domain.repository.IActorRepository;
import com.example.mercadolivre.storage_implementation3_pi3.domain.repository.IGenreRepository;
import com.example.mercadolivre.storage_implementation3_pi3.domain.repository.IMovieRepository;
import com.example.mercadolivre.storage_implementation3_pi3.domain.service.IMovieService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements IMovieService {

    private final IMovieRepository repository;
    private final IActorRepository actorRepository;
    private final IGenreRepository genreRepository;

    @Override
    public Movie save(Movie movie) {

        if(repository.findByTitle(movie.getTitle()) != null) {
            movie.setId(repository.findByTitle(movie.getTitle()).getId());
        }

        if(genreRepository.findByName(movie.getGenre().getName()) != null) {
            movie.setGenre(genreRepository.findByName(movie.getGenre().getName()));
        }

        movie.setActors(movie.getActors()
                .stream()
                .map(actor -> {
                    if(actorAlreadyExists(actor)) {
                        Actor a = actorRepository.findByLastName(actor.getLastName());
                        a.getMovies().add(movie);
                        return a;
                    }
                    actor.getMovies().add(movie);
                    return actor;
                }).collect(Collectors.toSet())
        );


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

    private Boolean actorAlreadyExists(Actor actor) {
        Actor aName = actorRepository.findByFirstName(actor.getFirstName());
        Actor lName = actorRepository.findByLastName(actor.getLastName());
        if(
                actor.getFirstName().equalsIgnoreCase(aName.getFirstName())
                && actor.getLastName().equalsIgnoreCase(lName.getLastName())
                && aName.getId().equals(lName.getId())
        ) {
            return true;
        } else {
            return false;
        }
    }
}
