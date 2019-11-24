package com.example.springsecuritydynamicdemo.entity;

import lombok.Data;

import java.util.List;

/**
 * @author Gary
 * @className AuthorityPO
 * @description TODO
 * @date 2019/11/23 11:10
 **/
@Data
public class AuthorityPO {

    private Integer id;

    private String name;

    private String resource;

    private List<RolePO> roles;

}
