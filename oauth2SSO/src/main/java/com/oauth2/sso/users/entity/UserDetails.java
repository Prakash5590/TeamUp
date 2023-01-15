package com.oauth2.sso.users.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private @Getter @Setter int userId;
	private @Getter @Setter String userName;
	private @Getter @Setter String password;
	private @Getter @Setter String userType;
	private @Getter @Setter int age;
	private @Getter @Setter char sex;
	private @Getter @Setter String emailId;
	
	public String getPassword() {
		return password;
	}
	public String getUserName() {
		return userName;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", userName=" + userName + ", password=" + password + ", userType="
				+ userType + ", age=" + age + ", sex=" + sex + ", emailId=" + emailId + "]";
	}



	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}



	@ManyToOne
	private @Getter @Setter Role role;

}
