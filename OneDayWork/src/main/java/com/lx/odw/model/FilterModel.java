package com.lx.odw.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class FilterModel {

	String projectSubjectFilter;
	String jobNameFilter;
	String jobPayFilter;
	int minJobPay;
	int maxJobPay;
	String jobRequirementFilter;
	String maxDistanceFilter;
	String targetDateFilter;
	double myLat;
	double myLng;
	double maxDistance;
	
	public double getMaxDistance() {
		return maxDistance;
	}
	public void setMaxDistance(double maxDistance) {
		this.maxDistance = maxDistance;
	}
	public double getMyLat() {
		return myLat;
	}
	public void setMyLat(double myLat) {
		this.myLat = myLat;
	}
	public double getMyLng() {
		return myLng;
	}
	public void setMyLng(double myLng) {
		this.myLng = myLng;
	}
	public int getMinJobPay() {
		return minJobPay;
	}
	public void setMinJobPay(int minJobPay) {
		this.minJobPay = minJobPay;
	}
	public int getMaxJobPay() {
		return maxJobPay;
	}
	public void setMaxJobPay(int maxJobPay) {
		this.maxJobPay = maxJobPay;
	}
	public String getProjectSubjectFilter() {
		return projectSubjectFilter;
	}
	public void setProjectSubjectFilter(String projectSubjectFilter) {
		this.projectSubjectFilter = projectSubjectFilter;
	}
	public String getJobNameFilter() {
		return jobNameFilter;
	}
	public void setJobNameFilter(String jobNameFilter) {
		this.jobNameFilter = jobNameFilter;
	}
	public String getJobPayFilter() {
		return jobPayFilter;
	}
	public void setJobPayFilter(String jobPayFilter) {
		this.jobPayFilter = jobPayFilter;
	}
	public String getJobRequirementFilter() {
		return jobRequirementFilter;
	}
	public void setJobRequirementFilter(String jobRequirementFilter) {
		this.jobRequirementFilter = jobRequirementFilter;
	}
	public String getMaxDistanceFilter() {
		return maxDistanceFilter;
	}
	public void setMaxDistanceFilter(String maxDistanceFilter) {
		this.maxDistanceFilter = maxDistanceFilter;
	}
	public String getTargetDateFilter() {
		return targetDateFilter;
	}
	public void setTargetDateFilter(String targetDateFilter) {
		this.targetDateFilter = targetDateFilter;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.JSON_STYLE);
	}
}
