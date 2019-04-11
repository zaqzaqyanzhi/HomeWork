package cn.com.taiji;

import javax.servlet.Filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

import cn.com.taiji.controller.HttpBasicAuthenticationFilter;
import cn.com.taiji.controller.MyFilter;
import cn.com.taiji.controller.MyFilter2;
import cn.com.taiji.controller.OutFilter;



@SpringBootApplication
public class UserRegistrationApplication {

	/*@Bean
	@Order(1)
	public FilterRegistrationBean setFilter1() {
		FilterRegistrationBean registration=new FilterRegistrationBean();
		registration.setFilter(outFilter());
		registration.addUrlPatterns("/*");
		registration.setName("OutFilter");
		//registration.setOrder(1);
		return registration;
		
	}
	
	private Filter outFilter() {
		// TODO Auto-generated method stub
		return new OutFilter();
	}*/

	/*@Bean
	@Order(2)
	public FilterRegistrationBean setFilter2() {
		FilterRegistrationBean registration=new FilterRegistrationBean();
		registration.setFilter(new HttpBasicAuthenticationFilter());
		registration.addUrlPatterns("/*");
		registration.setName("HttpBasicAuthenticationFilter");
		//registration.setOrder(1);
		return registration;
		
	}*/
	
	/* public FilterRegistrationBean filterDemo3Registration() {
	        FilterRegistrationBean registration = new FilterRegistrationBean();
	        registration.setFilter(filterDemo3());
	        registration.addUrlPatterns("/*");
	        registration.addInitParameter("paramName", "paramValue");
	        registration.setName("filterDemo3");
	        registration.setOrder(6);
	        return registration;
	    }*/
	@Bean
	@Order(3)
	public FilterRegistrationBean setFilter3() {
		FilterRegistrationBean registration=new FilterRegistrationBean();
		registration.setFilter(new MyFilter());
		registration.addUrlPatterns("/a","/b");
		registration.setName("MyFilter");
		//registration.setOrder(10);
		return registration;
		
	}
	
	/*@Bean
	@Order(4)
	public FilterRegistrationBean setFilter4() {
		FilterRegistrationBean registration2=new FilterRegistrationBean();
		registration2.setFilter(new MyFilter2());
		registration2.addUrlPatterns("/a","/b");
		registration2.setName("MyFilter2");
		//registration2.setOrder(100);
		return registration2;
		}*/
	
	public static void main(String[] args) {
		SpringApplication.run(UserRegistrationApplication.class, args);
		
		
	}

}
