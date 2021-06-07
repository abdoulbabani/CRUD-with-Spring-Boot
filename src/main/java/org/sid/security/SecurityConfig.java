package org.sid.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	 @Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		 auth.inMemoryAuthentication().withUser("user1").password("{noop}1234").roles("user");
		 auth.inMemoryAuthentication().withUser("user2").password("{noop}1234").roles("user");
		 auth.inMemoryAuthentication().withUser("user3").password("{noop}1234").roles("user","ADMIN");
		 
		 
	}

	 
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		 http.formLogin(); 
		http.authorizeRequests().antMatchers("/save**/**","/delesupprimer**/**").hasRole("ADMIN");
		http.authorizeRequests().anyRequest().authenticated();
		http.csrf();
	}
	
	

}
