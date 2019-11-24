package com.example.springsecuritydynamicdemo.mapper;

import com.example.springsecuritydynamicdemo.entity.RolePO;
import com.example.springsecuritydynamicdemo.entity.UserPO;

import java.util.List;

public interface UserMapper {
    UserPO loadUserByUsername(String username);

    List<RolePO> getRolesById(Integer id);
}
