package com.example.mercadolivre.storage_implementation3_pi1.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestCaseRequest {

    private String id;
    private String description;
    private Boolean tested;
    private Boolean passed;
    private Integer number_of_tries;
}
