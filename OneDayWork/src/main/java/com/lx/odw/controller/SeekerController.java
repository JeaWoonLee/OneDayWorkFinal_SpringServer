package com.lx.odw.controller;

import java.util.Calendar;
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
import com.lx.odw.vo.ManageVO;
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
	//TODO asdasd
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
	// 180811 ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½
//	@RequestMapping(value="manageJobList.do", method=RequestMethod.POST) 
//	public @ResponseBody List<ProjectJobListVO> manageJobList(ProjectVO projectVo) {
//		return service.manageJobList(projectVo);
//		
//	}

	@RequestMapping(value="manageJobList.do", method=RequestMethod.POST) 
	public @ResponseBody List<ManageVO> manageJobList(ManageVO vo) {
		return service.manageJobList(vo);
		
	}
	
	@RequestMapping(value="cancelProject.do", method=RequestMethod.POST)
	public @ResponseBody int cancelProject(ManageVO vo) {
		return service.cancelProject(vo);
	}
	
	@RequestMapping(value="requestManageProjectDetail.do", method=RequestMethod.POST)
	public @ResponseBody List<ManageVO> requestManageProjectDetail(ManageVO vo) {
		return service.requestManageProjectDetail(vo);
	}
	//181113 À±Á¤¹Î recycler view ¸¦ ÀÌ¿ëÇÏ¿© ³¯Â¥ Á¤·Ä ±¸ÇöÁß
//	@RequestMapping(value="orderbyDateRecyclerView", method=RequestMethod.POST)
//	public @ResponseBody 
	
	@RequestMapping(value="requestProjectJobListCanNum.do", method=RequestMethod.POST)
	public @ResponseBody List<ManageVO> requestProjectJobListCanNum (ManageVO vo){
		return service.requestProjectJobListCanNum(vo);
	}
}
