package com.example.springsecuritydemo.service;

import com.example.springsecuritydemo.entity.SysUserRole;
import com.example.springsecuritydemo.mapper.SysUserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Gary
 * @className SysUserRoleService
 * @description TODO
 * @date 2019-09-14 23:48
 **/
@Service
public class SysUserRoleService {
    @Autowired
    private SysUserRoleMapper userRoleMapper;

    public List<SysUserRole> listByUserId(Integer userId) {
        return userRoleMapper.listByUserId(userId);
    }
}
