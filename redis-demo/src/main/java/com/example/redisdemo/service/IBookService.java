package com.example.redisdemo.service;

import com.example.redisdemo.model.Book;

/**
 * @author Gary
 * @className IBookService
 * @description TODO
 * @date 2019-11-05 17:39
 **/
public interface IBookService {

    void save(Book book);

    Book findById(Long id);

    void setString(String key, String value) throws InterruptedException;
}
