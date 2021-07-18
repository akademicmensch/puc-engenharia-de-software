package com.pucmg.projectcore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pucmg.projectcore.entities.ProjectEntity;
import com.pucmg.projectcore.services.ProjectService;

@RestController
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@GetMapping("/ongoing")
	public ResponseEntity<?> getOngoingProjects(){
		List<ProjectEntity> ongoingProjects = projectService.getOngoingProjects();
		return ResponseEntity.ok(ongoingProjects);
	}
	
}
