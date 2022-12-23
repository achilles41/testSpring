package com.tutflix.tutflix.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@EnableWebSecurity
@RequiredArgsConstructor
public class webSecurity {

	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
	{
		
		 http
	        .cors().and()
	        .csrf().disable().authorizeRequests()
	        .requestMatchers("/v1").hasRole("manager")
	        .anyRequest().authenticated()
	        .and();
	        return http.build();
	        
		 
		
		
 
	}
	
	@Bean
 	public UserDetailsService userDetailsService() {
 		UserDetails user = User.withDefaultPasswordEncoder()
 			.username("user")
 			.password("password")
 			.roles("USER")
 			.build();
 		UserDetails admin = User.withDefaultPasswordEncoder()
 			.username("admin")
 			.password("password")
 			.roles("ADMIN", "USER")
 			.build();
 		return new InMemoryUserDetailsManager(user, admin);
 	}

}
