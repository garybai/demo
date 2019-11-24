package com.example.springsecuritydynamicdemo.service;

import com.example.springsecuritydynamicdemo.entity.AuthorityPO;
import com.example.springsecuritydynamicdemo.mapper.AuthorityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Gary
 * @className AuthorityService
 * @description TODO
 * @date 2019/11/23 14:24
 **/
@Service
public class AuthorityService {

    @Autowired
    AuthorityMapper authorityMapper;

    public List<AuthorityPO> getAllAuthority(){
        return authorityMapper.getAllAuthority();
    }
}
