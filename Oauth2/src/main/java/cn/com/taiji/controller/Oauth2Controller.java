package cn.com.taiji.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Oauth2Controller {

	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	//Priciple
}
