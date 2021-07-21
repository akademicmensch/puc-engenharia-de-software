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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public RoleEntity getRole() {
		return role;
	}

	public void setRole(RoleEntity role) {
		this.role = role;
	}
}