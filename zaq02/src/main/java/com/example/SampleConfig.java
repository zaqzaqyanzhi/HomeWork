package com.example;

import javax.activation.DataSource;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.example.bean.AnotherBean;
import com.example.bean.ExampleBean;
import com.example.bean.YetAnotherBean;
import com.example.service.HelloWorldService;

@Configuration
public class SampleConfig {
	
	@Bean
	public HelloWorldService HelloWorldService() {
		return new HelloWorldService();
	}
	
	@Bean
	public ExampleBean exampleBean() {
		ExampleBean exampleBean=new ExampleBean();
		exampleBean.setBeanOne(anotherBean());
		exampleBean.setBeanTwo(yetAnotherBean());
		return exampleBean;
	}
	
	@Bean("aaa")
	@Primary
	public AnotherBean anotherBean() {
		AnotherBean anotherBean=new AnotherBean();
		anotherBean.setName("i'm anotherBean.");
		return anotherBean;
	}
	
	@Bean
	public YetAnotherBean yetAnotherBean() {
		YetAnotherBean yetAnotherBean=new YetAnotherBean();
		yetAnotherBean.setName("i'm anotherBean.");
		return yetAnotherBean;
	}

	/*@Bean(destroyMethod = "close")
	DataSource dataSource() {
		BasicDataSource ds=new BasicDataSource();
		
		
		return 
		
	}*/
	
	
	
}
