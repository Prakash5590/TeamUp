package com.oauth2.sso.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oauth2.sso.users.entity.UserDetails;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Integer>{
	public UserDetails findByUserName(String userName);
	
}
