package com.oauth2.sso.users.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "role")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private @Getter @Setter int roleId;
	private @Getter @Setter String roleName;
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinTable(
			name = "role_permission",
			joinColumns = {@JoinColumn(name = "role_id")},
			inverseJoinColumns = {@JoinColumn(name = "permission_id")})
	private Set<Permission> permissions;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "role_id")
	private Set<UserDetails> users;
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Set<Permission> getPermissions() {
		return permissions;
	}
	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}
	public Set<UserDetails> getUsers() {
		return users;
	}
	public void setUsers(Set<UserDetails> users) {
		this.users = users;
	}
	

}
