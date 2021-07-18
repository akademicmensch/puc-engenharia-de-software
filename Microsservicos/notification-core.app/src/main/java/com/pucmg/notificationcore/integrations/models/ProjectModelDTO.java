package com.pucmg.notificationcore.integrations.models;

import java.util.Date;
import java.util.List;

public class ProjectModelDTO {
	
	private Long id;
	private String projectIdentification;
	private UserDTO projectManager;
	private List<UserDTO> associates;
	private Date begin;
	private Date end;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProjectIdentification() {
		return projectIdentification;
	}
	public void setProjectIdentification(String projectIdentification) {
		this.projectIdentification = projectIdentification;
	}
	public UserDTO getProjectManager() {
		return projectManager;
	}
	public void setProjectManager(UserDTO projectManager) {
		this.projectManager = projectManager;
	}
	public List<UserDTO> getAssociates() {
		return associates;
	}
	public void setAssociates(List<UserDTO> associates) {
		this.associates = associates;
	}
	public Date getBegin() {
		return begin;
	}
	public void setBegin(Date begin) {
		this.begin = begin;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
}
