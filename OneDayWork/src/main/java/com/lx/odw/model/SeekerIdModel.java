package com.lx.odw.model;

public class SeekerIdModel {

	String userEmail;
	String userName;
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "SeekerIdModel [userEmail=" + userEmail + ", userName=" + userName + "]";
	}
	
	
	
}
