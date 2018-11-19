package com.lx.odw.vo;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ProjectDetailVO {
	
	ProjectVO projectVO;
	List<JobVO> jobList;
	public ProjectVO getProjectVO() {
		return projectVO;
	}
	public void setProjectVO(ProjectVO projectVO) {
		this.projectVO = projectVO;
	}
	public List<JobVO> getJobList() {
		return jobList;
	}
	public void setJobList(List<JobVO> jobList) {
		this.jobList = jobList;
	}
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.JSON_STYLE);
	}
	
	

}
