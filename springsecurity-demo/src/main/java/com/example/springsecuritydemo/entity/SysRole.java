package com.example.springsecuritydemo.entity;

import java.io.Serializable;

/**
 * @author Gary
 * @className SysRole
 * @description TODO
 * @date 2019-09-14 23:41
 **/
public class SysRole implements Serializable {

    static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
