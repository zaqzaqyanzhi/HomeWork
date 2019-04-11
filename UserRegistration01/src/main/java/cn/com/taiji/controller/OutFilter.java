package cn.com.taiji.controller;

import java.io.IOException;

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


import cn.com.taiji.dao.User;

public class OutFilter implements Filter{

	private static Logger logger=LoggerFactory.getLogger(OutFilter.class);
	
	 public static final String User_Key = "user";
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.info("Init");
		System.out.println("成功3");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		logger.info("访问到了过滤器2，doFilter2");
		 HttpServletRequest res = (HttpServletRequest) request;
	     HttpServletResponse rep = (HttpServletResponse) response;
	     HttpSession session = res.getSession(false);
	     String path=res.getServletPath();
	     
	     if ("/logout".equals(path)) {
	            // 如果当前调用的是登出接口
	            if (session == null || session.getAttribute(User_Key) == null) {
	                //用户session不存在，处于已经登出状态，直接返回
	                response.getWriter().write("User has logouted .");
	                return;
	            }
	            // 如果是登出端口，则直接删除session进行登出操作，不用进入到controller 层
	            session.removeAttribute(User_Key);
	            response.getWriter().write("Logout success!");
	            return;
	        }

	        chain.doFilter(request, response);
	        logger.info("LogoutFilter 执行完毕");
	}

	@Override
	public void destroy() {
		 logger.info("destroy");
		 System.out.println("销毁3");
	}

	
}
