package com.example.praticaintegradora9.controller;

import com.example.praticaintegradora9.service.Service;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/conversor")
@AllArgsConstructor
public class MyController {

    public final Service service;

    @GetMapping("{value}")
    public ResponseEntity<?> get(@PathVariable String value) {
        return ResponseEntity.ok(service.execute(value));
    }

}
