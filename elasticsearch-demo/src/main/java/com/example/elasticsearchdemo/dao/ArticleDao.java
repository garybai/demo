package com.example.elasticsearchdemo.dao;

import com.example.elasticsearchdemo.model.ArticlePO;

import java.util.List;

public interface ArticleDao {

    /**
     * 获取所有文章
     *
     * @author Gary
     * @param
     *
     * @return java.util.List<com.example.elasticsearchdemo.pojo.ArticlePO>
     * @date 2019-07-05 15:30
     */
    List<ArticlePO> getAll();

}
