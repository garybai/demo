package com.example.swaggerdemo.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.swaggerdemo.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Gary
 * @className UserController
 * @description TODO
 * @date 2019-11-13 14:22
 **/
@RestController
@RequestMapping("/v1")
@Api(tags = "用户相关接口", description = "提供用户相关的Rest API")
@Slf4j
public class UserController {

    @ApiOperation(value = "新增用户接口", notes = "根据 user 对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户实体", required = true, dataType = "User")
    @PostMapping(value = "/users", produces = "application/json;charset=UTF-8")
    public boolean addUser(@RequestBody User user) {
        log.info("user: {}", user);
        return true;
    }

    @ApiOperation("通过id查找用户接口")
    @ApiImplicitParam(name = "id", value = "用户id", defaultValue = "1", required = true)
    @GetMapping(value = "/users/{id}")
    public User findById(@PathVariable("id") Long id) {
        log.info("findById: {}", id);
        User user = new User();
        user.setId(id);
        user.setName("aaa");
        user.setAddress("address");
        return user;
    }

    @ApiOperation("查找用户列表接口")
    @GetMapping("/users")
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();
        userList.add(new User(1L, "AAA", "北京"));
        userList.add(new User(2L, "BBB", "上海"));
        return userList;
    }

    @ApiOperation("更新用户信息接口")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "user", value = "用户实体", required = true, dataType = "User"),
        @ApiImplicitParam(name = "param", value = "参数", defaultValue = "参数1", required = true, dataType = "String")
    })
    @PutMapping(value = "/users")
    public boolean update(@RequestBody User user, @RequestParam String param) {
        log.info("user: {}, name: {}", user, param);
        return true;
    }

    @ApiOperation("删除用户接口")
    @DeleteMapping(value = "/users/{id}")
    public boolean delete(@PathVariable("id") Long id) {
        log.info("delete id {}: ", id);
        return true;
    }
}
