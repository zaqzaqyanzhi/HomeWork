package cn.com.taiji.config;

import java.util.List;import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import cn.com.taiji.bean.Authorities;
import cn.com.taiji.bean.users;

@Component
public class CustomerAuthenticationProvider implements AuthenticationProvider{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		//查询用户User
		String username=(String) authentication.getPrincipal();
		String password=(String) authentication.getCredentials();
		
		String sql="select username,password,enabled,phone,email from users where username='"+username+"' and password='"+password+"' ";
		users users=jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(users.class));
		
		String authoritiesSql="select * from users u left join authorities a on u.username=a.username where u.username=a.username";
		List<Authorities> authoritiesList=jdbcTemplate.query(authoritiesSql, new BeanPropertyRowMapper<>(Authorities.class));
		//把用户user转化成authentication对象
		UsernamePasswordAuthenticationToken result
				= new UsernamePasswordAuthenticationToken(
				users,users.getPassword(),authoritiesList);
		result.setDetails(authentication.getDetails());
		return result;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}

	
}
