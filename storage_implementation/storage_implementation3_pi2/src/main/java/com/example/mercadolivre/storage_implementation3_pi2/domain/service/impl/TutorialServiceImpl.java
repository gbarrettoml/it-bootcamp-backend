package com.example.mercadolivre.storage_implementation3_pi2.domain.service.impl;

import com.example.mercadolivre.storage_implementation3_pi2.domain.exception.TutorialNotFoundException;
import com.example.mercadolivre.storage_implementation3_pi2.domain.model.Tutorial;
import com.example.mercadolivre.storage_implementation3_pi2.domain.repository.ITutorialRepository;
import com.example.mercadolivre.storage_implementation3_pi2.domain.service.ITutorialService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TutorialServiceImpl implements ITutorialService {

    private final ITutorialRepository repository;

    @Override
    public Tutorial save(Tutorial entity) {
        return repository.save(entity);
    }

    @Override
    public Tutorial findById(String id) {
        return repository.findById(id).orElseThrow( () -> new TutorialNotFoundException(id));
    }

    @Override
    public List<Tutorial> findAll(String title) {
        if(title != null) return repository.findAll()
                .stream()
                .filter(tutorial -> tutorial.getTitle().contains(title))
                .collect(Collectors.toList());
        return repository.findAll();
    }

    @Override
    public void delete(String id) {
        repository.findById(id).orElseThrow( () -> new TutorialNotFoundException(id));
        repository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public List<Tutorial> findAllPublished() {
        return repository.findAllByPublished(true);
    }
}
