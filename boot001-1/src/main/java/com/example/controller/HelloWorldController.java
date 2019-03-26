package com.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@Value("${name}")
	private String name;
	
	@RequestMapping("/hello")
	public String index() {
		return "Hello World";
	}
}
