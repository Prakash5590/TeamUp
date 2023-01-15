package com.teamup.notification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamup.notification.entity.NotificationData;
import com.teamup.notification.service.NotificationService;

@RestController
@RequestMapping("/api/notification")
public class NotificationController {

	@Autowired
	private NotificationService service;
	
	@PostMapping("/send")
	public ResponseEntity<String> sendNotification(@RequestBody NotificationData data){
		return ResponseEntity.ok(service.sendNotification(data));
	}
}
