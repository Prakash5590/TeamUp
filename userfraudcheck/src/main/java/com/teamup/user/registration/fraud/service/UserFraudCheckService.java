package com.teamup.user.registration.fraud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamup.user.registration.fraud.entity.FraudCheckAudit;
import com.teamup.user.registration.fraud.repo.UserFraudCheckRepo;

@Service
public class UserFraudCheckService {
	
	@Autowired
	private UserFraudCheckRepo repo;
	
	public boolean checkForFraud(String userId) {
		FraudCheckAudit audit = new FraudCheckAudit();
		audit.setUserId(userId);
		audit.setFraudCheckResult("audit check is success for user : "+userId);
		repo.save(audit);
		System.out.println("Checking fraud for user "+userId);
		return true;
	}
}
