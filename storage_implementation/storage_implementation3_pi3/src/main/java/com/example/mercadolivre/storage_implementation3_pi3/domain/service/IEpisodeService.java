package com.example.mercadolivre.storage_implementation3_pi3.domain.service;

import com.example.mercadolivre.storage_implementation3_pi3.domain.model.Episode;

import java.util.List;

public interface IEpisodeService {
    Episode save(Episode episode);
    Episode findById(Integer id);
    List<Episode> findAll();
    void deleteById(Integer id);
}
