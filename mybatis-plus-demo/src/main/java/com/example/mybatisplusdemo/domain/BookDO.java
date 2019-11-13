package com.example.mybatisplusdemo.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Gary
 * @className BookDO
 * @description TODO
 * @date 2019-11-11 15:12
 **/
@Data
@Accessors(chain = true)
@TableName(value = "t_book")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class BookDO extends BaseDO implements Serializable {

    private String name;

    private Integer auId;

    private Date publishTime;

}
