package com.example.dynamicdatasourcedemo.mapper;

import com.example.dynamicdatasourcedemo.model.User;

import java.util.List;


public interface UserMapper {

    List<User> getAllUser();

    int insertUser(String username, String password, Integer isForbidden);
}
