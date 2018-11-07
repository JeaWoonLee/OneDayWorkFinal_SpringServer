package com.lx.odw.vo;

public class ProjectCandidateQueueVO {

	public int registNumber;
	public String seekerId;
	public int jobNumber;
	public String targetDate;
	public int registConfirm;
	public int getRegistNumber() {
		return registNumber;
	}
	public void setRegistNumber(int registNumber) {
		this.registNumber = registNumber;
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
	public int getRegistConfirm() {
		return registConfirm;
	}
	public void setRegistConfirm(int registConfirm) {
		this.registConfirm = registConfirm;
	}
	@Override
	public String toString() {
		return "ProjectCandidateQueue [registNumber=" + registNumber + ", seekerId=" + seekerId + ", jobNumber="
				+ jobNumber + ", targetDate=" + targetDate + ", registConfirm=" + registConfirm + "]";
	}
	
}
