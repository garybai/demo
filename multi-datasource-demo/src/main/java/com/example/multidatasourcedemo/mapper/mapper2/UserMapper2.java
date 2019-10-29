package com.example.multidatasourcedemo.mapper.mapper2;

import com.example.multidatasourcedemo.model.User;

import java.util.List;


public interface UserMapper2 {

    List<User> getAllUser();

    int insertUser(String username, String password, Integer isForbidden);
}
