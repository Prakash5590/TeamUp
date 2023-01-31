package com.oauth2.sso.service;

import com.oauth2.sso.delegate.FraudCheckServiceDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.oauth2.sso.dao.UserDetailsRepository;
import com.oauth2.sso.users.entity.MyUserDetails;
import com.oauth2.sso.users.entity.UserDetails;

@Service
public class MyUserDetailsService implements UserDetailsService{
	@Autowired
	private UserDetailsRepository userDetailsRepo;

	@Autowired
	private FraudCheckServiceDelegate delegate;

	//@Autowired
	//private BCryptPasswordEncoder pwdEncoder;

	public void saveUser( UserDetails user ) {
		System.out.println("Calling Fraud check delegate :: "+user.getUserName());
		delegate.checkFraud(user.getUserName());
		//user.setPassword(pwdEncoder.encode(user.getPassword()));
		userDetailsRepo.save(user);

	}
	@Override
	public MyUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("username :: "+username);

		return new MyUserDetails( userDetailsRepo.findByUserName(username));
	}

}
