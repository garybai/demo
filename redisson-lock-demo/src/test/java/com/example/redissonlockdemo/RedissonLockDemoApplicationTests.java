package com.example.redissonlockdemo;

import com.example.redissonlockdemo.config.DistributedLocker;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RLock;
import org.redisson.api.RReadWriteLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class RedissonLockDemoApplicationTests {

    @Autowired
    DistributedLocker distributedLocker;

    @Test
    public void test1() throws InterruptedException {
        System.out.println("测试可重入锁");

        RLock lock = distributedLocker.getLock("key1");
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        boolean b = lock.tryLock(3, 10, TimeUnit.SECONDS);
                        if (b) {
                            System.out.println(Thread.currentThread().getName() + "获取锁成功");
                        } else {
                            System.out.println(Thread.currentThread().getName() + "获取锁失败");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        Thread.sleep(10000);
    }

    @Test
    public void testFairLock() throws InterruptedException {
        RLock fairLock = distributedLocker.getFairLock("getLock");
        new Thread(new MyRunner("线程A", fairLock)).start();
        new Thread(new MyRunner("线程B", fairLock)).start();
        Thread.sleep(10000);
    }

    @Test
    public void testRWlock() throws InterruptedException {
        RReadWriteLock rwlock = distributedLocker.getReadWriteLock("lockKey");
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        boolean redRes = rwlock.readLock().tryLock(5, 10, TimeUnit.SECONDS);
                        if (redRes) {
                            System.out.println(Thread.currentThread().getName() + "线程获取读锁成功");
                        } else {
                            System.out.println(Thread.currentThread().getName() + "线程获取读锁失败");
                        }
                        boolean writeRes = rwlock.writeLock().tryLock(10, 10, TimeUnit.SECONDS);
                        if (writeRes) {
                            System.out.println(Thread.currentThread().getName() + "线程获取写锁成功");
                        } else {
                            System.out.println(Thread.currentThread().getName() + "线程获取写锁失败");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        Thread.sleep(20000);
    }

    @Test
    public void test3() throws InterruptedException {
        ArrayList<String> arrayList = new ArrayList<>(10);

        int clientcount = 10;
        String key = "lock1";
        CountDownLatch countDownLatch = new CountDownLatch(clientcount);

        ExecutorService executorService = Executors.newFixedThreadPool(clientcount);
        long start = System.currentTimeMillis();
        for (int i = 0; i < clientcount; i++) {
            executorService.execute(() -> {
                RLock lock = distributedLocker.getLock(key);

                try {
                    boolean b = lock.tryLock(60, 30, TimeUnit.SECONDS);
                    if (b) {
                        try {
                            System.out.println(Thread.currentThread().getName() + "获取到锁 " + LocalTime.now());
                            // 获取到锁之后休眠 3s，模拟业务逻辑
                            Thread.sleep(3000);
                            arrayList.add(Thread.currentThread().getName());
                        } finally {
                            System.out.println(Thread.currentThread().getName() + "解锁 " + LocalTime.now());
                            lock.unlock();
                        }
                    } else {
                        System.out.println(Thread.currentThread().getName() + "未获取到锁 " + LocalTime.now());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        long end = System.currentTimeMillis();
        log.info("执行线程数:{},总耗时:{}", clientcount, end - start);
        arrayList.forEach(System.out::println);
    }


    class MyRunner implements Runnable {
        String threadName;
        RLock rLock;

        public MyRunner(String threadName, RLock rLock) {
            this.threadName = threadName;
            this.rLock = rLock;
        }

        public String getThreadName() {
            return threadName;
        }

        public void setThreadName(String threadName) {
            this.threadName = threadName;
        }

        public RLock getrLock() {
            return rLock;
        }

        public void setrLock(RLock rLock) {
            this.rLock = rLock;
        }

        @Override
        public void run() {
            try {
                /*
                fairLock.lock();
                // 支持过期解锁功能, 10秒钟以后自动解锁,无需调用unlock方法手动解锁
                fairLock.lock(10, TimeUnit.SECONDS);*/
                // 尝试加锁，最多等待100秒，上锁以后10秒自动解锁
                boolean res = rLock.tryLock(100, 10, TimeUnit.SECONDS);
                if (res) {
                    System.out.println("线程名称:" + getThreadName());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}