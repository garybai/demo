package com.example.springsecuritywebfluxdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 角色
 *
 * @author Gary
 * @date 2019/12/16 14:21
 * @since jdk1.8
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Role implements Serializable {

    private Long id;
    private String name;

}
