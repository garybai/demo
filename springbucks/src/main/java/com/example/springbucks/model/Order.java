package com.example.springbucks.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.Accessors;
import org.apache.ibatis.type.Alias;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 订单表
 * @author Gary
 * @className Order
 * @description TODO
 * @date 2019-04-13 19:10
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Alias("order")
@TableName("t_order")
public class Order extends BaseModel implements Serializable {

    @NotNull(message = "顾客姓名不能为空")
    private String customer;

    @NotNull(message = "订单状态不能为空")
    private Integer state;

}
