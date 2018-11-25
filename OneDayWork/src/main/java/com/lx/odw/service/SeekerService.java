package com.lx.odw.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.lx.odw.controller.CertificateVO;
import com.lx.odw.model.FilterModel;
import com.lx.odw.vo.JobCandidateVO;
import com.lx.odw.vo.JobVO;
import com.lx.odw.vo.ManageVO;
import com.lx.odw.vo.ProjectVO;
import com.lx.odw.vo.SeekerVO;
import com.lx.odw.vo.WorkVO;

@Service
public interface SeekerService {

	List<ProjectVO> getProjectList(FilterModel model);

	List<JobVO> requestProjectJobListByProjectNumber(ProjectVO projectVO);

	ProjectVO requestProjectDetail(ProjectVO projectVO);

	JobVO requestJobDetail(JobVO vo);

	int requestTargetDateCount(JobCandidateVO vo);

	Integer candidateJob(JobCandidateVO vo);

	List<JobCandidateVO> requestDisableDaysByJobNumber(int jobNumber);

	// 181108 ������ ������
	//List<ProjectJobListVO> manageJobList(ProjectVO projectVo);

	List<ManageVO> manageJobList(ManageVO vo);

	int cancelProject(ManageVO vo);

	ManageVO requestManageProjectDetail(ManageVO vo);

	
	SeekerVO requestSeekerDetail(SeekerVO seekerVO);

	List<CertificateVO> requestSeekerCertificationDetail(SeekerVO seekerVO);

	int updateSeeker(String seekerVO, String seekerPicture, HttpServletRequest request);

	WorkVO requestTodayWorkDetail(String seekerId);

	int requestCommute(SeekerVO vo);

	List<JobCandidateVO> requestCandidateDateList(JobCandidateVO vo);

	List<ManageVO> requestAcceptJobList(String seekerId);

	List<ManageVO> requestFinishJobList(String seekerId);

	ManageVO requestjobManageDetail(ManageVO vo);

}
