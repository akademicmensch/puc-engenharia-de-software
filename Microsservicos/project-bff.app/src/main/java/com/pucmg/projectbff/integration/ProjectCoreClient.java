package com.pucmg.projectbff.integration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.pucmg.projectbff.integration.models.CreateProject;
import com.pucmg.projectbff.integration.models.UpdateActivity;

@FeignClient(name = "project-core-service", url = "http://project-core-service:8081")
public interface ProjectCoreClient {
	
	@GetMapping(path = {"/project/ongoing"})
	ResponseEntity<?> getOngoingProjects();
	
	@PostMapping(path = {"/project"})
	ResponseEntity<?> createProject(@RequestBody CreateProject form);
	
	@PutMapping(path = {"/activity"})
	ResponseEntity<?> updateActivity(@RequestBody UpdateActivity form);
}
