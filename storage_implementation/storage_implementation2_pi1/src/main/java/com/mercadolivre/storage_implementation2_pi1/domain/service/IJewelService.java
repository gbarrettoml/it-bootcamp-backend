package com.mercadolivre.storage_implementation2_pi1.domain.service;

import com.mercadolivre.storage_implementation2_pi1.domain.model.Jewel;

import java.util.List;

public interface IJewelService {
    Jewel save(Jewel jewel);
    Jewel findById(String id);
    List<Jewel> findAll();
    void delete(String id);
}
