package com.lx.odw.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class FilterModel {

	String projectSubjectFilter;
	String jobNameFilter;
	String jobPayFilter;
	String jobRequirementFilter;
	String maxDistanceFilter;
	String targetDateFilter;
	
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
