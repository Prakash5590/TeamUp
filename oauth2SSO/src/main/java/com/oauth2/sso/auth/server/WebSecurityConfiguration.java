package com.oauth2.sso.auth.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.oauth2.sso.service.MyUserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration {
	@Autowired
	private MyUserDetailsService userService;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	/*
	@Bean
	public AuthenticationManager authManager( AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
	*/
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userService);
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable().httpBasic().and()
				.authorizeHttpRequests(auth -> auth.requestMatchers("/api/user/register").permitAll()
						.requestMatchers("/api/user/pwd/encrypt/**").permitAll()
						.requestMatchers("/api/user/get/**").hasAuthority("ADMIN"));
				;
		http.authenticationProvider(authenticationProvider());
		return http.build();
	}
	
	/*
	
	@Bean
	public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder bcryptEncoder, UserDetailsService detailsService) throws Exception{
		return http.getSharedObject(AuthenticationManagerBuilder.class)
				.userDetailsService(detailsService)
				.passwordEncoder(bcryptEncoder)
				.and()
				.build();
	}
	*/
	
}
