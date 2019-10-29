package com.example.elasticsearchdemo.service.impl;

import com.example.elasticsearchdemo.dao.ArticleDao;
import com.example.elasticsearchdemo.dao.ArticleRepository;
import com.example.elasticsearchdemo.model.ArticlePO;
import com.example.elasticsearchdemo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Gary
 * @className ArticleServiceImpl
 * @description TODO
 * @date 2019-07-05 15:44
 **/
@Service(value = "articleService")
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public List<ArticlePO> getAll() {
        return articleDao.getAll();
    }

    @Override
    public List<ArticlePO> query() {
        return null;
    }
}
