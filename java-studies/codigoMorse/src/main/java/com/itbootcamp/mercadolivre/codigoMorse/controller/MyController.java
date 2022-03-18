package com.itbootcamp.mercadolivre.codigoMorse.controller;

import com.itbootcamp.mercadolivre.codigoMorse.service.MyService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Locale;

@Controller
@AllArgsConstructor
public class MyController {

    public final MyService service;

    @GetMapping("/converter")
    public ResponseEntity<?> conversor(@RequestBody String phrase) {
        return ResponseEntity.ok(service.execute(phrase.toUpperCase(Locale.ROOT)));
    }
}
