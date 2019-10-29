package com.example.multidatasourcedemo.service;

import com.example.multidatasourcedemo.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUser1();

    List<User> getAllUser2();

}
