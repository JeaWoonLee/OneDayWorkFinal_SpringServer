package com.lx.odw.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class OfferIdModel {

	String offerEmail;
	String offerName;
	public String getOfferEmail() {
		return offerEmail;
	}
	public void setOfferEmail(String offerEmail) {
		this.offerEmail = offerEmail;
	}
	public String getOfferName() {
		return offerName;
	}
	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.JSON_STYLE);
	}
	
	
	
}
