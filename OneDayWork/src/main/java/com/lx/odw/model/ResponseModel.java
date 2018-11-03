package com.lx.odw.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ResponseModel {

	int response;
	
	public int getResponse() {
		return response;
	}

	public void setResponse(int response) {
		this.response = response;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.JSON_STYLE);
	}
}
