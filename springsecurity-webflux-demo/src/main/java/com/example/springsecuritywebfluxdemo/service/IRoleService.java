package com.example.springsecuritywebfluxdemo.service;

import com.example.springsecuritywebfluxdemo.model.Role;

import java.util.List;

public interface IRoleService {

    List<Role> selectByUserId(Long userId);
}
