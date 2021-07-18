package com.pucmg.projectcore.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TIPOFASE")
public class PhaseTypeEntity {
	
	@Id
	@Column(name="id")
	private Long id;
	
	@Column(name="descricao")
	private String descricao;

}
