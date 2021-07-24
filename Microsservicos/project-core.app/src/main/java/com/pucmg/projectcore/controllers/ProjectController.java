package com.pucmg.projectcore.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pucmg.projectcore.entities.ActivityEntity;
import com.pucmg.projectcore.entities.ProjectEntity;
import com.pucmg.projectcore.models.CreateProject;
import com.pucmg.projectcore.models.UpdateActivity;
import com.pucmg.projectcore.services.ActivityService;
import com.pucmg.projectcore.services.ProjectService;

@RestController
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private ActivityService activityService;
	
	@GetMapping("/project/ongoing")
	public ResponseEntity<?> getOngoingProjects(){
		List<ProjectEntity> ongoingProjects = projectService.getOngoingProjects();
		return ResponseEntity.ok(ongoingProjects);
	}
	
	@PostMapping("/project")
	public ResponseEntity<?> createProject(@RequestBody CreateProject form){
		boolean created = projectService.createProject(form);
		if(created) {
			URI uri = null;
			try {uri = new URI(form.getCode());}catch(Exception e) {}
			return ResponseEntity.created(uri).build();
		}else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PutMapping("/activity")
	public ResponseEntity<?> updateActivity(@RequestBody UpdateActivity form){
		ActivityEntity act = activityService.findActivity(form.getActivityId());
		if(act == null) {return ResponseEntity.notFound().build();}
		boolean update = activityService.updateActivity(act, form);
		if(update) {
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.badRequest().build();
		}
	}
}
