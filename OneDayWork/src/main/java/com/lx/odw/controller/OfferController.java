package com.lx.odw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lx.odw.service.OfferService;
import com.lx.odw.service.SeekerService;
import com.lx.odw.vo.JobVO;
import com.lx.odw.vo.ProjectVO;

@Controller
public class OfferController {

	@Autowired
	OfferService service;
	
	@RequestMapping(value="getOffList.do", method=RequestMethod.POST)
	public @ResponseBody List<ProjectVO> getOffList(){
		return service.getOffList();
	}
	
	@RequestMapping(value="requestOffJobListByProjectNumber.do", method = RequestMethod.POST)
	public @ResponseBody List<JobVO> requestOffJobListByProjectNumber(ProjectVO projectVO){
		return service.requestOffJobListByProjectNumber(projectVO);
		
	}
}
