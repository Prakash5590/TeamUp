package com.oauth2.sso.users.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Permission {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private @Getter @Setter int permissionId;
	private @Getter @Setter String permissionName;
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST, mappedBy = "permissions")
	private Set<Role> roles;
	

}
