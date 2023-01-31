package com.oauth2.sso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableFeignClients
@EnableAspectJAutoProxy(exposeProxy = false)
public class OAuth2SSOApplication {

	public static void main(String[] args) {
		SpringApplication.run(OAuth2SSOApplication.class, args);
	}

}
