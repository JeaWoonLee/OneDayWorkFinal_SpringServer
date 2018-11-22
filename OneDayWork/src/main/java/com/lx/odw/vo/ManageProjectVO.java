package com.lx.odw.vo;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ManageProjectVO {

	ProjectVO projectVO;
	List<JobCandidateVO> recruitDays;
	public ProjectVO getProjectVO() {
		return projectVO;
	}
	public void setProjectVO(ProjectVO projectVO) {
		this.projectVO = projectVO;
	}
	public List<JobCandidateVO> getRecruitDays() {
		return recruitDays;
	}
	public void setRecruitDays(List<JobCandidateVO> recruitDays) {
		this.recruitDays = recruitDays;
	}
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.JSON_STYLE);
	}
	
}
