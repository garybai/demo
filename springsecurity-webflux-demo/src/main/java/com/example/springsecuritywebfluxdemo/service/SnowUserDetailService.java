package com.example.springsecuritywebfluxdemo.service;

import com.example.springsecuritywebfluxdemo.model.Authority;
import com.example.springsecuritywebfluxdemo.model.Role;
import com.example.springsecuritywebfluxdemo.model.User;
import com.example.springsecuritywebfluxdemo.model.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 自定义 UserDetailService
 *
 * @author Gary
 * @date 2019/12/16 16:46
 * @since jdk1.8
 **/
@Component
public class SnowUserDetailService implements UserDetailsService {

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IAuthorityService authorityService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("未找到用户信息 : " + username));
        List<Role> roles = roleService.selectByUserId(user.getId());
        List<Long> roleIds = roles.stream()
                .map(Role::getId)
                .collect(Collectors.toList());
        List<Authority> authorities = authorityService.selectByRoleIdList(roleIds);
        return UserPrincipal.create(user, roles, authorities);
    }
}
