package com.example.springsecuritywebfluxdemo.service.impl;

import com.example.springsecuritywebfluxdemo.model.User;
import com.example.springsecuritywebfluxdemo.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * UserService
 *
 * @author Gary
 * @date 2019/12/16 14:29
 * @since jdk1.8
 **/
@Service
public class UserServiceImpl implements IUserService {
    @Override
    public Optional<User> findByUsername(String username) {
        if ("admin".equalsIgnoreCase(username)){
            User user = new User().setId(1L).setUsername(username).setStatus(1).setPassword("$2a$10$k1NWTPKqcBDqcQvron.W/OIualVvWOGqkEKmuxyZfs1KsUXsYIYlu");
            return Optional.of(user);
        }
        if ("user".equalsIgnoreCase(username)){
            User user = new User().setId(2L).setUsername(username).setStatus(0).setPassword("$2a$10$k1NWTPKqcBDqcQvron.W/OIualVvWOGqkEKmuxyZfs1KsUXsYIYlu");
            return Optional.of(user);
        }
        return Optional.empty();
    }
}
