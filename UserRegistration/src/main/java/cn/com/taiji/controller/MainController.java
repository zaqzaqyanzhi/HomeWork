package cn.com.taiji.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;


import cn.com.taiji.dao.User;


@RestController
//@SessionAttributes("user")
public class MainController {
	
	private static Logger logger=LoggerFactory.getLogger(MyFilter.class);
	
	/*public static List<Map> userList = new ArrayList() {{
        add(new HashMap() {{
            put("user", "user");
        }});
        add(new HashMap() {{
            put("admin", "admin");
        }});
    }};*/
	
	public static List<Map> userList = new ArrayList() {{
        add(new HashMap() {{
            put("user", "upassword");
        }});
        add(new HashMap() {{
            put("admin", "apassword");
        }});
    }};
	
	/*@GetMapping("/login")
	@ResponseBody
	public String login(User user,HttpServletRequest request) {
		request.getSession().setAttribute(MyFilter2.User_Key, user);
		logger.info(user.toString());
		return "login";
	}*/
    
    @RequestMapping("/login")
    public String login(HttpServletRequest request, String user, String upassword) {
		HttpSession session=request.getSession();
		if (userList.contains(new HashMap() {{
            put(user, upassword);
        }})) {
            //如果有这个用户那么登录成功
            session.setAttribute(MyFilter.User_Key, user);
            return "登录成功,您可以访问接口了";
        }

        return "登录失败，请求检查您的用户名和密码";
    }
  
	
	@RequestMapping("/a")
	@ResponseBody
	public String a(String admin,String apassword) {
		if(admin.equals("user") && apassword.equals("upassword")) {
			return "success a";
		}else {
			
			return "false a";
		}
	}
	@RequestMapping("/b")
	@ResponseBody
	public String b(String admin,String apassword) {
		if(admin.equals("user") && apassword.equals("upassword")) {
			return "success b";
		}else {
			
			return "false b";
		}
	}
}
