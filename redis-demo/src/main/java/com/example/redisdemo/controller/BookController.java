package com.example.redisdemo.controller;

import com.example.redisdemo.model.Book;
import com.example.redisdemo.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Gary
 * @className BookController
 * @description TODO
 * @date 2019-11-05 17:51
 **/
@RestController
public class BookController {

    @Autowired
    private IBookService bookService;

    @RequestMapping("/save")
    public void save(@RequestBody Book book) {
        System.out.println(book);
        bookService.save(book);
    }

    @RequestMapping("/findById")
    public Book findById(@RequestParam Long id) {
        Book book = bookService.findById(id);
        System.out.println(book);
        return book;
    }

    @RequestMapping("/setString")
    public void setString(@RequestParam String key, @RequestParam String value) throws InterruptedException {
        bookService.setString(key, value);
    }
}
