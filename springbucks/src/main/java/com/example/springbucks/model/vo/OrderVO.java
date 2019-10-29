package com.example.springbucks.model.vo;

import com.example.springbucks.model.Coffee;
import com.example.springbucks.model.Order;
import lombok.*;
import lombok.experimental.Accessors;
import org.apache.ibatis.type.Alias;

import java.util.List;

/**
 * @author Gary
 * @className OrderVO
 * @description TODO
 * @date 2019-06-18 17:42
 **/
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Alias("orderVO")
public class OrderVO {

    private Order order;

    private List<Coffee> coffeeList;

}
