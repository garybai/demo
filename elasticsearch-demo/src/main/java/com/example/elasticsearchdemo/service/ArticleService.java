package com.example.elasticsearchdemo.service;

import com.example.elasticsearchdemo.model.ArticlePO;

import java.util.List;

public interface ArticleService {

    List<ArticlePO> getAll();

    List<ArticlePO> query();

}
