package com.example.springsecuritywebfluxdemo.controller;

import com.example.springsecuritywebfluxdemo.result.SnowResult;
import com.example.springsecuritywebfluxdemo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * 用户 Controller
 *
 * @author Gary
 * @date 2019/12/16 18:08
 * @since jdk1.8
 **/
@RestController
public class UserConroller {

    @Autowired
    private ReactiveAuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public SnowResult login(@RequestParam("username") String username, @RequestParam("password") String password){
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        Mono<Authentication> authentication = authenticationManager.authenticate(authenticationToken);
//        authentication.map()
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        String jwt = jwtUtil.createJWT(authentication);
//        return SnowResult.ofSuccess(jwt);
        return null;
    }
}
