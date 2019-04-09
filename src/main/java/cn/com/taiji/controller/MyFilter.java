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

public class MyFilter implements Filter{

	private static Logger logger=LoggerFactory.getLogger(MyFilter.class);

	public static final String User_Key = "user";
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.info("Init");
		System.out.println("成功1");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		logger.info("访问到了过滤器，doFilter");
		HttpServletRequest res = (HttpServletRequest) request;
        HttpServletResponse rep = (HttpServletResponse) response;      
        HttpSession session = res.getSession(false);
        if (session != null && session.getAttribute(User_Key) != null) {
            // session已经存在user，说明已经登录成功, 通过
            chain.doFilter(request, response);
        } else {
            // session不存在user，说明没有登录成功，需要登录
            response.getWriter().write("please call /login first.");
            return ;
        }

        logger.info("LoginFilter 执行完毕");
	}

	@Override
	public void destroy() {
		 logger.info("destroy");
		 System.out.println("销毁1");
	}
	
}
