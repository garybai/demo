package com.example.springbucks.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.springbucks.model.Coffee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * TODO
 *
 * @author Gary
 * @date 2019-04-13 19:24
 */
public interface CoffeeDao extends BaseMapper<Coffee> {

    /**
     * @param coffee
     * @return java.lang.Long
     * @description: 新增coffee
     * @author Gary
     * @date 2019-04-07 20:59
     */
//    @Insert("insert into t_coffee (name, price, create_time, update_time) " +
//            "values (#{name}, #{price}, now(), now())")
//    @Options(useGeneratedKeys = true)
//    Long save(Coffee coffee);

    /**
     * 根据id查询coffee
     *
     * @param id
     * @return com.example.mybatisdemo.pojo.Coffee
     * @description:
     * @author Gary
     * @date 2019-04-07 20:59
     */
//    @Select("select * from t_coffee where id = #{id}")
//    @Results({
//            @Result(id = true, column = "id", property = "id")
//    })
//    Coffee findById(Long id);

    /**
     * 分页查询
     *
     * @param rowBounds
     * @return java.util.List<com.example.mybatisdemo.pojo.Coffee>
     * @description: TODO
     * @author Gary
     * @date 2019-04-07 21:13
     */
//    @Select("select * from t_coffee order by id")
//    List<Coffee> findAllWithRowBounds(RowBounds rowBounds);

//    List<Coffee> search(Coffee coffee);

    /**
     * TODO
     * 
     * @author Gary
     * @param wrapper
     *       
     * @return java.util.List<com.example.springbucks.pojo.Coffee>
     * @date 2019-06-18 14:08 
     */
    List<Coffee> selectListByWrapper(@Param("ew") Wrapper wrapper);

    IPage<Coffee> selectPageByWrapper(IPage<Coffee> page, @Param("ew") Wrapper<Coffee> queryWrapper);
}
