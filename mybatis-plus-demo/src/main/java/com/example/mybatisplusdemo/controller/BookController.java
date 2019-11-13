package com.example.mybatisplusdemo.controller;

import com.example.mybatisplusdemo.domain.BookDO;
import com.example.mybatisplusdemo.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Gary
 * @className BookController
 * @description TODO
 * @date 2019-11-12 15:32
 **/
@RestController
public class BookController {

    @Autowired
    private IBookService bookService;

    @PostMapping("/addBook")
    public boolean addBook(@RequestBody BookDO bookDO){
        return bookService.save(bookDO);
    }

    @GetMapping("/getAllBooks")
    public List<BookDO> getAllBooks(){
        return bookService.list();
    }
}
