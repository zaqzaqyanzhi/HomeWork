package com.example.bean;

import org.springframework.stereotype.Component;

@Component
public class AnotherBean {

	private String name="AnotherBean";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
