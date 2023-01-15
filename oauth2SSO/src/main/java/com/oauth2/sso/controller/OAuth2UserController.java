package com.oauth2.sso.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oauth2.sso.service.MyUserDetailsService;
import com.oauth2.sso.users.entity.MyUserDetails;
import com.oauth2.sso.users.entity.UserDetails;

@RestController
@RequestMapping("/api/user")
public class OAuth2UserController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OAuth2UserController.class);
	
	@Autowired
	private MyUserDetailsService userService;
	@Autowired 
	private PasswordEncoder encoder;
	
	@PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	//@PreAuthorize("permitAll")
	public ResponseEntity<String> createNewUser(@RequestBody UserDetails user) {
		LOGGER.info("------>{}", user);
		userService.saveUser(user);
		ResponseEntity<String> response = ResponseEntity.ok("User created.");
		return response;
	}
	
	@GetMapping(value = "/get/{userName}")
	//@PreAuthorize("permitAll")
	public ResponseEntity<MyUserDetails> getSpecificUser(@PathVariable String userName){
		LOGGER.info("------>{}", userName);
		MyUserDetails u = userService.loadUserByUsername(String.valueOf(userName));
		ResponseEntity<MyUserDetails> response = ResponseEntity.ok(u);
		//Retrieve data
		return response;
	}
	
	@GetMapping("/pwd/encrypt/{password}")
	public ResponseEntity<String> encryptPassword(@PathVariable String password){
		
		return ResponseEntity.ok(encoder.encode(password));
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable int userIdToBeDeleted){
		LOGGER.info("--->{}",userIdToBeDeleted);
		ResponseEntity<String> response = ResponseEntity.ok("User deleted successfully.");
		//delete user
		return response;
	}
}
