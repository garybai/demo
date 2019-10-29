package com.example.dynamicdatasourcedemo.service;

import com.example.dynamicdatasourcedemo.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUser();

    int insertUser(String username, String password, Integer isForbidden);

}
