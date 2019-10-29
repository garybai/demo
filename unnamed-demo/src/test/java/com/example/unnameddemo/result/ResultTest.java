package com.example.unnameddemo.result;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * @author Gary
 * @className ResultTest
 * @description TODO
 * @date 2019-09-06 11:04
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ResultTest {

    @Autowired
    private MockMvc mvc;

    @Before
    public void testBefore(){
        System.out.println("before");
    }

    @After
    public void testAfter(){
        System.out.println("after");
    }

    @Test
    public void testNull() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/result/testNull"));
    }

}
