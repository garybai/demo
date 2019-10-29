package com.example.springbucks.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springbucks.model.Coffee;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * @author Gary
 * @className CoffeeService
 * @description TODO
 * @date 2019-04-13 19:16
 **/
public interface CoffeeService extends IService<Coffee> {

//    List<Coffee> findAllByPage(@Param("pageNum") int pageNum,
//                               @Param("pageSize") int pageSize);

//    List<Coffee> search(Coffee coffee);


    Coffee getById(Long id);

    List<Coffee> selectListByWrapper(Wrapper<Coffee> wrapper);

    IPage<Coffee> selectPageByWrapper(IPage<Coffee> page, Wrapper<Coffee> queryWrapper);
}
