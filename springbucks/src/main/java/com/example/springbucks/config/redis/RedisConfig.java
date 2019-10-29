package com.example.springbucks.config.redis;


import com.alibaba.fastjson.parser.ParserConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.lang.reflect.Method;
import java.time.Duration;

/**
 * @author Gary
 * @className RedisConfig
 * @description TODO
 * @date 2019-04-27 22:22
 **/
@Slf4j
@Configuration
@EnableCaching
public class RedisConfig {

    @Value("${spring.redis.database}")
    private int dbIndex;

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Value("${spring.redis.password}")
    private String password;

    @Value("${spring.redis.timeout}")
    private int timeout;

    @Value("${spring.redis.lettuce.pool.max-active}")
    private int redisPoolMaxActive;

    @Value("${spring.redis.lettuce.pool.max-wait}")
    private int redisPoolMaxWait;

    @Value("${spring.redis.lettuce.pool.max-idle}")
    private int redisPoolMaxIdle;

    @Value("${spring.redis.lettuce.pool.min-idle}")
    private int redisPoolMinIdle;

    /**
     * 配置Key的生成方式
     *
     * @return
     */
    @Bean
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object o, Method method, Object... objects) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(o.getClass().getName())
                        .append(method.getName());
                for (Object object : objects) {
                    stringBuilder.append(object.toString());
                }
                return stringBuilder.toString();
            }
        };
    }

    /**
     * 配置连接池
     *
     * @author Gary
     * @param
     *
     * @return org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
     * @date 2019-05-05 16:51
     */
    @Bean
    public LettuceConnectionFactory lettuceConnectionFactory() {

        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName(host);
        redisStandaloneConfiguration.setPort(port);
        redisStandaloneConfiguration.setDatabase(dbIndex);
        redisStandaloneConfiguration.setPassword(RedisPassword.of(password));

        GenericObjectPoolConfig genericObjectPoolConfig = new GenericObjectPoolConfig();
        genericObjectPoolConfig.setMaxIdle(redisPoolMaxIdle);
        genericObjectPoolConfig.setMinIdle(redisPoolMinIdle);
        genericObjectPoolConfig.setMaxTotal(redisPoolMaxActive);
        genericObjectPoolConfig.setMaxWaitMillis(redisPoolMaxWait);

        LettuceClientConfiguration clientConfig = LettucePoolingClientConfiguration.builder()
                .commandTimeout(Duration.ofMillis(timeout))
                .poolConfig(genericObjectPoolConfig)
                .build();

        LettuceConnectionFactory factory = new LettuceConnectionFactory(redisStandaloneConfiguration, clientConfig);
        return factory;

    }

    @Bean
    public CacheManager cacheManager(RedisConnectionFactory factory) {
        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofSeconds(3600))
                .disableCachingNullValues();
        return RedisCacheManager.builder(factory)
                .cacheDefaults(config)
                .transactionAware()
                .build();
    }

    @Bean
    @ConditionalOnMissingBean(name = "redisTemplate")
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {

        FastJson2JsonRedisSerializer<Object> fastJson2JsonRedisSerializer = new FastJson2JsonRedisSerializer<>(Object.class);

        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(fastJson2JsonRedisSerializer);
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
        template.afterPropertiesSet();
        //开启fastjson autotype白名单
        ParserConfig.getGlobalInstance().addAccept("com.example.springbucks.pojo.");
        // 全局开启AutoType，不建议使用
        // ParserConfig.getGlobalInstance().setAutoTypeSupport(true);

        return template;

    }

    @Bean
    @ConditionalOnMissingBean(StringRedisTemplate.class)
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        StringRedisTemplate template = new StringRedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }


}
