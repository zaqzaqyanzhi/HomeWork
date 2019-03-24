package com.example;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.bean.ExampleBean;
import com.example.service.HelloWorldService;

public class SampleConfigTest {

	private AnnotationConfigApplicationContext context;
	
	@Before
	public void InitialContext() {
		context=new AnnotationConfigApplicationContext(SampleConfig.class);
		context.registerShutdownHook();
		int count=context.getBeanDefinitionCount();
		System.out.println("Beans的个数：" + count);
		String[] names=context.getBeanDefinitionNames();
		for(String name : names) {
			System.out.println(name+"--->");
			Object bean=context.getBean(name);
			System.out.println(bean.getClass());
		}
	}
	
	@Test
	public void testExampleBean() {
		System.out.println(context.getBean(ExampleBean.class).getBeanOne().getName());
	}
	
}
