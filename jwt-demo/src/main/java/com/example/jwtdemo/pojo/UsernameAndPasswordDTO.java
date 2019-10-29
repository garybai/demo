package com.example.jwtdemo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.apache.ibatis.type.Alias;

/**
 * @author Gary
 * @className UsernameAndPasswordDTO
 * @description TODO
 * @date 2019-09-08 17:04
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Alias(value = "usernameAndPasswordDTO")
public class UsernameAndPasswordDTO {

    private String username;

    private String password;

}
