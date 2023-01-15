package com.oauth2.sso.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oauth2.sso.client.entity.ClientApplication;

public interface ClientRepository extends JpaRepository<ClientApplication, Integer>{
	public ClientApplication getClientByClientName(String clientName);
}
