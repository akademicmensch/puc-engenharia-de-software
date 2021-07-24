package com.pucmg.projectcore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pucmg.projectcore.entities.ActivityEntity;
import com.pucmg.projectcore.entities.UserEntity;
import com.pucmg.projectcore.models.UpdateActivity;
import com.pucmg.projectcore.repositories.ActivityRepository;
import com.pucmg.projectcore.repositories.StatusRepository;
import com.pucmg.projectcore.repositories.UserRepository;

@Service
public class ActivityService {
	
	@Autowired
	private ActivityRepository activityRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private StatusRepository statusRepository;

	public ActivityEntity findActivity(Long activityId) {
		return activityRepository.findById(activityId).orElse(null);
	}

	public boolean updateActivity(ActivityEntity act, UpdateActivity form) {
		boolean retorno = true;
		
		UserEntity userEntity = userRepository.findById(form.getUser()).get();
		if(userEntity.getId().intValue() == form.getUser().intValue() || userEntity.getRole().getDescription().equalsIgnoreCase("Manager")) {
			if(form.getDescription() != null) {act.setDescription(form.getDescription());}
			if(form.getUpdateStatus() != null) {act.setStatus(statusRepository.findByDescription(form.getDescription()));}
			activityRepository.save(act);
		}else {
			retorno = false;
		}
		return retorno;
	}

}
