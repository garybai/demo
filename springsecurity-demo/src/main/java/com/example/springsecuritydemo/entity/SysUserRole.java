package com.example.springsecuritydemo.entity;

/**
 * @author Gary
 * @className SysUserRole
 * @description TODO
 * @date 2019-09-14 23:41
 **/
public class SysUserRole {

    static final long serialVersionUID = 1L;

    private Integer userId;

    private Integer roleId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
