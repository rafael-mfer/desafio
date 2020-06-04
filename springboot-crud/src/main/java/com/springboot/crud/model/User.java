package com.springboot.crud.model;

import java.util.Date;

public class User {
	private long id;
	private String name;
	private String cpf;
	private Date birthDate;
	private long idRole;
	private long idProfile;
	
	public User() {
	}
	
	public User(long id, String name, String cpf, Date birthDate, long idRole, long idProfile) {
		super();
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.birthDate = birthDate;
		this.idRole = idRole;
		this.idProfile = idProfile;
	}

	public User(String name, String cpf, Date birthDate, long idRole, long idProfile) {
		super();
		this.name = name;
		this.cpf = cpf;
		this.birthDate = birthDate;
		this.idRole = idRole;
		this.idProfile = idProfile;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public long getIdRole() {
		return idRole;
	}

	public void setIdRole(long idRole) {
		this.idRole = idRole;
	}

	public long getIdProfile() {
		return idProfile;
	}

	public void setIdProfile(long idProfile) {
		this.idProfile = idProfile;
	}
			
}
