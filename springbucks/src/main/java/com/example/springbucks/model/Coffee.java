package com.example.springbucks.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.Accessors;
import org.apache.ibatis.type.Alias;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author Gary
 * @className Coffee
 * @description TODO
 * @date 2019-04-13 19:06
 **/

//@Document
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Alias("coffee")
@TableName("t_coffee")
public class Coffee extends BaseModel implements Serializable {

    @NotNull(message = "名称不能为空")
    private String name;

    @NotNull(message = "价格不能为空")
    private Long price;

}
