package com.example.mybatisplusdemo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplusdemo.domain.AuthorDO;
import com.example.mybatisplusdemo.domain.BookDO;
import com.example.mybatisplusdemo.service.IAuthorService;
import com.example.mybatisplusdemo.service.IBookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisPlusDemoApplicationTests {

    @Autowired
    IBookService bookService;

    @Autowired
    IAuthorService authorService;

    @Test
    public void test1() {
        for (int i = 8; i < 10; i++) {
            BookDO bookDO = new BookDO();
            bookDO.setName("第" + (i + 1) + "本书");
            bookDO.setAuId(3);
            bookService.save(bookDO);
        }
    }

    @Test
    public void test2() {
        for (int i = 2; i < 3; i++) {
            AuthorDO authorDO = new AuthorDO();
            authorDO.setName("作者" + (i + 1));
            authorService.save(authorDO);
        }
    }

    @Test
    public void test3() {
        List<BookDO> list = bookService.list();
        list.forEach(System.out::println);
    }

    @Test
    public void test4() {
        IPage<BookDO> page = bookService.page(new Page<>(1, 2));
        System.out.println("当前页：" + page.getCurrent());
        System.out.println("总页数：" + page.getPages());
        List<BookDO> records = page.getRecords();
        System.out.println("内容：");
        records.forEach(System.out::println);
        System.out.println("总条数：" + page.getTotal());
        System.out.println("每页条数：" + page.getSize());
    }

    @Test
    public void test5() {
        BookDO bookDO = new BookDO();
        bookDO.setId(2);
        bookDO.setName("第二本书");
        bookService.updateById(bookDO);
    }

    @Test
    public void test6() {
        List<BookDO> books = bookService.findBookByAuthorName("作者1");
        books.forEach(System.out::println);
    }

    @Test
    public void test7() {
        IPage<BookDO> page = bookService.findBookByAuthorId(1, 1, 2);
        System.out.println("当前页：" + page.getCurrent());
        System.out.println("总页数：" + page.getPages());
        List<BookDO> records = page.getRecords();
        System.out.println("内容：");
        records.forEach(System.out::println);
        System.out.println("总条数：" + page.getTotal());
        System.out.println("每页条数：" + page.getSize());
    }

    @Test
    public void test8(){
        List<AuthorDO> list = authorService.findAuthorByName("作者1");
        list.forEach(System.out::println);
    }

}
