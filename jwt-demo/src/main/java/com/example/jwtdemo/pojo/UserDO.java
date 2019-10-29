package com.example.jwtdemo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

/**
 * @author Gary
 * @className UserDO
 * @description TODO
 * @date 2019-09-08 10:00
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("userDO")
public class UserDO {

    private Long id;

    private String username;

    private String password;

    private Integer forbidden;

}
