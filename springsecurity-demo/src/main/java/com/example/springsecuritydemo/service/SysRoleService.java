package com.example.springsecuritydemo.service;

import com.example.springsecuritydemo.entity.SysRole;
import com.example.springsecuritydemo.mapper.SysRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Gary
 * @className SysRoleService
 * @description TODO
 * @date 2019-09-14 23:47
 **/
@Service
public class SysRoleService {
    @Autowired
    private SysRoleMapper roleMapper;

    public SysRole selectById(Integer id) {
        return roleMapper.selectById(id);
    }
}
