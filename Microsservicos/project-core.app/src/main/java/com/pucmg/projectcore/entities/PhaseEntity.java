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
@Table(name="FASE")
public class PhaseEntity {
	
	@Id
	@Column(name="id")
	private Long id;
	
	@ManyToOne
	private ProjectEntity project;
	
	@Column(name="sequencia")
	private Long sequence;
	
	@ManyToOne
	private StatusEntity status;
	
	@ManyToOne
	private PhaseTypeEntity phaseType;
	
	@Column(name = "inicio")
	private Date begin;
	
	@Column(name = "fim")
	private Date end;
	
	@OneToMany
	private List<ActivityEntity> activities;
	
	@Column(name = "cor")
	private String color;

}
