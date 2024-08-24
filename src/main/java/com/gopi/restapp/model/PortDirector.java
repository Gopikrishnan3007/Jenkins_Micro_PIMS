package com.gopi.restapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PortDirector")
public class PortDirector {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int portDirectorId;
	
	@Column
	private String name;
 
	@Column
	private String userName;
	
	@Column
	private String password;
 	
	@Column
	private String role = "portDirector";

	public PortDirector() {
		super();
	}

	public PortDirector(int portDirectorId, String name, String userName, String password, String role) {
		super();
		this.portDirectorId = portDirectorId;
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.role = role;
	}

	public int getPortDirectorId() {
		return portDirectorId;
	}

	public String getName() {
		return name;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public String getRole() {
		return role;
	}

	public void setPortDirectorId(int portDirectorId) {
		this.portDirectorId = portDirectorId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "PortDirector [portDirectorId=" + portDirectorId + ", name=" + name + ", userName=" + userName
				+ ", password=" + password + ", role=" + role + "]";
	}

}