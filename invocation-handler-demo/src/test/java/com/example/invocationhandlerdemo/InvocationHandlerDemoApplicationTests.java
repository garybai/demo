package com.example.invocationhandlerdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvocationHandlerDemoApplicationTests {

	@Resource(name = "helloService")
	IHelloService helloService;

//	@Resource(name = "staticProxy")
//	StaticProxy staticProxy;

	@Test
	public void contextLoads() {

//		helloService.sayHello("Gary");
//		helloService.sayGoodBye("Gary");

//		staticProxy.sayHello("Gary");
//		staticProxy.sayGoodBye("Gary");

		DynamicProxy dynamicProxy = new DynamicProxy();
		IHelloService iHelloService = (IHelloService) dynamicProxy.bind(helloService);
		iHelloService.sayHello("Gary");
		iHelloService.sayGoodBye("Gary");

	}

}
