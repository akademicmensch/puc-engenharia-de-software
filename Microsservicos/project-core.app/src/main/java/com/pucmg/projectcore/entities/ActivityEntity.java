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
}
