package com.example.springsecuritydemo.entity;

import java.io.Serializable;

/**
 * @author Gary
 * @className SysUser
 * @description TODO
 * @date 2019-09-14 23:40
 **/
public class SysUser implements Serializable {

    static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private String password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
