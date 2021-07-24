package com.pucmg.projectcore.models;

public class UpdateActivity {
	
	private Long user;
	private Long activityId;
	private String description;
	private String updateStatus;
	
	public Long getUser() {
		return user;
	}
	public void setUser(Long user) {
		this.user = user;
	}
	public Long getActivityId() {
		return activityId;
	}
	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUpdateStatus() {
		return updateStatus;
	}
	public void setUpdateStatus(String updateStatus) {
		this.updateStatus = updateStatus;
	}
}
