package com.lx.odw.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class SeekerIdModel {

	String seekerEmail;
	String seekerName;
	public String getSeekerEmail() {
		return seekerEmail;
	}
	public void setSeekerEmail(String seekerEmail) {
		this.seekerEmail = seekerEmail;
	}
	public String getSeekerName() {
		return seekerName;
	}
	public void setSeekerName(String seekerName) {
		this.seekerName = seekerName;
	}
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.JSON_STYLE);
	}
	
	
}
