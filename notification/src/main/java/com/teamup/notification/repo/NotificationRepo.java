package com.teamup.notification.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teamup.notification.entity.NotificationData;

@Repository
public interface NotificationRepo extends JpaRepository<NotificationData, Integer>{

}
