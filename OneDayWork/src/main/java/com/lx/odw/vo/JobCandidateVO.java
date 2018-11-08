package com.lx.odw.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class JobCandidateVO {

	public int candidateNumber;
	public String seekerId;
	public int jobNumber;
	public String targetDate;
	public int candidateStatus;
	
	
	public int getCandidateNumber() {
		return candidateNumber;
	}


	public void setCandidateNumber(int candidateNumber) {
		this.candidateNumber = candidateNumber;
	}


	public String getSeekerId() {
		return seekerId;
	}


	public void setSeekerId(String seekerId) {
		this.seekerId = seekerId;
	}


	public int getJobNumber() {
		return jobNumber;
	}


	public void setJobNumber(int jobNumber) {
		this.jobNumber = jobNumber;
	}


	public String getTargetDate() {
		return targetDate;
	}


	public void setTargetDate(String targetDate) {
		this.targetDate = targetDate;
	}


	public int getCandidateStatus() {
		return candidateStatus;
	}


	public void setCandidateStatus(int candidateStatus) {
		this.candidateStatus = candidateStatus;
	}


	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.JSON_STYLE);
	}
	
}
