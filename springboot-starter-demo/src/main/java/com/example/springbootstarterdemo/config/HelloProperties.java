package com.example.springbootstarterdemo.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Gary
 * @className HelloProperties
 * @description TODO
 * @date 2019-10-22 16:43
 **/
@Getter
@Setter
@ConfigurationProperties(prefix = "hello")
public class HelloProperties {

    private static final String DEFAULT_NAME = "default_name";
    private static final String DEFAULT_MSG = "default_msg";
    private String name = DEFAULT_NAME;
    private String msg = DEFAULT_MSG;

}
