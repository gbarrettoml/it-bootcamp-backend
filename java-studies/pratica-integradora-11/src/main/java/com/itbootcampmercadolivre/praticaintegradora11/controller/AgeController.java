package com.itbootcampmercadolivre.praticaintegradora11.controller;

import com.itbootcampmercadolivre.praticaintegradora11.service.AgeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@AllArgsConstructor
public class AgeController {

    private final AgeService service;

    @GetMapping("{day}/{month}/{year}")
    public ResponseEntity<?> calculate(@PathVariable Integer day,
                                       @PathVariable Integer month,
                                       @PathVariable Integer year) {

        return ResponseEntity.ok("A idade dessa pessoa : " + service.calculateAge(day, month, year));
    }

}
