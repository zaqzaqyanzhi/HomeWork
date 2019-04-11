package cn.com.taiji.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.taiji.service.BankService;

@Controller
public class MainController {
@Autowired
public   BankService  bankService;
	@GetMapping("/")
	public String hello() {
		return "home";
	}
	@GetMapping("/user")
	public String hello1() {
		return bankService.post();
	}
	@GetMapping("/admin")
	public String hello2() {
		return "home";
	}
	@GetMapping("/read")
	public String hello3() {
		return "home";
	}
	
	@GetMapping("/users")
	public String user() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username=null;
		if (principal instanceof UserDetails) {
			 username = ((UserDetails)principal).getUsername();
			} else {
			 username = principal.toString();
			}
		System.out.println(username);
		return "home";
	}
}
