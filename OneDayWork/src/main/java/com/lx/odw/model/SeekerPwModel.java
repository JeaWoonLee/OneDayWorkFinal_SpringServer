package com.lx.odw.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class SeekerPwModel {

	String seekerId;
	String seekerEmail;
	public String getSeekerId() {
		return seekerId;
	}
	public void setSeekerId(String seekerId) {
		this.seekerId = seekerId;
	}
	public String getSeekerEmail() {
		return seekerEmail;
	}
	public void setSeekerEmail(String seekerEmail) {
		this.seekerEmail = seekerEmail;
	}
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.JSON_STYLE);
	}

	

}
