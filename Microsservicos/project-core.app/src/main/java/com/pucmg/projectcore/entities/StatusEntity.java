package com.pucmg.projectcore.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="STATUS")
public class StatusEntity {
	
	@Id
	@Column(name="id")
	private Long id;
	
	@Column(name="descricao")
	private String description;
	
}
