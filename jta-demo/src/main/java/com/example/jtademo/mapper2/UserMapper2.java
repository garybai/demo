package com.example.jtademo.mapper2;

import com.example.jtademo.model.User;

import java.util.List;


public interface UserMapper2 {

    List<User> getAllUser();

    int insertUser(String username, String password, Integer isForbidden);
}
