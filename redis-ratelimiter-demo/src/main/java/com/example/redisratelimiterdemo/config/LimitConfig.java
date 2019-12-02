package com.example.redisratelimiterdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.script.DefaultRedisScript;

/**
 * LimitConfig
 *
 * @author Gary
 * @date 2019/12/2 17:10
 * @since jdk1.8
 **/
@Configuration
public class LimitConfig {

    /**
     * 注入 lua 脚本
     */
    @Bean
    public DefaultRedisScript<Long> limitScript() {
        DefaultRedisScript<Long> defaultRedisScript = new DefaultRedisScript<>();
        defaultRedisScript.setLocation(new ClassPathResource("limit_script.lua"));
        defaultRedisScript.setResultType(Long.class);
        return defaultRedisScript;
    }

}
