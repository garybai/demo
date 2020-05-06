package com.example.springboottestdemo;

import com.example.springboottestdemo.service.HelloService;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootTestDemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SpringbootTestDemoApplicationTests {

    @Autowired
    private HelloService service;

    @Autowired
    private TestRestTemplate restTemplate;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before Class...");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After Class...");
    }

    @Before
    public void before() {
        System.out.println("-------before-------");
    }

    @After
    public void after() {
        System.out.println("-------after-------");
    }

    @Test
    public void testHello() {
        String hello = service.hello();
        assert hello.equalsIgnoreCase("hello");
    }

    @Test
    public void testHello1() {
        String hello = service.hello();
        assert hello.equalsIgnoreCase("hello");
    }

    @Test
    public void testController() {
//        TestRestTemplate restTemplate = new TestRestTemplate();
        ResponseEntity<String> entity = restTemplate.getForEntity("/test?id={id}", String.class, 10);
        System.out.println(entity.getBody());
    }

}
