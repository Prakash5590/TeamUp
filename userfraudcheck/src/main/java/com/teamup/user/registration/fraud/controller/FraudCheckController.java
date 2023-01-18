package com.teamup.user.registration.fraud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamup.user.registration.fraud.service.UserFraudCheckService;

@RestController
@RequestMapping("/teamup/api/user/fraudcheck")
public class FraudCheckController {
	private Logger LOGGER = LoggerFactory.getLogger(FraudCheckController.class);
	@Autowired
	private UserFraudCheckService service;
	
	@GetMapping(value = "/check/{userId}")
	public ResponseEntity<String> checkForFraud(@PathVariable String userId){
		LOGGER.info("checking for fraud for user : {}", userId);
		service.checkForFraud(userId);
		return ResponseEntity.ok("Fraud Check is done for user : "+userId);
	}
}
