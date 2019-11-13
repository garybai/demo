package com.example.mybatisplusdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplusdemo.domain.BookDO;

import java.util.List;

public interface BookMapper extends BaseMapper<BookDO> {

    List<BookDO> findBookByAuthorName(String name);

    IPage<BookDO> findBookByAuthorId(Page<BookDO> page, Integer id);
}
