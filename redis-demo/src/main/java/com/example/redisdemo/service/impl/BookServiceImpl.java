package com.example.redisdemo.service.impl;

import com.example.redisdemo.model.Book;
import com.example.redisdemo.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author Gary
 * @className BookServiceImpl
 * @description TODO
 * @date 2019-11-05 17:44
 **/
@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public void save(Book book) {
        redisTemplate.opsForValue().set("book" + book.getBookId(), book);
    }

    @Override
    @Cacheable(value = "book", key = "args[0]")
    public Book findById(Long id) {
        // return (Book) redisTemplate.opsForValue().get("book" + id);
        return new Book().setBookId(id).setBookName("sss");
    }

    @Override
    public void setString(String key, String value) throws InterruptedException {
        Boolean absent = redisTemplate.opsForValue().setIfAbsent(key, value, 100, TimeUnit.SECONDS);
        System.out.println(absent);
        Thread.sleep(1000);
        //Object andSet = redisTemplate.opsForValue().getAndSet(key, value);
        //System.out.println(andSet);
    }

}
