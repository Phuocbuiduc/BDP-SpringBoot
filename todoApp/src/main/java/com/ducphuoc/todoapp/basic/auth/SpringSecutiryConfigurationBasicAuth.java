package com.ducphuoc.todoapp.basic.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringSecutiryConfigurationBasicAuth extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
//		http.authorizeRequests((requests) -> requests.anyRequest().authenticated());
		http.authorizeRequests()
	      .antMatchers(HttpMethod.OPTIONS,"/**").permitAll()//allow CORS option calls
//	      .antMatchers("/resources/**").permitAll()
	      .anyRequest().authenticated()
	      .and();
//		http.formLogin();
		http.httpBasic();
	}

}
