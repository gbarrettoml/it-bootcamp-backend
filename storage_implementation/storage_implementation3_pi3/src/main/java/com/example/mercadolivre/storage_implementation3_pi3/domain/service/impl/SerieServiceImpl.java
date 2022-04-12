package com.example.mercadolivre.storage_implementation3_pi3.domain.service.impl;

import com.example.mercadolivre.storage_implementation3_pi3.domain.exception.SerieNotFoundException;
import com.example.mercadolivre.storage_implementation3_pi3.domain.model.Serie;
import com.example.mercadolivre.storage_implementation3_pi3.domain.repository.ISerieRepository;
import com.example.mercadolivre.storage_implementation3_pi3.domain.service.IService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SerieServiceImpl implements IService<Serie> {

    private final ISerieRepository repository;

    @Override
    public Serie save(Serie serie) {
        return repository.save(serie);
    }

    @Override
    public Serie findById(Integer id) {
        return repository.findById(id).orElseThrow( () -> new SerieNotFoundException(id));
    }

    @Override
    public List<Serie> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        repository.findById(id).orElseThrow( () -> new SerieNotFoundException(id));
        repository.deleteById(id);
    }
}
