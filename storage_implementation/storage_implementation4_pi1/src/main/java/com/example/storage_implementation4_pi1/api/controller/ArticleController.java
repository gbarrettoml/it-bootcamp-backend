package com.example.storage_implementation4_pi1.api.controller;

import com.example.storage_implementation4_pi1.domain.model.Article;
import com.example.storage_implementation4_pi1.domain.service.impl.ArticleServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@AllArgsConstructor
public class ArticleController {

    private final ArticleServiceImpl service;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Article article) {
        Article a = service.save(article);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Location", "id " + a.getId())
                .build();
    }

    @GetMapping
    public ResponseEntity<Iterable<Article>> getAll() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getAll());
    }
}
