package com.example.redissonlockdemo.config;

import cn.hutool.core.util.StrUtil;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Gary
 * @className RedissionConfig
 * @description TODO
 * @date 2019/11/19 15:21
 **/
@Configuration
public class RedissonConfig {

    /**
     * 注入 Redisson 配置
     *
     * @author Gary
     * @param null
     *
     * @return
     * @date 2019/11/19 15:33
     */
    @Autowired
    private RedissonProperties redissonProperties;

    /**
     * 创建 Redisson client
     *
     * @author Gary
     * @param
     *
     * @return org.redisson.api.RedissonClient
     * @date 2019/11/19 15:32
     */
    @Bean
    public RedissonClient redissonClient(){
        System.out.println("-----"+redissonProperties.toString());
        Config config = new Config();
//        config.setLockWatchdogTimeout(1000);
        SingleServerConfig serverConfig = config.useSingleServer()
                .setAddress(redissonProperties.getAddress())
                .setConnectionPoolSize(redissonProperties.getConnectionPoolSize())
                .setConnectionMinimumIdleSize(redissonProperties.getConnectionMinimumIdleSize());
        if(StrUtil.isNotBlank(redissonProperties.getPassword())){
            serverConfig.setPassword(redissonProperties.getPassword());
        }
        return Redisson.create(config);
    }

//    @Bean
//    public RedissonDistributedLocker redissonDistributedLocker(RedissonClient redissonClient){
//        RedissonDistributedLocker redissonDistributedLocker = new RedissonDistributedLocker();
//        redissonDistributedLocker.setRedissonClient(redissonClient);
//        return redissonDistributedLocker;
//    }

}
