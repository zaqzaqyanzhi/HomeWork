package cn.com.taiji.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainControlller {

	@GetMapping({"/", "/home"})
    public String home() {
        return "home";
    }

}
