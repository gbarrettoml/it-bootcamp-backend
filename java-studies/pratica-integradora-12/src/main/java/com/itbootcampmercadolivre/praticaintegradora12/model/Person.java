package com.itbootcampmercadolivre.praticaintegradora12.model;

import com.itbootcampmercadolivre.praticaintegradora12.dto.PersonDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String name;
    private String surname;
    private int age;
    private Sport sport;

    public Person (PersonDto personDto) {
        this.name = personDto.getName();
        this.surname = personDto.getSurname();
        this.age = personDto.getAge();
        this.sport = new Sport(personDto.getSportDto());
    }
}
