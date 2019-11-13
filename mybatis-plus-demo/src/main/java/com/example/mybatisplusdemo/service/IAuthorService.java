package com.example.mybatisplusdemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mybatisplusdemo.domain.AuthorDO;

import java.util.List;

public interface IAuthorService extends IService<AuthorDO> {

    List<AuthorDO> findAuthorByName(String name);
}
