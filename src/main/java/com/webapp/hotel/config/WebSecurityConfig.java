package com.webapp.hotel.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.webapp.hotel.service.UserServiceImp;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserServiceImp userDetailsService;
	
	protected void configure(HttpSecurity http) throws Exception {
		http
		.cors().and().csrf().disable()
		.authorizeRequests()
			.antMatchers("/users", "/users/new").permitAll()
			.antMatchers(HttpMethod.POST, "/users/new").permitAll()
			.anyRequest().authenticated()
			.and().formLogin()
			.loginPage("/login.html")
			.failureUrl("/error.html")
		.and()
			.logout()
			.logoutSuccessUrl("/index.html")
		;
	}
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	auth.userDetailsService(userDetailsService).passwordEncoder(getPasswordEncoder()); 
    }
	
}
