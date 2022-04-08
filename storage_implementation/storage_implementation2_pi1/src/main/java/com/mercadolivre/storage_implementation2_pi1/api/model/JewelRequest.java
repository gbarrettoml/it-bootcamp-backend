package com.mercadolivre.storage_implementation2_pi1.api.model;

import com.mercadolivre.storage_implementation2_pi1.domain.model.Material;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JewelRequest {

    String id;
    Material material;
    Double weight;
    Integer carat;
}
