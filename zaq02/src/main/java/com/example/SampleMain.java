package com.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.bean.ExampleBean;
import com.example.service.HelloWorldService;

public class SampleMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.example");
		context.refresh();
		context.registerShutdownHook();
		
		int count=context.getBeanDefinitionCount();
		System.out.println("Beans的个数："+count);
		String[] names=context.getBeanDefinitionNames();
		for(String name : names) {
			System.out.println(name+"-->");
			Object bean=context.getBean(name);
			System.out.println(bean.getClass());
		}
		context.getBean("helloService",HelloWorldService.class).sayHello();
		System.out.println(context.getBean(ExampleBean.class).getBeanOne().getName());
	}

}
