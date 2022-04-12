package com.example.mercadolivre.storage_implementation3_pi3.domain.service.impl;

import com.example.mercadolivre.storage_implementation3_pi3.domain.exception.GenreNotFoundException;
import com.example.mercadolivre.storage_implementation3_pi3.domain.model.Genre;
import com.example.mercadolivre.storage_implementation3_pi3.domain.repository.IGenreRepository;
import com.example.mercadolivre.storage_implementation3_pi3.domain.service.IService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GenreServiceImpl implements IService<Genre> {

    private final IGenreRepository repository;

    @Override
    public Genre save(Genre genre) {
        return repository.save(genre);
    }

    @Override
    public Genre findById(Integer id) {
        return repository.findById(id).orElseThrow( () -> new GenreNotFoundException(id));
    }

    @Override
    public List<Genre> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        repository.findById(id).orElseThrow( () -> new GenreNotFoundException(id));
        repository.deleteById(id);
    }
}
