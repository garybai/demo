package com.example.unnameddemo.controller;

import com.example.unnameddemo.advice.Author;
import com.example.unnameddemo.advice.Book;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Gary
 * @className TestController
 * @description TODO
 * @date 2019-10-25 18:14
 **/
@RestController
public class TestController {

    /**
     * @description: f
     * @param model:
     * @return java.lang.String
     * @author: Gary
     * @date: 2019/11/26 16:12
     */
    @GetMapping("/hello")
    public String hello(Model model) {
        System.out.println(model);
        Map<String, Object> map = model.asMap();
        System.out.println(map);
//        int i = 1 / 0;
        return "hello controller advice";
    }


    /**
     * @description: 添加 book
     * @param book:
     * @param author:
     * @return void
     * @author: Gary
     * @date: 2019/11/26 16:11
     */
    @PostMapping("/book")
    public void addBook(@ModelAttribute("b") Book book, @ModelAttribute("a") Author author) {
        System.out.println(book);
        System.out.println(author);
    }
}
