package com.example;

import javax.naming.Context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.bean.ExampleBean;
import com.example.service.HelloWorldService;

public class SampleMain {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("classpath:/META-INF/application-context.xml");     
		int count=context.getBeanDefinitionCount();
		System.out.println("Beans的个数："+count);
		
		String[] names=context.getBeanDefinitionNames();
		for(String name : names) {
			System.out.println(name+"--->");
			Object bean=context.getBean(name);
			System.out.println(bean.getClass());
		}
		context.getBean("helloWorldService",HelloWorldService.class).sayHello();
		System.out.println(context.getBean("exampleBean",ExampleBean.class).getBeanOne());
		System.out.println(context.getBean("exampleBean",ExampleBean.class).getBeanTwo());
	}
}
















