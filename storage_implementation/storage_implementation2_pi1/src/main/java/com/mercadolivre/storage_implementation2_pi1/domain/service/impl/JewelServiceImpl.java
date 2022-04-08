package com.mercadolivre.storage_implementation2_pi1.domain.service.impl;

import com.mercadolivre.storage_implementation2_pi1.domain.exception.JewelNotFoundException;
import com.mercadolivre.storage_implementation2_pi1.domain.model.Jewel;
import com.mercadolivre.storage_implementation2_pi1.domain.repository.IJewelRepository;
import com.mercadolivre.storage_implementation2_pi1.domain.service.IJewelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JewelServiceImpl implements IJewelService {

    @Autowired
    private IJewelRepository repository;

    @Override
    public Jewel save(Jewel jewel) {
        return repository.save(jewel);
    }

    @Override
    public Jewel findById(String id) {
        return repository.findById(id).orElseThrow( () -> new JewelNotFoundException(id));
    }

    @Override
    public List<Jewel> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(String id) {
        repository.findById(id).orElseThrow( () -> new JewelNotFoundException(id));
        repository.deleteById(id);
    }
}
