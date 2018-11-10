package com.lx.odw.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lx.odw.model.FilterModel;
import com.lx.odw.vo.JobCandidateVO;
import com.lx.odw.vo.JobVO;
import com.lx.odw.vo.ProjectVO;

@Service
public interface SeekerService {

	List<ProjectVO> getProjectList(FilterModel model);

	List<JobVO> requestProjectJobListByProjectNumber(ProjectVO projectVO);

	ProjectVO requestProjectDetail(ProjectVO projectVO);

	JobVO requestJobDetail(JobVO vo);

	int requestTargetDateCount(JobCandidateVO vo);

	Integer candidateJob(JobCandidateVO vo);

	// 181108 ������ ������
	//List<ProjectJobListVO> manageJobList(ProjectVO projectVo);

	

}
