package com.pucmg.projectbff.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pucmg.projectbff.integration.ProjectCoreClient;
import com.pucmg.projectbff.integration.models.CreateProject;
import com.pucmg.projectbff.integration.models.UpdateActivity;

@RestController
public class ProjectBffController {
	
	@Autowired
	private ProjectCoreClient coreClientService;
	
	@GetMapping("/project/ongoing")
	public ResponseEntity<?> getOngoingProjects(){
		return coreClientService.getOngoingProjects();
	}
	
	@PostMapping("/project")
	public ResponseEntity<?> createProject(@RequestBody CreateProject form){
		return coreClientService.createProject(form);
	}
	
	@PutMapping("/activity")
	public ResponseEntity<?> updateActivity(@RequestBody UpdateActivity form){
		return coreClientService.updateActivity(form);
	}
}
