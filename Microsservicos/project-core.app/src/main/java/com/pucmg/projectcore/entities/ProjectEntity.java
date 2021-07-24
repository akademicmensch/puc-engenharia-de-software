package com.pucmg.projectcore.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PROJETO")
public class ProjectEntity {

	@Id
	@Column(name="id")
	private Long id;
	
	@Column(name="identificacao")
	private String identification;
	
	@Column(name="descricao")
	private String description;
	
	@ManyToOne
	private UserEntity manager;
	
	@OneToMany
	private List<UserEntity> associates;
	
	@Column(name = "inicio")
	private Date begin;
	
	@Column(name = "fim")
	private Date end;
	
	@Column(name = "cor")
	private String color;
	
	@ManyToOne
	private StatusEntity status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public UserEntity getManager() {
		return manager;
	}

	public void setManager(UserEntity manager) {
		this.manager = manager;
	}

	public List<UserEntity> getAssociates() {
		return associates;
	}

	public void setAssociates(List<UserEntity> associates) {
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public StatusEntity getStatus() {
		return status;
	}

	public void setStatus(StatusEntity status) {
		this.status = status;
	}
}
