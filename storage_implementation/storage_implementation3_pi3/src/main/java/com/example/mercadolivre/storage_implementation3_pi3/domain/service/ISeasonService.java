package com.example.mercadolivre.storage_implementation3_pi3.domain.service;



import com.example.mercadolivre.storage_implementation3_pi3.domain.model.Season;

import java.util.List;

public interface ISeasonService {
    Season save(Season season);
    Season findById(Integer id);
    List<Season> findAll();
    void deleteById(Integer id);
}
