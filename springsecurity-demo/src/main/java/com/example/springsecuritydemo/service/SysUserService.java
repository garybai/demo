package com.example.springsecuritydemo.service;

import com.example.springsecuritydemo.entity.SysUser;
import com.example.springsecuritydemo.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Gary
 * @className SysUserService
 * @description TODO
 * @date 2019-09-14 23:53
 **/
@Service
public class SysUserService {

    @Autowired
    private SysUserMapper userMapper;

    public SysUser selectById(Integer id) {
        return userMapper.selectById(id);
    }

    public SysUser selectByName(String name) {
        return userMapper.selectByName(name);
    }
}
