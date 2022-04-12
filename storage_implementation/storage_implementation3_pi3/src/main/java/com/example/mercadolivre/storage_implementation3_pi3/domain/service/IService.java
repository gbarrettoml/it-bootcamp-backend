package com.example.mercadolivre.storage_implementation3_pi3.domain.service;

import java.util.List;

public interface IService <U>{

    U save(U u);
    U findById(Integer id);
    List<U> findAll();
    void deleteById(Integer id);

}
