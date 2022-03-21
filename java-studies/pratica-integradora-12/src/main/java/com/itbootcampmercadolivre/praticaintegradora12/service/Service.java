package com.itbootcampmercadolivre.praticaintegradora12.service;

import com.itbootcampmercadolivre.praticaintegradora12.dto.PersonDto;
import com.itbootcampmercadolivre.praticaintegradora12.model.Person;
import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
@AllArgsConstructor
public class Service {

    private final Map<Integer, Person> personList = new HashMap<>();
    private Integer globalId = 1;

    public boolean createRequest(PersonDto personDto) {
        Person person = new Person(personDto);
        Person personCreated = personList.put(globalId, person);
        return personCreated != null;
    }

    public String response(Person person) {
        return "Nome: " + person.getName() +
                "\n Sobrenome: " + person.getSurname() +
                "\n Esporte: " + person.getSport().getName();

    }

    public List<String> sportsList() {
        List<String> sportsList = personList
                .values()
                .stream()
                .map( p -> p.getSport().getName())
                .collect(Collectors.toList());

        return sportsList;
    }
}
