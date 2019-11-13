package com.example.mybatisplusdemo.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author Gary
 * @className BaseDO
 * @description TODO
 * @date 2019-11-11 15:58
 **/
@Data
@Accessors(chain = true)
public class BaseDO {

    private Integer id;

    @TableField(fill = FieldFill.INSERT)
//    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
//    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

}
