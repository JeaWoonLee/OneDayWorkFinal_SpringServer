package com.lx.odw.model;

public class OfferPwModel {

	String userId;
	String userEmail;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	@Override
	public String toString() {
		return "OfferPwModel [userId=" + userId + ", userEmail=" + userEmail + "]";
	}
	
	
}
