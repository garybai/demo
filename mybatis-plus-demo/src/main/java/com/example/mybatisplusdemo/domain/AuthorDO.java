package com.example.mybatisplusdemo.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author Gary
 * @className AuthorDO
 * @description TODO
 * @date 2019-11-11 15:15
 **/
@Data
@Accessors(chain = true)
@TableName(value = "t_author")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class AuthorDO extends BaseDO implements Serializable {

    private String name;

}
