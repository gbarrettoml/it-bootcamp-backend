package com.itbootcampmercadolivre.praticaintegradora12.controller;

import com.itbootcampmercadolivre.praticaintegradora12.dto.PersonDto;
import com.itbootcampmercadolivre.praticaintegradora12.service.Service;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("findSport")
@AllArgsConstructor
public class PersonController {

    private final Service service;

    @PostMapping
    public ResponseEntity<?> create(PersonDto personDto) {
        Boolean created = service.createRequest(personDto);
        return created ? ResponseEntity
                .created(URI.create("/findSports/{id}"))
                .body("Atleta criado com sucesso.") :
                ResponseEntity
                        .internalServerError()
                        .body("Falha na criação do atleta.");
    }

    @GetMapping()
    public ResponseEntity<?> findSports() {
        return ResponseEntity.ok(service.sportsList());
    }

}
