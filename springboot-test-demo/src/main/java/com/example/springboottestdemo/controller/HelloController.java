package com.example.springboottestdemo.controller;

import com.example.springboottestdemo.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ceshi controller
 *
 * @author Gary
 * @date 2020/5/6 15:41
 **/
@RestController
@Slf4j
public class HelloController {

    @Autowired
    private HelloService service;

    @RequestMapping("/hello")
    public String hello(){
        return service.hello();
    }

    @RequestMapping("/test")
    public String test(@RequestParam("id") String id){
        return id;
    }

    @RequestMapping(value = "/addArticle", method = RequestMethod.POST)
    @ResponseBody
    public String addArticle(@RequestParam("article") String article) {
//        String s = TextTool.generateArticleText(article);
        String hash = SimHash.simHash(article).toString();
        log.error("{}-------->{}", hash, article);
//        boolean b = articleService.addArticle(articleid, article, type, SimHash.simHash(s).toString());
//        return result.setData(b);
        return hash;
    }

}
