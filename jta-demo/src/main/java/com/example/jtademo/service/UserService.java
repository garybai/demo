package com.example.jtademo.service;

import com.example.jtademo.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUser1();

    List<User> getAllUser2();

    int insertUser1(String username, String password, Integer isForbidden);

    int insertUser2(String username, String password, Integer isForbidden);

    int insertUser12(String username, String password, Integer isForbidden);

}
