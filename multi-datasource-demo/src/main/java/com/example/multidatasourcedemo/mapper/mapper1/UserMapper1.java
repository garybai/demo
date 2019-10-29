package com.example.multidatasourcedemo.mapper.mapper1;

import com.example.multidatasourcedemo.model.User;

import java.util.List;


public interface UserMapper1 {

    List<User> getAllUser();

    int insertUser(String username, String password, Integer isForbidden);
}
