package com.example.springsecuritywebfluxdemo.service;

import com.example.springsecuritywebfluxdemo.model.Authority;

import java.util.List;

public interface IAuthorityService {

    List<Authority> selectByRoleIdList(List<Long> roleIds);

}
