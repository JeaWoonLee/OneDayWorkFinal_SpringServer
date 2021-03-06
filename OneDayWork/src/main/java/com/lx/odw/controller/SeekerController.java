package com.lx.odw.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.lx.odw.model.FilterModel;
import com.lx.odw.service.SeekerService;
import com.lx.odw.vo.CertificationVO;
import com.lx.odw.vo.JobCandidateVO;
import com.lx.odw.vo.JobVO;
import com.lx.odw.vo.ManageVO;
import com.lx.odw.vo.ProjectVO;
import com.lx.odw.vo.SeekerVO;
import com.lx.odw.vo.WorkVO;

@Controller
public class SeekerController {

	@Autowired
	SeekerService service;
	
	@RequestMapping(value="getProjectList.do", method=RequestMethod.POST)
	public @ResponseBody List<ProjectVO> getProjectList (FilterModel model) {
		return service.getProjectList(model);
	}
	
	@RequestMapping(value="requestProjectJobListByProjectNumber.do", method=RequestMethod.POST)
	public @ResponseBody List<JobVO> requestProjectJobListByProjectNumber (ProjectVO projectVO) {
		return service.requestProjectJobListByProjectNumber(projectVO);
	}

	@RequestMapping(value="requestProjectDetail.do",method=RequestMethod.POST)
	public @ResponseBody ProjectVO requestProjectDetail(ProjectVO projectVO) {
		return service.requestProjectDetail(projectVO);
	}
	
	@RequestMapping(value="requestJobDetail.do",method=RequestMethod.POST)
	public @ResponseBody JobVO requestJobDetail(JobVO vo) {
		return service.requestJobDetail(vo);
	}
	
	@RequestMapping(value="requestTargetDateCount.do",method=RequestMethod.POST)
	public @ResponseBody Integer requestTargetDateCount(JobCandidateVO vo) {
		return service.requestTargetDateCount(vo);
	}
	
	@RequestMapping(value="candidateJob.do",method=RequestMethod.POST)
	public @ResponseBody Integer candidateJob(JobCandidateVO vo) {
		return service.candidateJob(vo);
	}

	@RequestMapping(value="requestDisableDaysByJobNumber.do",method=RequestMethod.POST)
	public @ResponseBody List<JobCandidateVO> requestDisableDaysByJobNumber(int jobNumber) {
		return service.requestDisableDaysByJobNumber(jobNumber);
	}

	@RequestMapping(value="manageJobList.do", method=RequestMethod.POST) 
	public @ResponseBody List<ManageVO> manageJobList(ManageVO vo) {
		return service.manageJobList(vo);
	}
	
	@RequestMapping(value="requestSeekerDetail.do", method=RequestMethod.POST)
	public @ResponseBody SeekerVO requestSeekerDetail(SeekerVO seekerVO) {
		return service.requestSeekerDetail(seekerVO);
	}
	
	@RequestMapping(value="requestSeekerCertificationDetail.do", method=RequestMethod.POST)
	public @ResponseBody List<CertificateVO> requestSeekerCertificationDetail(SeekerVO seekerVO) {
		return service.requestSeekerCertificationDetail(seekerVO);
	}
	
	@RequestMapping(value="updateSeeker.do",method=RequestMethod.POST)
	public @ResponseBody int updateSeeker(String seekerVO, MultipartFile seekerPhoto,HttpServletRequest request) {
		return service.updateSeeker(seekerVO,seekerPhoto,request);
	}
	
	@RequestMapping(value="updateCertificate.do",method=RequestMethod.POST)
	public @ResponseBody int updateCertificate(CertificationVO vo) {
		return service.updateCertificate(vo);
	}
	
	@RequestMapping(value="requestTodayWorkDetail.do",method=RequestMethod.POST)
	public @ResponseBody WorkVO requestTodayWorkDetail(String seekerId) {
		return service.requestTodayWorkDetail(seekerId);
	}
	
	@RequestMapping(value="requestCommute.do",method=RequestMethod.POST)
	public @ResponseBody int requestCommute(SeekerVO vo) {
		return service.requestCommute(vo);
	}
	
	@RequestMapping(value="cancelProject.do", method=RequestMethod.POST)
	public @ResponseBody int cancelProject(ManageVO vo) {
		return service.cancelProject(vo);
	}
	
	@RequestMapping(value="requestManageProjectDetail.do", method=RequestMethod.POST)
	public @ResponseBody ManageVO requestManageProjectDetail(ManageVO vo) {
		return service.requestManageProjectDetail(vo);
	}
	
	@RequestMapping(value="requestCandidateDateList.do",method=RequestMethod.POST)
	public @ResponseBody List<JobCandidateVO> requestCandidateDateList(JobCandidateVO vo) {
		return service.requestCandidateDateList(vo);
	}
	
	@RequestMapping(value="requestAcceptJobList.do",method=RequestMethod.POST)
	public @ResponseBody List<ManageVO> requestAcceptJobList(String seekerId) {
		return service.requestAcceptJobList(seekerId);
	}

	@RequestMapping(value="requestFinishJobList.do",method=RequestMethod.POST)
	public @ResponseBody List<ManageVO> requestFinishJobList(String seekerId) {
		return service.requestFinishJobList(seekerId);
	}
	
	@RequestMapping(value="requestjobManageDetail.do",method=RequestMethod.POST)
	public @ResponseBody ManageVO requestjobManageDetail(ManageVO vo) {
		return service.requestjobManageDetail(vo);
	}
	
	@RequestMapping(value="updateCandidateSign.do",method=RequestMethod.POST)
	public @ResponseBody int updateCandidateSign(MultipartFile seekerSign, String work,HttpServletRequest request) {
		return service.updateCandidateSign(seekerSign,work,request);
	}
	
	@RequestMapping(value="requestSeekerRecord.do",method=RequestMethod.POST)
	public @ResponseBody List<JobCandidateVO> requestSeekerRecord (SeekerVO vo) {
		return service.requestSeekerRecord(vo);
	}
}
