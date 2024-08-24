package com.gopi.restapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "OperationManager")
public class OperationManager {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int operationManagerId;
	
	@Column
	private String name;
 
	@Column
	private String userName;
	
	@Column
	private String password;
 	
	@Column
	private String role = "operationManager";
	
	

	public OperationManager() {
		super();
	}

	public OperationManager(int operationManagerId, String name, String userName, String password, String role) {
		super();
		this.operationManagerId = operationManagerId;
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.role = role;
	}

	public int getoperationManagerId() {
		return operationManagerId;
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

	public void setOperationManagerId(int operationManagerId) {
		this.operationManagerId = operationManagerId;
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
		return "operationManager [operationManagerId=" + operationManagerId + ", name=" + name + ", userName=" + userName
				+ ", password=" + password + ", role=" + role + "]";
	}
	
}
