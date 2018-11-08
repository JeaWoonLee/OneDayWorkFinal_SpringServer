package com.lx.odw.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lx.odw.vo.ProjectCandidateQueueVO;
import com.lx.odw.vo.ProjectJobListVO;
import com.lx.odw.vo.ProjectVO;

@Service
public interface SeekerService {

	List<ProjectVO> getProjectList();

	List<ProjectJobListVO> requestProjectJobListByProjectNumber(ProjectVO projectVO);

	ProjectVO requestProjectDetail(ProjectVO projectVO);

	ProjectJobListVO requestJobDetail(ProjectJobListVO vo);

	int requestTargetDateCount(ProjectCandidateQueueVO vo);

	Integer candidateJob(ProjectCandidateQueueVO vo);

	// 181108 ¿±¡§πŒ ¡¯«‡¡ﬂ
	//List<ProjectJobListVO> manageJobList(ProjectVO projectVo);

	

}
