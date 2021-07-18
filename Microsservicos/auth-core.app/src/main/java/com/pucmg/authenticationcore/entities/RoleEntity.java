package com.pucmg.authenticationcore.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ROLE")
public class RoleEntity {
	
	@Id
	@Column(name="id")
	private Long id;
	
	@Column(name="descricao")
	private String description;
}
