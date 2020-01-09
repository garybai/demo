package com.example.springsecuritywebfluxdemo.service;

import com.example.springsecuritywebfluxdemo.model.User;

import java.util.Optional;

public interface IUserService {

    Optional<User> findByUsername(String username);

}
