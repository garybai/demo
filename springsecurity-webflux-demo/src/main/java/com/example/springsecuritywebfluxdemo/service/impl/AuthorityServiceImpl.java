package com.example.springsecuritywebfluxdemo.service.impl;

import com.example.springsecuritywebfluxdemo.model.Authority;
import com.example.springsecuritywebfluxdemo.service.IAuthorityService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * AuthorityService
 *
 * @author Gary
 * @date 2019/12/16 15:49
 * @since jdk1.8
 **/
@Service
public class AuthorityServiceImpl implements IAuthorityService {
    @Override
    public List<Authority> selectByRoleIdList(List<Long> roleIds) {
        System.out.println("111");
        List<Authority> list = new ArrayList<>();
        if (roleIds.contains(1L)) {
            list.add(new Authority().setId(1L).setName("hello").setResource("/hello"));
        }
        if (roleIds.contains(2L)) {
            list.add(new Authority().setId(2L).setName("user").setResource("/user"));
        }
        return list;
    }
}
