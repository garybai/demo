package com.example.springsecuritydynamicdemo.service;

import com.example.springsecuritydynamicdemo.entity.RolePO;
import com.example.springsecuritydynamicdemo.entity.UserPO;
import com.example.springsecuritydynamicdemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Gary
 * @className UserService
 * @description TODO
 * @date 2019/11/23 11:17
 **/
@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        UserPO userPO = userMapper.loadUserByUsername(username);
        if (userPO == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        List<RolePO> rolePOList = userMapper.getRolesById(userPO.getId());
        for (RolePO rolePO : rolePOList) {
            authorities.add(new SimpleGrantedAuthority(rolePO.getName()));
        }
        return new User(userPO.getUsername(), userPO.getPassword(), authorities);
    }
}
