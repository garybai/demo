package com.example.springsecuritydynamicdemo.mapper;

import com.example.springsecuritydynamicdemo.entity.AuthorityPO;

import java.util.List;

public interface AuthorityMapper {

    List<AuthorityPO> getAllAuthority();
}
