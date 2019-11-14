package com.example.swaggerdemo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Gary
 * @className User
 * @description TODO
 * @date 2019-11-13 14:20
 **/
@ApiModel(value = "User")
@Data
public class User {

    /**
     * 用户Id
     */
    @ApiModelProperty("用户id")
    private int id;

    /**
     * 用户名
     */
    @ApiModelProperty("用户姓名")
    private String name;


    /**
     * 用户地址
     */
    @ApiModelProperty("用户地址")
    private String address;

}
