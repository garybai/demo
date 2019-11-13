package com.example.unnameddemo.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Gary
 * @className UserDTO
 * @description TODO
 * @date 2019-09-24 17:13
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;

    private String name;

    private List<String> tags;

    private CarPO carPO;

}
