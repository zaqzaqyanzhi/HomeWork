package cn.com.taiji.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class HttpBasicAuthenticationFilter implements Filter{
	
	private static Logger logger=LoggerFactory.getLogger(HttpBasicAuthenticationFilter.class);

	public static final String User_Key = "user";
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		Filter.super.init(filterConfig);
		logger.info("Init");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		logger.info("访问到了过滤器HttpBasicAuthenticationFilter，doFilter");
		HttpServletRequest res = (HttpServletRequest) request;
        HttpServletResponse rep = (HttpServletResponse) response;      
        String header=res.getHeader("Authorization");
		if(header == null || !header.toLowerCase().startsWith("basic")) {
			 // 如果不是basic认证，则继续后续逻辑
			chain.doFilter(request, response);
			return ;
		}
		byte[] base64Token=header.substring(6).getBytes("UTF-8");
		byte[] decoded=Base64.getDecoder().decode(base64Token);
		String token=new String(decoded,"UTF-8");
		int delim=token.indexOf(":");
		if(delim==-1) {
			response.getWriter().write("Invalid basic authentication token\"");
			return ;
		}
		 String username=token.substring(0, delim);
		 String password =token.substring(delim+1);
		 logger.info("Basic认证，Http头信息：user '" + username + "'");
		 if(!MainController.userList.contains(new HashMap() {{
            put(username, password);
        }})) {
			// Basic用户名和密码不对,报错
	            response.getWriter().write("Invalid basic authentication password or username\"");
	            return;
		 }
		 
		//如果有这个用户那么登录成功
	     HttpSession session=res.getSession();
		 if(session.getAttribute(User_Key)==null) {
			 //用户session不存在，则新建session
			 session.setAttribute(User_Key, username);
		 }
		 chain.doFilter(request, response);
		 logger.info("HttpBasicAuthenticationFilter执行完毕");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		Filter.super.destroy();
		logger.info("destroy");
	}

}
