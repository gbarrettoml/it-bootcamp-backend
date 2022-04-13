package com.example.storage_implementation4_pi1.domain.service;

import com.example.storage_implementation4_pi1.domain.model.Article;

public interface IArticleService {

    Article save(Article article);
    Iterable<Article> getAll();
}
