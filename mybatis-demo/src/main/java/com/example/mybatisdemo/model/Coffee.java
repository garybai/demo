package com.example.mybatisdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.joda.money.Money;

import java.util.Date;

/**
 * @ClassName Coffee
 * @Description TODO
 * @Author Gary
 * @Date 2019-04-07 20:28
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Coffee {
    private Long id;
    private String name;
    private Money price;
    private Date createTime;
    private Date updateTime;
}
