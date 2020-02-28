package com.example.bestpracticedemo.design.push;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: varys-parent
 * @description: 调用接口，接口返回结果集
 * @author: liusognxin
 * @create: 2018-11-20 16:39
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PushResultInfo {

    private Long id;
    private Long artid;
    private String title;
    private String platform;
}
