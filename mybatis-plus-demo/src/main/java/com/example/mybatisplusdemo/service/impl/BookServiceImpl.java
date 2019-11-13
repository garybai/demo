package com.example.mybatisplusdemo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mybatisplusdemo.domain.BookDO;
import com.example.mybatisplusdemo.mapper.BookMapper;
import com.example.mybatisplusdemo.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Gary
 * @className BookServiceImpl
 * @description TODO
 * @date 2019-11-11 15:18
 **/
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, BookDO> implements IBookService {

    @Autowired
    BookMapper bookMapper;

    @Override
    public List<BookDO> findBookByAuthorName(String name) {
        return bookMapper.findBookByAuthorName(name);
    }

    @Override
    public IPage<BookDO> findBookByAuthorId(Integer id, Integer pageNum, Integer pageSize) {
        Page<BookDO> page = new Page<>(pageNum, pageSize);
        return bookMapper.findBookByAuthorId(page, id);
    }
}
