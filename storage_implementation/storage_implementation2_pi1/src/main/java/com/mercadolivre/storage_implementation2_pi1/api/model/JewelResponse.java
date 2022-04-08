package com.mercadolivre.storage_implementation2_pi1.api.model;

import com.mercadolivre.storage_implementation2_pi1.domain.model.Material;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JewelResponse {

    private String id;
    private Material material;
    private Double weight;
    private Integer carat;
}
