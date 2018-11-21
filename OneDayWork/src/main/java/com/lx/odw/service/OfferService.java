package com.lx.odw.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.lx.odw.model.CandidateMapResponseModel;
import com.lx.odw.model.HumanResRsponseModel;
import com.lx.odw.model.ManageHumanResourceModel;
import com.lx.odw.vo.CommuteInfoVO;
import com.lx.odw.vo.JobCandidateVO;
import com.lx.odw.vo.JobVO;
import com.lx.odw.vo.OfferVO;
import com.lx.odw.vo.OfferWorkVO;
import com.lx.odw.vo.ProjectDetailVO;
import com.lx.odw.vo.ProjectVO;
import com.lx.odw.vo.SeekerDetailVO;
import com.lx.odw.vo.SeekerVO;

@Service
public interface OfferService {

	List<ProjectVO> getOffList();

	List<JobVO> requestOffJobListByProjectNumber(ProjectVO projectVO);
	
	//웹 구인자 일감목록
	List<ProjectVO> projectList(String offerId);

	//웹 구인자 상세정보
	String showPrjDetail(ProjectVO vo, HttpServletRequest request);

	String insertProject(ProjectVO vo, String jobs, HttpSession seesion);

	List<OfferWorkVO> requestOfferProjectList(String offerId);

	OfferWorkVO getProjectCommuteInfo(String projectNumber);

	CommuteInfoVO requestProjectCommuteInfo(String projectNumber);

	int requestAbsentByCandidateNumber(JobCandidateVO vo);

	int requestWorkingByCandidateNumber(JobCandidateVO vo);

	int requestOffWorkByCandidateNumber(JobCandidateVO vo);

	int requestEvaluate(JobCandidateVO vo);

	SeekerDetailVO requestSeekerDetail(SeekerVO vo);

	int allAbsent(ProjectVO vo);

	int allWorking(ProjectVO vo);

	int allOffWork(ProjectVO vo);

	List<ProjectVO> requestOfferManageProjectList(OfferVO vo);

	ProjectDetailVO requestManageProjectDetailInfo(ProjectVO vo);

	CandidateMapResponseModel requestCandidateListByJobNumber(JobCandidateVO vo);

	int requestAcceptCandidateByCandidateNumber(JobCandidateVO vo);

	int requestRefuseCandidateByCandidateNumber(JobCandidateVO vo);

	List<JobCandidateVO> requestProjectRecruitInfo(ProjectVO vo);

	HumanResRsponseModel requestTargetDateRecruitInfo(ManageHumanResourceModel vo);

}
