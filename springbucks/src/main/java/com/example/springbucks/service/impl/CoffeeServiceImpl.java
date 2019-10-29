package com.example.springbucks.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springbucks.dao.CoffeeDao;
import com.example.springbucks.model.Coffee;
import com.example.springbucks.service.CoffeeService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Gary
 * @className CoffeeServiceImpl
 * @description TODO
 * @date 2019-04-13 19:25
 **/
@Service("coffeeService")
public class CoffeeServiceImpl extends ServiceImpl<CoffeeDao, Coffee> implements CoffeeService {

//    @Override
//    public int save(Coffee coffee) {
////        return coffeeDao.save(coffee);
//        return coffeeDao.insert(coffee);
//    }

    @Override
    @Cacheable(cacheNames = "coffeeMenu", key = "'coffee_'+#id")
    public Coffee getById(Long id) {
        return baseMapper.selectById(id);
    }

//    @Override
//    public List<Coffee> findAllByPage(int pageNum, int pageSize) {
//        RowBounds rowBounds = new RowBounds(pageNum, pageSize);
//        return coffeeDao.findAllWithRowBounds(rowBounds);
//    }

//    @Override
//    public List<Coffee> search(Coffee coffee) {
//        return coffeeDao.search(coffee);
//    }

    @Override
    public List<Coffee> selectListByWrapper(Wrapper<Coffee> wrapper) {
        return baseMapper.selectListByWrapper(wrapper);
    }

    @Override
    public IPage<Coffee> selectPageByWrapper(IPage<Coffee> page, Wrapper<Coffee> queryWrapper) {
        return baseMapper.selectPageByWrapper(page, queryWrapper);
    }
}
