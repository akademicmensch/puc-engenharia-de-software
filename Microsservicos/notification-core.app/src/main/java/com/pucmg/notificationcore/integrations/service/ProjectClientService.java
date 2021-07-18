package com.pucmg.notificationcore.integrations.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.pucmg.notificationcore.integrations.models.Activity;
import com.pucmg.notificationcore.integrations.models.ProjectModelDTO;

@Service
public class ProjectClientService {
	
	private static final Logger logger = LoggerFactory.getLogger(ProjectClientService.class);
	
	public List<ProjectModelDTO> findOngoingProjects(){
		return new ArrayList<>();
	}
	
	public List<Activity> findOngoingActivities(){
		return new ArrayList<>();
	}

	public void upadteProjectToDelay(Long id) {
		logger.debug("Updating project {} to color red", id);
	}

	public void upadteActivityToDelay(Long id) {
		logger.debug("Updating activity {} to color red", id);
	}
	
}
