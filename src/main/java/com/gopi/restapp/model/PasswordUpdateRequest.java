package com.gopi.restapp.model;

public class PasswordUpdateRequest {

	private String userName;
    private String newPassword;
	public PasswordUpdateRequest(String userName, String newPassword) {
		super();
		this.userName = userName;
		this.newPassword = newPassword;
	}
	public String getUserName() {
		return userName;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	@Override
	public String toString() {
		return "PasswordUpdateRequest [userName=" + userName + ", newPassword=" + newPassword + "]";
	}
    
    
}
