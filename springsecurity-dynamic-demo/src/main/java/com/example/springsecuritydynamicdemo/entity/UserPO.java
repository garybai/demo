package com.example.springsecuritydynamicdemo.entity;

import lombok.Data;

import java.util.List;

/**
 * @author Gary
 * @className UserPO
 * @description TODO
 * @date 2019/11/23 11:07
 **/
@Data
public class UserPO {

    private Integer id;

    private String username;

    private String password;

    private Boolean isEnabled;

    private Boolean isLocked;

    private List<RolePO> roles;

}
