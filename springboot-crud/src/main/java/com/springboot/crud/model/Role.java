package com.springboot.crud.model;

public class Role {
	private long idRole;
	private String role;
	
	public Role(long idRole, String role) {
		this.idRole = idRole;
		this.role = role;
	}
	
	public Role() {
		
	}
	
	public long getIdRole() {
		return idRole;
	}
	public void setIdRole(long idRole) {
		this.idRole = idRole;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

}
