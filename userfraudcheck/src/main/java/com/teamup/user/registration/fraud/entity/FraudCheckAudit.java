package com.teamup.user.registration.fraud.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Accessors(chain = true, fluent = true)
//@Table(name = "fraud_check_audit")
public class FraudCheckAudit {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private @Getter @Setter int id;
	private @Getter @Setter String userId;
	private @Getter @Setter String fraudCheckResult;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFraudCheckResult() {
		return fraudCheckResult;
	}
	public void setFraudCheckResult(String fraudCheckResult) {
		this.fraudCheckResult = fraudCheckResult;
	}
	
	
}
