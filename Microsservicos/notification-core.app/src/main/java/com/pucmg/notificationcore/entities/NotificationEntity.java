package com.pucmg.notificationcore.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_NOTIFICACAO")
public class NotificationEntity {
	
	private NotificationEntity() {}
	
	@Id
	@Column(name="id")
	private Long id;
	
	@Column(name = "tipoNotificacao")
	private String notificationType;
	
	@Column(name = "parametrosNotificacao")
	private String notificationParameters;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNotificationType() {
		return notificationType;
	}

	public void setNotificationType(String notificationType) {
		this.notificationType = notificationType;
	}

	public String getNotificationParameters() {
		return notificationParameters;
	}

	public void setNotificationParameters(String notificationParameters) {
		this.notificationParameters = notificationParameters;
	}
}
