package com.example.springbucks.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Gary
 * @className BaseModel
 * @description TODO
 * @date 2019-04-13 19:04
 **/

//@Document
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class BaseModel implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Date createTime;

    private Date updateTime;
}
