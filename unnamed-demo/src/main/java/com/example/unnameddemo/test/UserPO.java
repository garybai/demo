package com.example.unnameddemo.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Gary
 * @className UserPO
 * @description TODO
 * @date 2019-09-24 17:12
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPO {

    private Long id;

    private String name;

    private Integer age;

    private String tags;

    private CarPO carPO;

}
