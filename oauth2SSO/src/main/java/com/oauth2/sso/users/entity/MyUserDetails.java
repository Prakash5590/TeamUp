package com.oauth2.sso.users.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails implements UserDetails{

	com.oauth2.sso.users.entity.UserDetails userDetails;
	public MyUserDetails(com.oauth2.sso.users.entity.UserDetails userDetails) {
		System.out.println("userDetails ::"+userDetails.toString());
		this.userDetails = userDetails;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		List<SimpleGrantedAuthority> l = new ArrayList<>();
		l.add(new SimpleGrantedAuthority("ADMIN"));
		return l;
		//return new HashSet<GrantedAuthority>();
	}

	@Override
	public String getPassword() {
		return userDetails.getPassword();
	}

	@Override
	public String getUsername() {
		return userDetails.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
