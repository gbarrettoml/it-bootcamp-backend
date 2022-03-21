package com.itbootcampmercadolivre.praticaintegradora12.dto;

import com.itbootcampmercadolivre.praticaintegradora12.model.Person;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {
    private String name;
    private String surname;
    private int age;
    private SportDto sportDto;

}
