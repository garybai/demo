package com.example.elasticsearchdemo.dao;

import com.example.elasticsearchdemo.model.ArticlePO;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

@Component
public interface ArticleRepository extends ElasticsearchRepository<ArticlePO,Long> {
}
