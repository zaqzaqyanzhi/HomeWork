package com.example;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.service.HelloWorldService;

public class BeansXmlTest {

	private AbstractApplicationContext context;
	public BeansXmlTest() {
		context=new ClassPathXmlApplicationContext("beans.xml");
		context.registerShutdownHook();
		System.out.println("ApplicationContext hashCode:"+context.hashCode());
	}
	
	@Test
	public void testHelloService() {
		HelloWorldService service=context.getBean("helloService",HelloWorldService.class);
		service.sayHello();
	}
}
