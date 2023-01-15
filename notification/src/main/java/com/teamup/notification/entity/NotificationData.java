package com.teamup.notification.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class NotificationData {
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	private int id;
	private String payload;
	private String mobileId;
	private String userId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPayload() {
		return payload;
	}
	public void setPayload(String payload) {
		this.payload = payload;
	}
	public String getMobileId() {
		return mobileId;
	}
	public void setMobileId(String mobileId) {
		this.mobileId = mobileId;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "NotificationData [id=" + id + ", payload=" + payload + ", mobileId=" + mobileId + ", userId=" + userId
				+ "]";
	}
	
	
	
}
