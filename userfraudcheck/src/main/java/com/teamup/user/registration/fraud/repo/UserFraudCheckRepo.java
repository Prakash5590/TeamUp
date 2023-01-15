package com.teamup.user.registration.fraud.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.teamup.user.registration.fraud.entity.FraudCheckAudit;

public interface UserFraudCheckRepo extends JpaRepository<FraudCheckAudit, Integer>{
	
}
