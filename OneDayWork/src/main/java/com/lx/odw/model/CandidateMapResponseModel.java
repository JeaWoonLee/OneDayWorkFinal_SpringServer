package com.lx.odw.model;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.lx.odw.vo.JobCandidateVO;

public class CandidateMapResponseModel {
	HashMap<String,List<JobCandidateVO>> result;
	List<JobCandidateVO> targetDateList;
	
	
	public List<JobCandidateVO> getTargetDateList() {
		return targetDateList;
	}

	public void setTargetDateList(List<JobCandidateVO> targetDateList) {
		this.targetDateList = targetDateList;
	}

	public HashMap<String, List<JobCandidateVO>> getResult() {
		return result;
	}

	public void setResult(HashMap<String, List<JobCandidateVO>> result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.JSON_STYLE);
	}
	
	
	
}
