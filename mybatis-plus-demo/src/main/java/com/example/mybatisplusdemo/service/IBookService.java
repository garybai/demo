package com.example.mybatisplusdemo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mybatisplusdemo.domain.BookDO;

import java.util.List;

/**
 * @author Gary
 * @className IBookService
 * @description TODO
 * @date 2019-11-11 15:17
 **/
public interface IBookService extends IService<BookDO> {

    List<BookDO> findBookByAuthorName(String name);

    IPage<BookDO> findBookByAuthorId(Integer id, Integer pageNum, Integer pageSize);
}
