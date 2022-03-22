package com.mercadolivre.bootcamp.praticaintegradora13.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Person {

    private String name;
    private String height;
    private String mass;

    @JsonIgnore
    private String hairColor;
    @JsonIgnore
    private String skinColor;
    @JsonIgnore
    private String eyeColor;
    @JsonIgnore
    private String birthYear;
    private String gender;
    private String homeworld;
    private String species;

}
