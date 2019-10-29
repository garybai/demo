package com.example.multidatasourcedemo.model;

import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * @author Gary
 * @className User
 * @description TODO
 * @date 2019-10-28 15:11
 **/
@Data
@Alias(value = "user")
public class User {
    private Long usId;
    private String usUsername;
    private String usPassword;
    private String usIsForbidden;
}
