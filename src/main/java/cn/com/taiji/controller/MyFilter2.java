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

public class MyFilter2 implements Filter{

	private static Logger logger=LoggerFactory.getLogger(MyFilter2.class);
	
	//public static final String User_Key="user";

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		Filter.super.init(filterConfig);
		System.out.println("成功2");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		logger.info("访问到了过滤器2，doFilter2");
		HttpServletRequest res = (HttpServletRequest) request;
        HttpServletResponse rep = (HttpServletResponse) response;
        
        HttpSession session = res.getSession(false);
		
        if (session != null && session.getAttribute(MyFilter.User_Key)!=null){
            String username = (String) session.getAttribute(MyFilter.User_Key);

            String path = res.getServletPath();
            if(("user").equals(username) && !path.equals("/a")){
                // 用户user只能访问端口a
                // session不存在user，说明没有登录成功，需要登录
                response.getWriter().write("user could only visit '/a'");
                return ;
            }
        }
        chain.doFilter(request, response);
        logger.info("AccessControlFilter用来进行访问控制 执行完毕");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		Filter.super.destroy();
		System.out.println("销毁2");
	}
	
	/*@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse hsres=(HttpServletResponse)response;
		logger.info("访问到了过滤器2，doFilter");
		User user=(User)req.getSession().getAttribute("user");
		if(req.getRequestURI().contains("")) {
			
		}
		
	}*/

}
