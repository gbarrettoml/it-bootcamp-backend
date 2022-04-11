package com.example.mercadolivre.storage_implementation3_pi1.api.controller;

import com.example.mercadolivre.storage_implementation3_pi1.api.assembler.TestCaseAssembler;
import com.example.mercadolivre.storage_implementation3_pi1.api.model.TestCaseRequest;
import com.example.mercadolivre.storage_implementation3_pi1.api.model.TestCaseResponse;
import com.example.mercadolivre.storage_implementation3_pi1.domain.model.filter.TestCaseFilter;
import com.example.mercadolivre.storage_implementation3_pi1.domain.service.ITestCaseService;
import com.example.mercadolivre.storage_implementation3_pi1.domain.service.impl.TestCaseServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/testcases")
@AllArgsConstructor
public class TestCaseController {

    private final TestCaseAssembler mapper;
    private final ITestCaseService service;

    @PostMapping("new")
    public ResponseEntity<?> create(@RequestBody TestCaseRequest testCaseRequest) {
        TestCaseResponse obj = mapper.toResponseObject(service.save(mapper.toDomainObject(testCaseRequest)));
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Location", obj.getId())
                .build();
    }

    @GetMapping
    public ResponseEntity<List<TestCaseResponse>> getAll(TestCaseFilter testCaseFilter) {
        return ResponseEntity.ok(
                service.findAll(testCaseFilter)
                        .stream()
                        .map(obj -> {
                            return mapper.toResponseObject(obj);
                        }).collect(Collectors.toList())
        );
    }

    @GetMapping("{id}")
    public ResponseEntity<?> get(@PathVariable String id) {
        return ResponseEntity.ok(mapper.toResponseObject(service.find(id)));
    }

    @PutMapping("{id}")
    public ResponseEntity<?> update(@RequestBody TestCaseRequest testCaseRequest, @PathVariable String id) {
        testCaseRequest.setId(id);
        return ResponseEntity
                .ok()
                .header("Location", mapper.toResponseObject(service.save(mapper.toDomainObject(testCaseRequest))).getId())
                .build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity
                .ok()
                .build();
    }
}
