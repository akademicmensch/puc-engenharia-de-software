package com.pucmg.notificationcore.integrations.models;

import java.util.Date;

public class Activity {
	
	private Long id;
	private String description;
	private UserDTO associate;
	private Date begin;
	private Date end;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public UserDTO getAssociate() {
		return associate;
	}
	public void setAssociate(UserDTO associate) {
		this.associate = associate;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
