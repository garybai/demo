package com.example.redislockdemo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * @author Gary
 * @className RedisLockUtil
 * @description TODO
 * @date 2019-11-14 17:28
 **/
@Component
public class RedisLockUtil4 {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Resource(name = "unlockScript1")
    private DefaultRedisScript<Long> unlockScript;

    private long timeout = 3000;

    private static final Long SUCCESS = 1L;

    public Boolean lock(String key, String value) {
        long start = System.currentTimeMillis();
        while (true) {
            if ((System.currentTimeMillis() - start) > timeout) {
                System.out.println(Thread.currentThread().getName() + "未获取锁。。。超时");
                return false;
            }
            Boolean absent = redisTemplate.opsForValue().setIfAbsent(key, value, timeout, TimeUnit.MILLISECONDS);
            if (absent == null) {
                return false;
            }
            if (absent) {
                System.out.println(Thread.currentThread().getName() + "获取到锁");
                return true;
            }
            System.out.println(Thread.currentThread().getName() + "未获取锁。。。自旋");
        }
    }

    public Boolean unlock(String key, String value) {
        // Lua 脚本保证原子性的释放锁
        Long execute = redisTemplate.execute(unlockScript, Arrays.asList(key, value));
        if (SUCCESS.equals(execute)) {
            System.out.println(Thread.currentThread().getName() + "解锁成功");
            return true;
        } else {
            System.out.println(Thread.currentThread().getName() + "解锁失败");
            return false;
        }
    }

    @Bean(name = "unlockScript1")
    public DefaultRedisScript<Long> unlockScript1() {
        String script = "if redis.call('get', KEYS[1]) == KEYS[2] then " +
                "return redis.call('del', KEYS[1]) " +
                "else " +
                "return 0 end";
        DefaultRedisScript<Long> defaultRedisScript = new DefaultRedisScript<>();
        defaultRedisScript.setResultType(Long.class);
        defaultRedisScript.setScriptText(script);
        return defaultRedisScript;
    }
}
