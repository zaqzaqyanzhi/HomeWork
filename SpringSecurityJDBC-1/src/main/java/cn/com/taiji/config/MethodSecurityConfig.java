package cn.com.taiji.config;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;

@EnableGlobalMethodSecurity(securedEnabled = true)
public class MethodSecurityConfig {

	
}
