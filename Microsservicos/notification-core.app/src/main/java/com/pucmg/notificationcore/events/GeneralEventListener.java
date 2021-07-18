package com.pucmg.notificationcore.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.pucmg.notificationcore.services.NotificationService;

@Component
@EnableScheduling 
public class GeneralEventListener {
	
	@Autowired
	private NotificationService notificationService;
	
	private static final String TIME_ZONE = "America/Sao_Paulo";
	
	@Scheduled(cron = "0 0 12 * * *", zone = TIME_ZONE) 
	public void verifyDelayOnTasks() {
		notificationService.runTaskSequence();
	}
	
	@Scheduled(cron = "0 0 12 * * *", zone = TIME_ZONE) 
	public void verifyDelayOnProjects() {
		notificationService.runProjectSequence();
	}
	
}
