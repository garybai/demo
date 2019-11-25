package com.example.redissonlockdemo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Gary
 * @className RedissonProperties
 * @description TODO
 * @date 2019/11/19 15:18
 **/
@Data
@Component
@ConfigurationProperties(prefix = "redisson")
public class RedissonProperties {

    private String address;

    private String password;

    private Integer timeout;

    private Integer connectionPoolSize;

    private Integer connectionMinimumIdleSize;
}
