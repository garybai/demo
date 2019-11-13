package com.example.mybatisplusdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatisplusdemo.domain.AuthorDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AuthorMapper extends BaseMapper<AuthorDO> {

    List<AuthorDO> findAuthorByName(@Param("name") String name);
}


