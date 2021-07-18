package com.pucmg.projectcore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pucmg.projectcore.entities.ProjectEntity;
import com.pucmg.projectcore.repositories.ProjectRepository;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;

	public List<ProjectEntity> getOngoingProjects() {
		return projectRepository.findAll();
	}

}
