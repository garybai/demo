package com.example.springsecuritywebfluxdemo.model;

import cn.hutool.core.util.StrUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Userprincipal
 *
 * @author Gary
 * @date 2019/12/16 15:54
 * @since jdk1.8
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class UserPrincipal implements UserDetails {

    private Long id;
    private String username;
    private String password;
    private Integer status;
    private List<String> roles;
    private Collection<? extends GrantedAuthority> authorities;

    public static UserPrincipal create(User user, List<Role> roles, List<Authority> authorities) {
        List<String> roleNames = roles.stream()
                .map(Role::getName)
                .collect(Collectors.toList());
        List<SimpleGrantedAuthority> authorities1 = authorities.stream()
                .filter(authority -> StrUtil.isNotBlank(authority.getResource()))
                .map(authority -> new SimpleGrantedAuthority(authority.getResource()))
                .collect(Collectors.toList());
        return new UserPrincipal(user.getId(), user.getUsername(), user.getPassword(), user.getStatus(), roleNames, authorities1);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return status == 1;
    }
}
