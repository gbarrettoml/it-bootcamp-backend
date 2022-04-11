package com.example.mercadolivre.storage_implementation3_pi1.api.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TestCaseResponse {

    private String id;
    private String description;
    private Boolean tested;
    private Boolean passed;
    private Integer number_of_tries;
    private String last_update;
}
