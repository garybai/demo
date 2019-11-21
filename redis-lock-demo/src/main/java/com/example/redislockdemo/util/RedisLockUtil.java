package com.example.redislockdemo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * @author Gary
 * @className RedisLockUtil
 * @description TODO
 * @date 2019-11-14 17:28
 **/
@Component
public class RedisLockUtil {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Resource(name = "unlockScript")
    private DefaultRedisScript<Long> unlockScript;

    @Resource(name = "renewalScript")
    private DefaultRedisScript<Long> renewalScript;

    private long lockTime = 2000;

    private long timeout = 60000;

    private static final Long SUCCESS = 1L;

    private ThreadLocal<ExpirationRenewal> currentThread = new ThreadLocal<>();

    public Boolean lock(String key, String value) {
        long start = System.currentTimeMillis();
        while (true) {
            if ((System.currentTimeMillis() - start) > timeout) {
                System.out.println(Thread.currentThread().getName() + "未获取锁。。。超时");
                return false;
            }
            // 相当于 redis 的 setnx 命令，如果 key 不存在，则 set value，如果存在，不做任何操作
            Boolean absent = redisTemplate.opsForValue().setIfAbsent(key, value, lockTime, TimeUnit.MILLISECONDS);
            if (absent == null) {
                return false;
            }
            if (absent) {
                System.out.println(Thread.currentThread().getName() + "获取到锁 " + LocalTime.now());

                // 获取到锁之后开启锁过期时间刷新
                ExpirationRenewal expirationRenewal = scheduleExpirationRenewal(key, value);
                currentThread.set(expirationRenewal);
                return true;
            }
            System.out.println(Thread.currentThread().getName() + "未获取锁。。自旋 休眠 2s " + LocalTime.now());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Boolean unlock(String key, String value) {
        ExpirationRenewal expirationRenewal = currentThread.get();
        expirationRenewal.stop();
        currentThread.remove();

        // 判断只有当 value 相等的时候（也就是同一个线程）才去解锁
        // lua 脚本保证解锁原子性
        Long execute = redisTemplate.execute(unlockScript, Arrays.asList(key, value));
        if (SUCCESS.equals(execute)) {
            System.out.println(Thread.currentThread().getName() + "解锁成功 " + LocalTime.now());
            return true;
        } else {
            System.out.println(Thread.currentThread().getName() + "解锁失败 " + LocalTime.now());
            return false;
        }
    }

    public ExpirationRenewal scheduleExpirationRenewal(String key, String value) {
        ExpirationRenewal expirationRenewal = new ExpirationRenewal(key, value);
        Thread renewalThread = new Thread(expirationRenewal);
        renewalThread.start();
        System.out.println(Thread.currentThread().getName() + "调用" + renewalThread.getName() + "刷新过期时间 " + LocalTime.now());
        return expirationRenewal;
    }

    /**
     * 刷新key的过期时间
     */
    private class ExpirationRenewal implements Runnable {

        private String key;
        private String value;
        // 控制刷新过期时间的线程是否开启
        private boolean stop = false;

        public ExpirationRenewal(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public void stop() {
            this.stop = true;
        }

        @Override
        public void run() {
            while (!stop) {
//                System.out.println("执行延迟失效时间中...");
                System.out.println(Thread.currentThread().getName() + "刷新 " + LocalTime.now());
                redisTemplate.execute(renewalScript, Arrays.asList(key), value, "5");

                //休眠1秒
                sleepBySecond(1);
            }
        }
    }

    public void sleepBySecond(int sencond) {
        try {
            Thread.sleep(sencond * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 解锁的 lua 脚本
    @Bean(name = "unlockScript")
    public DefaultRedisScript<Long> unlockScript() {
        String script = "if redis.call('get', KEYS[1]) == KEYS[2] then " +
                "return redis.call('del', KEYS[1]) " +
                "else " +
                "return 0 end";
        DefaultRedisScript<Long> defaultRedisScript = new DefaultRedisScript<>();
        defaultRedisScript.setResultType(Long.class);
        defaultRedisScript.setScriptText(script);
        return defaultRedisScript;
    }

    // 刷新过期时间的 lua 脚本
    @Bean(name = "renewalScript")
    public DefaultRedisScript<Long> renewalScript() {
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then " +
                "return redis.call('expire',KEYS[1],ARGV[2]) " +
                "else " +
                "return 0 end";
        DefaultRedisScript<Long> defaultRedisScript = new DefaultRedisScript<>();
        defaultRedisScript.setResultType(Long.class);
        defaultRedisScript.setScriptText(script);
        return defaultRedisScript;
    }
}
