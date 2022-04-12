package com.example.mercadolivre.storage_implementation3_pi3.domain.service.impl;

import com.example.mercadolivre.storage_implementation3_pi3.domain.exception.SeasonNotFoundException;
import com.example.mercadolivre.storage_implementation3_pi3.domain.model.Season;
import com.example.mercadolivre.storage_implementation3_pi3.domain.repository.ISeasonRepository;
import com.example.mercadolivre.storage_implementation3_pi3.domain.service.ISeasonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SeasonServiceImpl implements ISeasonService {

    private final ISeasonRepository repository;

    @Override
    public Season save(Season season) {
        return repository.save(season);
    }

    @Override
    public Season findById(Integer id) {
        return repository.findById(id).orElseThrow( () -> new SeasonNotFoundException(id));
    }

    @Override
    public List<Season> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        repository.findById(id).orElseThrow( () -> new SeasonNotFoundException(id));
        repository.deleteById(id);
    }
}
