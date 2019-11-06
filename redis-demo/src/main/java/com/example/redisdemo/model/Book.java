package com.example.redisdemo.model;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author Gary
 * @className Book
 * @description TODO
 * @date 2019-11-05 17:36
 **/
@Data
@Accessors(chain = true)
@ToString
public class Book implements Serializable {

    private Long bookId;

    private String bookName;

}
