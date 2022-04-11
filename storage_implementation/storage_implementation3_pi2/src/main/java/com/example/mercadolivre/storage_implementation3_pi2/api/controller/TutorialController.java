package com.example.mercadolivre.storage_implementation3_pi2.api.controller;

import com.example.mercadolivre.storage_implementation3_pi2.api.assembler.TutorialAssembler;
import com.example.mercadolivre.storage_implementation3_pi2.api.model.TutorialRequest;
import com.example.mercadolivre.storage_implementation3_pi2.api.model.TutorialResponse;
import com.example.mercadolivre.storage_implementation3_pi2.domain.service.ITutorialService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/tutorials")
@AllArgsConstructor
public class TutorialController {

    private final ITutorialService service;
    private final TutorialAssembler mapper;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody TutorialRequest requestObj) {
        TutorialResponse responseObj = mapper.toResponseObject(service.save(mapper.toDomainObject(requestObj)));
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Location", responseObj.getId())
                .build();
    }

    @GetMapping
    public ResponseEntity<List<TutorialResponse>> findAll(@RequestParam(required = false) String title) {
        return ResponseEntity.ok(
                service.findAll(title)
                        .stream()
                        .map(tutorial -> mapper.toResponseObject(tutorial))
                        .collect(Collectors.toList())
        );
    }

    @GetMapping("{id}")
    public ResponseEntity<TutorialResponse> findById(@PathVariable String id) {
        return ResponseEntity.ok(
               mapper.toResponseObject(service.findById(id))
        );
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@RequestBody TutorialRequest requestObj, @PathVariable String id) {
        requestObj.setId(id);
        TutorialResponse responseObj = mapper.toResponseObject(service.save(mapper.toDomainObject(requestObj)));
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("Location", responseObj.getId())
                .build();
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAll() {
        service.deleteAll();
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();

    }

    @GetMapping("published")
    public ResponseEntity<List<TutorialResponse>> findAllPublished() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(
                        service.findAllPublished()
                                .stream()
                                .map(tutorial -> mapper.toResponseObject(tutorial))
                                .collect(Collectors.toList())
                );
    }
}
