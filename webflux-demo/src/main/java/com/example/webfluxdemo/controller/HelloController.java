package com.example.webfluxdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

/**
 * ceshi
 *
 * @author Gary
 * @date 2019/12/6 15:57
 * @since jdk1.8
 **/
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello1")
    public Mono<String> hello1() {
        return Mono.just("hello1");
    }

    @GetMapping("/test")
    public Flux<String> test() {
        List<String> list = Arrays.asList("a", "b", "c");
        return Flux.fromStream(list.stream());
    }

}
