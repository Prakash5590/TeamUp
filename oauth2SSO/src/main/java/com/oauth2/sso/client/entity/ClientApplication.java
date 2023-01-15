package com.oauth2.sso.client.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ClientApplication {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private @Getter @Setter String clientId;
	private @Getter @Setter String clientName;
	private @Getter @Setter String clientCred;
	private @Getter @Setter int accessTokenValidity;
	private @Getter @Setter String scope;
	private @Getter @Setter String authorities;
	private @Getter @Setter String authorizedgrantTypes;
	private @Getter @Setter String resourceIds;
	private @Getter @Setter int refreshTokenValidity;
	private @Getter @Setter String webServerRedirectURL;
	private @Getter @Setter String autoApprove;
	private @Getter @Setter String additionalInfo;

}
