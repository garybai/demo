package com.example.mybatisdemo.mapper;

import com.example.mybatisdemo.model.Coffee;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * @className CoffeeMapper
 * @description TODO
 * @author Gary
 * @date 2019-04-07 20:31
 **/
@Mapper
public interface CoffeeMapper {

    /**
     * @description: 新增coffee
     * @author Gary
     * @param coffee
     *
     * @return java.lang.Long
     * @date 2019-04-07 20:59
     */
    @Insert("insert into t_coffee (name, price, create_time, update_time) " +
            "values (#{name}, #{price}, now(), now())")
    @Options(useGeneratedKeys = true)
    Long save(Coffee coffee);

    /**
     * @description: 根据id查询coffee
     * @author Gary
     * @param id
     *
     * @return com.example.mybatisdemo.pojo.Coffee
     * @date 2019-04-07 20:59
     */
    @Select("select * from t_coffee where id = #{id}")
    @Results({
            @Result(id = true, column = "id", property = "id")
    })
    Coffee findById(Long id);

    /**
     * 分页查询
     *
     * @description: TODO
     * @author Gary
     * @param rowBounds
     *       
     * @return java.util.List<com.example.mybatisdemo.pojo.Coffee>
     * @date 2019-04-07 21:13
     */
    @Select("select * from t_coffee order by id")
    List<Coffee> findAllWithRowBounds(RowBounds rowBounds);

    /**
     * 分页查询
     *
     * @author Gary
     * @param pageNum
     * @param pageSize
     *
     * @return java.util.List<com.example.mybatisdemo.pojo.Coffee>
     * @date 2019-04-07 21:38
     */
    @Select("select * from t_coffee order by id")
    List<Coffee> findAllWithParam(@Param("pageNum") int pageNum,
                                  @Param("pageSize") int pageSize);
}
