package com.example.springsecuritywebfluxdemo.service.impl;

import com.example.springsecuritywebfluxdemo.model.Role;
import com.example.springsecuritywebfluxdemo.service.IRoleService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * RoleService
 *
 * @author Gary
 * @date 2019/12/16 14:35
 * @since jdk1.8
 **/
@Service
public class RoleServiceImpl implements IRoleService {
    @Override
    public List<Role> selectByUserId(Long userId) {
        if (userId == 1) {
            List<Role> list = new ArrayList<>();
            list.add(new Role().setId(1L).setName("hello"));
            return list;
        }
        if (userId == 2) {
            List<Role> list = new ArrayList<>();
            list.add(new Role().setId(1L).setName("user"));
            return list;
        }
        return null;
    }
}
