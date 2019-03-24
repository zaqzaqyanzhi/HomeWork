package com.example;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.example.service.HelloWorldService;

public class ApplicationContextTest {

	private AbstractApplicationContext context;
	public ApplicationContextTest() {
		context=new FileSystemXmlApplicationContext("classpath:/META-INF/application-context.xml");
		context.registerShutdownHook();
	}
	
	@Test
	public void testApplicationTest() {
		HelloWorldService helloWorldService=context.getBean("helloWorldService",HelloWorldService.class);
		helloWorldService.sayHello();
	}
}
