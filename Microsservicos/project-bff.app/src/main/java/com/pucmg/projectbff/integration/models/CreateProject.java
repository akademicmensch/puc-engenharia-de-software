package com.pucmg.projectbff.integration.models;

import java.util.Date;
import java.util.List;

public class CreateProject {
	private String code;
	private String description;
	private Long managerId;
	private Date begin;
	private Date end;
	private List<Long> associates;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Long getManagerId() {
		return managerId;
	}
	public void setManagerId(Long managerId) {
		this.managerId = managerId;
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
	public List<Long> getAssociates() {
		return associates;
	}
	public void setAssociates(List<Long> associates) {
		this.associates = associates;
	}
}
