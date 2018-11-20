package com.lx.odw.model;

public class OfferIdModel {

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
		return "OfferIdModel [userEmail=" + userEmail + ", userName=" + userName + "]";
	}
	
	
	
}
