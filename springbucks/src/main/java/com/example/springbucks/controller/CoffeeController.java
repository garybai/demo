package com.example.springbucks.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springbucks.common.annotation.TimeAspect;
import com.example.springbucks.model.Coffee;
import com.example.springbucks.service.CoffeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @author Gary
 * @className CoffeeController
 * @description TODO
 * @date 2019-04-13 19:35
 **/
@RestController
@Slf4j
@RequestMapping("/coffee")
public class CoffeeController {

    @Resource
    private CoffeeService coffeeService;

//    (name, price, create_time, update_time) values ('espresso', 2000, now(), now());
//    (name, price, create_time, update_time) values ('latte', 2500, now(), now());
//    (name, price, create_time, update_time) values ('capuccino', 2500, now(), now());
//    (name, price, create_time, update_time) values ('mocha', 3000, now(), now());
//    i(name, price, create_time, update_time) values ('macchiato', 3000, now(), now());

    @TimeAspect(name = "新增咖啡")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@RequestBody @Valid Coffee coffee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return bindingResult.getFieldError().getDefaultMessage();
        }
        coffeeService.save(coffee);
        return "success";
    }

    @TimeAspect(name = "根据id查询咖啡")
    @RequestMapping(value = "/findById", method = RequestMethod.GET)
    public Coffee findById(@RequestParam Long id) {
        Coffee coffee = coffeeService.getById(id);
        // log.info("coffee: {}", coffee);
        return coffee;
    }

    @TimeAspect(name = "根据id查询咖啡,null")
    @RequestMapping(value = "/findById1", method = RequestMethod.GET)
    public Coffee findById1(@RequestParam Long id) {
//        Coffee coffee = coffeeService.getById(id);
        // log.info("coffee: {}", coffee);
        return null;
    }

    @TimeAspect(name = "分页查询咖啡")
    @RequestMapping(value = "/findByPage", method = RequestMethod.POST)
    public List<Coffee> findAllWithRowBounds(@RequestParam int pageNum,
                                             @RequestParam int pageSize) {
//        List<Coffee> coffees = new ArrayList<Coffee>();
//        coffees = coffeeService.findAllByPage(pageNum, pageSize);
//        coffees.forEach(coffee -> log.info("Page {}: {}", pageNum, coffee));
//        return coffees;
        Page<Coffee> page = new Page<>(pageNum, pageSize);
        IPage<Coffee> iPage = coffeeService.selectPageByWrapper(page, new QueryWrapper<>());

//        log.info("total: {} ",iPage.getTotal());
//        log.info("pages: {} ",iPage.getPages());
//        log.info("size: {} ",iPage.getSize());
//        log.info("current: {} ",iPage.getCurrent());
//        log.info("ipage: {}", iPage.toString());
        List<Coffee> coffees;
        coffees = iPage.getRecords();
//        coffees.forEach(coffee -> log.info("Page {}: {}", pageNum, coffee));
        return coffees;
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public List<Coffee> search(@RequestParam String name,
                               @RequestParam Double price) {
        Coffee coffee = new Coffee();
        if (price == null) {
            price = 0.0d;
        }
        coffee.setName(name).setPrice(Math.round(price * 100));
        QueryWrapper<Coffee> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", coffee.getName())
                .eq("price", coffee.getPrice());
        List<Coffee> coffees = coffeeService.selectListByWrapper(queryWrapper);

        coffees.forEach(c -> log.info("Coffee: {}", c));
        return coffees;
    }
}
