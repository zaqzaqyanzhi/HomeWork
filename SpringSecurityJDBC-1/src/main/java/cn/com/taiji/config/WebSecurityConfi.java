package cn.com.taiji.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import cn.com.taiji.service.CustomAccessControlService;

@Configuration
@EnableWebSecurity(debug=true)
public class WebSecurityConfi extends WebSecurityConfigurerAdapter{

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private CustomerAuthenticationProvider customerAuthenticationProvider;
	
	@Autowired
	private CustomFilter customFilter;
	
	/*@Autowired
	private CustomAccessControlService customAccessControlService;*/
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(customerAuthenticationProvider);
		auth.jdbcAuthentication().dataSource(dataSource);
//		.withDefaultSchema();
//			.withUser("1").password("1").roles("USER")
//			.and().withUser("2").password("2").roles("ADMIN")
//			.and().withUser("3").password("3").authorities("READ");
	}

	
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		super.configure(web);
		web.ignoring().antMatchers("/favicon.ico","/css/**","image/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests()
			.antMatchers("/admin/**")
			.permitAll()
			.antMatchers("/success").access("1>0")
			.anyRequest().access("@customAccessControlService.canAccess(request,authentication)");
			//.anyRequest().authenticated();
		
		http.formLogin();
		
		 //禁用H2控制台的CSRF防护
      http.csrf().ignoringAntMatchers("/h2-console/**");
      //允许来自同一来源的H2控制台的请求
      http.headers().frameOptions().sameOrigin();
      
      http.addFilterBefore(customFilter,UsernamePasswordAuthenticationFilter.class);
	}

}
