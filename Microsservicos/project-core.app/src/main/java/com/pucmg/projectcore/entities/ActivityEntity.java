package com.pucmg.projectcore.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ATIVIDADE")
public class ActivityEntity {
	
	@Id
	@Column(name="id")
	private Long id;
	
	@ManyToOne
	private ProjectEntity project;
	
	@ManyToOne
	private UserEntity associate;
	
	@Column(name = "descricao")
	private String description;
	
	@ManyToOne
	private StatusEntity status;
	
	@Column(name = "inicio")
	private Date begin;
	
	@Column(name = "fim")
	private Date end;
	
	@Column(name = "cor")
	private String color;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ProjectEntity getProject() {
		return project;
	}

	public void setProject(ProjectEntity project) {
		this.project = project;
	}

	public UserEntity getAssociate() {
		return associate;
	}

	public void setAssociate(UserEntity associate) {
		this.associate = associate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public StatusEntity getStatus() {
		return status;
	}

	public void setStatus(StatusEntity status) {
		this.status = status;
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
