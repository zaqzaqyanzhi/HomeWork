/*package cn.com.taiji.controller;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyConfig implements WebMvcConfigurer{

	@Bean
	MyFilter myFilter() {
		return new MyFilter();
	}
	
	@Bean
	MyFilter2 myFilte2() {
		return new MyFilter2();
	}
	
	@Bean
	public FilterRegistrationBean setFilterRegistration() {
		FilterRegistrationBean registration=new FilterRegistrationBean();
		registration.setFilter(myFilter());
		registration.addUrlPatterns("/");
		registration.addUrlPatterns("/a");
		registration.setName("myFilter");
		//registration.setOrder(1);
		return registration;
		
	}
	
	@Bean
	public FilterRegistrationBean setFilterRegistration2() {
		FilterRegistrationBean registration2=new FilterRegistrationBean();
		registration2.setFilter(myFilter());
		registration2.addUrlPatterns("/");
		registration2.addUrlPatterns("/a");
		registration2.setName("myFilter2");
		registration2.setOrder(2);
		return registration2;
		
	}
	
}*/
