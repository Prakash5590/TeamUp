package com.teamup.notification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamup.notification.entity.NotificationData;
import com.teamup.notification.repo.NotificationRepo;

@Service
public class NotificationService {
	
	@Autowired
	NotificationRepo repo;

	public String sendNotification( NotificationData data) {
		//send notification here..
		repo.save(data);
		return "Notification sent to userId"+data.getUserId();
	}
}
