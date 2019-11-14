package com.example.swaggerdemo.controller;

import com.example.swaggerdemo.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author Gary
 * @className UserController
 * @description TODO
 * @date 2019-11-13 14:22
 **/
@RestController
@RequestMapping("/user")
@Api(tags = "用户相关接口", description = "提供用户相关的Rest API")
public class UserController {

    @ApiOperation(value = "新增用户接口", notes = "根据 user 对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户实体", required = true, dataType = "User")
    @PostMapping("/add")
    public boolean addUser(@RequestBody User user) {
        return true;
    }

    @ApiOperation("通过id查找用户接口")
    @ApiImplicitParam(name = "id", value = "用户id", defaultValue = "1", required = true)
    @GetMapping("/find/{id}")
    public User findById(@PathVariable("id") int id) {
        User user = new User();
        user.setId(id);
        user.setName("aaa");
        user.setAddress("address");
        return user;
    }

    @ApiOperation("更新用户信息接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "用户实体", required = true, dataType = "User"),
            @ApiImplicitParam(name = "name", value = "名称", defaultValue = "张三",required = true, dataType = "String")
    })
    @PutMapping("/update")
    public boolean update(@RequestBody User user, @RequestParam String name) {
        return true;
    }

    @ApiOperation("删除用户接口")
    @DeleteMapping("/delete/{id}")
    @ApiIgnore
    public boolean delete(@PathVariable("id") int id) {
        return true;
    }
}
