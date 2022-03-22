package com.mercadolivre.bootcamp.praticaintegradora13.controller;

import com.mercadolivre.bootcamp.praticaintegradora13.service.QueryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class MyController {

    private final QueryService service;

    @GetMapping("query/{name}")
    public ResponseEntity<?> query(@PathVariable String name) {
        return ResponseEntity.ok(service.character(name));
    }
}
