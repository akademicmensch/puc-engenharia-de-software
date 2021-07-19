package com.pucmg.authenticationcore.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="USUARIO")
public class UserEntity {
	
	@Id
	@Column(name="id")
	private Long id;
	
	@Column(name = "codigo")
	private String code;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "nome")
	private String name;
	
	@Column(name = "senha")
	private String password;
	
	@ManyToOne
	private RoleEntity role;
}