package com.example.mybatisplusdemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mybatisplusdemo.domain.AuthorDO;
import com.example.mybatisplusdemo.mapper.AuthorMapper;
import com.example.mybatisplusdemo.service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Gary
 * @className AuthorServiceImpl
 * @description TODO
 * @date 2019-11-11 16:16
 **/
@Service
public class AuthorServiceImpl extends ServiceImpl<AuthorMapper, AuthorDO> implements IAuthorService {

    @Autowired
    AuthorMapper authorMapper;

    @Override
    public List<AuthorDO> findAuthorByName(String name) {
        return authorMapper.findAuthorByName(name);
    }
}
