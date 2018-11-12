package com.lx.odw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lx.odw.model.FilterModel;
import com.lx.odw.service.SeekerService;
import com.lx.odw.vo.JobCandidateVO;
import com.lx.odw.vo.JobVO;
import com.lx.odw.vo.ProjectVO;

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


	@RequestMapping(value="manageJobList.do", method=RequestMethod.POST) 
	public @ResponseBody List<ProjectVO> manageJobList(JobCandidateVO vo) {
		return service.manageJobList(vo);
		
	}
}
