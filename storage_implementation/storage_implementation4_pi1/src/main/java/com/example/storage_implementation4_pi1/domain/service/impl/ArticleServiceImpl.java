package com.example.storage_implementation4_pi1.domain.service.impl;

import com.example.storage_implementation4_pi1.domain.model.Article;
import com.example.storage_implementation4_pi1.domain.repository.ArticleInterface;
import com.example.storage_implementation4_pi1.domain.service.IArticleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ArticleServiceImpl implements IArticleService {

    private final ArticleInterface repository;

    @Override
    public Article save(Article article) {
        return repository.save(article);
    }

    @Override
    public Iterable<Article> getAll() {
        return repository.findAll();
    }
}
