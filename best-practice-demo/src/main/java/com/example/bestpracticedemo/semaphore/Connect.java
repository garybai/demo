package com.example.bestpracticedemo.semaphore;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 数据库连接
 *
 * @author Gary
 * @date 2020/1/20 18:04
 * @since jdk1.8
 **/
@Data
@AllArgsConstructor
public class Connect {
    private String url;
    private String password;
    private Integer port;
}
