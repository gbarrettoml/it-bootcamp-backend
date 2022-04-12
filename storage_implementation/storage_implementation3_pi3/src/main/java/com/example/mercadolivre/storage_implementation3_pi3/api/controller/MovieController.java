package com.example.mercadolivre.storage_implementation3_pi3.api.controller;

import com.example.mercadolivre.storage_implementation3_pi3.api.assembler.MovieAssembler;
import com.example.mercadolivre.storage_implementation3_pi3.api.model.movie.MovieRequest;
import com.example.mercadolivre.storage_implementation3_pi3.api.model.movie.MovieResponse;
import com.example.mercadolivre.storage_implementation3_pi3.domain.service.IMovieService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("movies")
@AllArgsConstructor
public class MovieController {

    private final IMovieService service;
    private final MovieAssembler mapper;

    @PostMapping
    ResponseEntity<?> save(@RequestBody MovieRequest movieRequest) {
        MovieResponse objectResponse = mapper.toResponseObject(service.save(mapper.toDomainObject(movieRequest)));
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Location", "http://localhost:8080/movies/" + objectResponse.getId())
                .build();
    }

    @GetMapping("{id}")
    ResponseEntity<MovieResponse> get(@PathVariable Integer id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(mapper.toResponseObject(service.findById(id)));
    }

    @GetMapping
    ResponseEntity<List<MovieResponse>> getAll() {
        List<MovieResponse> list = service.findAll()
                .stream()
                .map(movie -> {
                    return mapper.toResponseObject((movie));
                }).collect(Collectors.toList());

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(list);
    }

}
