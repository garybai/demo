package com.example.mybatisdruiddemo.mapper;

import com.example.mybatisdruiddemo.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> getAllUser();
}
