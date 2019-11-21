package com.example.redissonlockdemo.config;

import org.redisson.api.RLock;
import org.redisson.api.RReadWriteLock;

import java.util.concurrent.TimeUnit;

/**
 * @author Gary
 */
public interface DistributedLocker {

    RLock getLock(String lockKey);

    RLock getFairLock(String lockKey);

    RReadWriteLock getReadWriteLock(String lockKey);

    boolean tryLock(String lockKey, Integer waitTime, Integer leaseTime, TimeUnit unit);

    void lock(String lockKey);

    void unlock(String lockKey);

    void lock(String lockKey, Integer timeout, TimeUnit unit);
}
