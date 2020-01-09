package com.example.springsecuritywebfluxdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 用户表
 *
 * @author Gary
 * @date 2019/12/16 14:19
 * @since jdk1.8
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class User implements Serializable {

    private Long id;
    private String username;
    private String password;
    private Integer status;

}
