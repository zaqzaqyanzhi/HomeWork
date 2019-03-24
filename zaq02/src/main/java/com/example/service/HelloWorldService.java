package com.example.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value="helloWorldService")
public class HelloWorldService {

	@Value("${name:World}")
	private String name;
	
	public String getHelloMessage() {
		return "Hello"+this.name;
		
	}
	
	public void sayHello() {
		System.out.println("Hello"+this.name);
	}
	
}
