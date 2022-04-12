package com.example.mercadolivre.storage_implementation3_pi3.domain.service.impl;

import com.example.mercadolivre.storage_implementation3_pi3.domain.exception.EpisodeNotFoundException;
import com.example.mercadolivre.storage_implementation3_pi3.domain.model.Episode;
import com.example.mercadolivre.storage_implementation3_pi3.domain.repository.IEpisodeRepository;
import com.example.mercadolivre.storage_implementation3_pi3.domain.service.IEpisodeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EpisodeRepositoryImpl implements IEpisodeService {

    private final IEpisodeRepository repository;

    @Override
    public Episode save(Episode episode) {
        return repository.save(episode);
    }

    @Override
    public Episode findById(Integer id) {
        return repository.findById(id).orElseThrow( () -> new EpisodeNotFoundException(id));
    }

    @Override
    public List<Episode> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        repository.findById(id).orElseThrow( () -> new EpisodeNotFoundException(id));
        repository.deleteById(id);
    }
}
