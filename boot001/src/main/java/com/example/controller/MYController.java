package com.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MYController {
	@Value("${my.name}")
	private String name;
	
	@Value("${my.age}")
	private int age;
	
	@RequestMapping("/heihei")
	public String my() {
		return name+":"+age;
	}
}
