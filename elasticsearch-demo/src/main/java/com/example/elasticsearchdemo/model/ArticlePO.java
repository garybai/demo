package com.example.elasticsearchdemo.model;

import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.ibatis.type.Alias;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

/**
 * @author Gary
 * @className ArticlePO
 * @description TODO
 * @date 2019-07-04 19:16
 **/
@Data
@Accessors(chain = true)
@Document(indexName = "article", type = "docs", shards = 1, replicas = 0)
@Alias("article")
public class ArticlePO implements Serializable {

    @Id
    private Long id;

    @Field(type = FieldType.Text, analyzer = "ik_smart")
    private String title;

    @Field(type = FieldType.Text, analyzer = "ik_smart")
    private String category;

    @Field(type = FieldType.Text, analyzer = "ik_smart")
    private String content;

    @Field(type = FieldType.Text, analyzer = "ik_smart")
    private String digest;


}
