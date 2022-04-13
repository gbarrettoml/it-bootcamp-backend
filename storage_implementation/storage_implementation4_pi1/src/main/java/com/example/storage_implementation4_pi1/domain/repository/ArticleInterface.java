package com.example.storage_implementation4_pi1.domain.repository;

import com.example.storage_implementation4_pi1.domain.model.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ArticleInterface extends ElasticsearchRepository<Article, Integer> {
}
