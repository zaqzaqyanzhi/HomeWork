package cn.com.taiji.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/loginP")
    public String login() {
        return "loginPage";
    }

}
