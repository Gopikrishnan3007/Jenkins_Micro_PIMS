package com.gopi.restapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "LogisticManagers")
public class LogisticManager {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int logisticManagerId;
	
	@Column
	private String name;
 
	@Column
	private String userName;
	
	@Column
	private String password;
	
	@Column
	private String email;
 	
	@Column
	private String role = "logisticManager";
	
	
	public LogisticManager() {
		super();
	}


	public LogisticManager(int logisticManagerId, String name, String userName, String password, String email,
			String role) {
		super();
		this.logisticManagerId = logisticManagerId;
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.role = role;
	}


	public int getLogisticManagerId() {
		return logisticManagerId;
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


	public String getEmail() {
		return email;
	}


	public String getRole() {
		return role;
	}


	public void setLogisticManagerId(int logisticManagerId) {
		this.logisticManagerId = logisticManagerId;
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


	public void setEmail(String email) {
		this.email = email;
	}


	public void setRole(String role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return "LogisticManager [logisticManagerId=" + logisticManagerId + ", name=" + name + ", userName=" + userName
				+ ", password=" + password + ", email=" + email + ", role=" + role + "]";
	}

	
	
}
