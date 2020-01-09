package com.example.springsecuritywebfluxdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 权限表
 *
 * @author Gary
 * @date 2019/12/16 14:23
 * @since jdk1.8
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Authority implements Serializable {

    private Long id;
    private String name;
    private String resource;

}
