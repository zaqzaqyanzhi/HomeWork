package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.service.MessageService;

@SpringBootApplication
public class Boot003Application implements CommandLineRunner{

	@Autowired
	private MessageService helloWorldService;
	
	@Override
	public void run(String... args) {
		System.out.println(this.helloWorldService.getMessage());
		
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(Boot003Application.class, args);
	}
}
