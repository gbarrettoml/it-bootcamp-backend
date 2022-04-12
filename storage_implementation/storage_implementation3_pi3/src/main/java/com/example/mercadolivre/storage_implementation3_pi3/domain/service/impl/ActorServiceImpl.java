package com.example.mercadolivre.storage_implementation3_pi3.domain.service.impl;

import com.example.mercadolivre.storage_implementation3_pi3.domain.exception.ActorNotFoundException;
import com.example.mercadolivre.storage_implementation3_pi3.domain.model.Actor;
import com.example.mercadolivre.storage_implementation3_pi3.domain.model.Episode;
import com.example.mercadolivre.storage_implementation3_pi3.domain.model.Movie;
import com.example.mercadolivre.storage_implementation3_pi3.domain.repository.IActorRepository;
import com.example.mercadolivre.storage_implementation3_pi3.domain.repository.IEpisodeRepository;
import com.example.mercadolivre.storage_implementation3_pi3.domain.repository.IMovieRepository;
import com.example.mercadolivre.storage_implementation3_pi3.domain.service.IActorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ActorServiceImpl implements IActorService {

    private final IActorRepository repository;
    private final IMovieRepository movieRepository;
    private final IEpisodeRepository episodeRepository;

    @Override
    public Actor save(Actor actor) {

        // Checking if actor already exists in database
        Actor first_name = repository.findByFirstName(actor.getFirstName());
        Actor last_name = repository.findByLastName(actor.getLastName());

        if (
                first_name.getFirstName().equalsIgnoreCase(actor.getFirstName())
                && last_name.getLastName().equalsIgnoreCase(actor.getLastName())
        ) {
            actor.setId(first_name.getId());
        }

        actor.setMovies(
                actor.getMovies()
                        .stream()
                        .map(movie -> {
                            Movie m = movieRepository.findByTitle(movie.getTitle()); // checking if already exists the movie
                            if(m != null) {
                                m.getActors().add(actor);
                                return m;
                            }

                            movie.getActors().add(actor);
                            return movie;
                        }).collect(Collectors.toSet()));

        actor.setEpisodes(
                actor.getEpisodes()
                        .stream()
                        .map(episode -> {
                            Episode e = episodeRepository.findByTitle(episode.getTitle()); // checking if already exists the episode
                            if(e != null) {
                                e.getActors().add(actor);
                                return e;
                            }

                            episode.getActors().add(actor);
                            return episode;
                        }).collect(Collectors.toSet()));

        return repository.save(actor);
    }

    @Override
    public Actor findById(Integer id) {
        return repository.findById(id).orElseThrow( () -> new ActorNotFoundException(id));
    }

    @Override
    public List<Actor> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        repository.findById(id).orElseThrow( () -> new ActorNotFoundException(id));
        repository.deleteById(id);
    }
}
