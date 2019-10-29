package com.example.simplejdbcdemo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @ClassName Foo
 * @Description TODO
 * @Author Gary
 * @Date 2019-04-06 09:10
 **/
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class Foo {

    private Long id;
    private String bar;

}
