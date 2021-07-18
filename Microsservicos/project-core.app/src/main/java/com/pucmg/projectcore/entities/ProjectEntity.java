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
	
}
