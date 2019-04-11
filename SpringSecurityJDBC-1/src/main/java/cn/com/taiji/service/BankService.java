package cn.com.taiji.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
public class BankService {

	@GetMapping("role_user")
	public String post() {
		return "我是被保护的方法";
	}
}
