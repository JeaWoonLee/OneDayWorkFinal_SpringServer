package com.lx.odw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lx.odw.service.SeekerService;
import com.lx.odw.vo.ProjectCandidateQueueVO;
import com.lx.odw.vo.ProjectJobListVO;
import com.lx.odw.vo.ProjectVO;

@Controller
public class SeekerController {

	@Autowired
	SeekerService service;
	
	@RequestMapping(value="getProjectList.do", method=RequestMethod.POST)
	public @ResponseBody List<ProjectVO> getProjectList () {
		return service.getProjectList();
	}
	
	@RequestMapping(value="requestProjectJobListByProjectNumber.do", method=RequestMethod.POST)
	public @ResponseBody List<ProjectJobListVO> requestProjectJobListByProjectNumber (ProjectVO projectVO) {
		return service.requestProjectJobListByProjectNumber(projectVO);
	}
	//TODO asdasd
	@RequestMapping(value="requestProjectDetail.do",method=RequestMethod.POST)
	public @ResponseBody ProjectVO requestProjectDetail(ProjectVO projectVO) {
		return service.requestProjectDetail(projectVO);
	}
	
	@RequestMapping(value="requestJobDetail.do",method=RequestMethod.POST)
	public @ResponseBody ProjectJobListVO requestJobDetail(ProjectJobListVO vo) {
		return service.requestJobDetail(vo);
	}
	
	@RequestMapping(value="requestTargetDateCount.do",method=RequestMethod.POST)
	public @ResponseBody Integer requestTargetDateCount(ProjectCandidateQueueVO vo) {
		return service.requestTargetDateCount(vo);
	}
	
	@RequestMapping(value="candidateJob.do",method=RequestMethod.POST)
	public @ResponseBody Integer candidateJob(ProjectCandidateQueueVO vo) {
		return service.candidateJob(vo);
	}
}
