package com.lx.odw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lx.odw.model.LoginModel;
import com.lx.odw.model.ResponseModel;
import com.lx.odw.service.JoinService;
import com.lx.odw.vo.SeekerVO;

@Controller
public class JoinController {

	@Autowired
	JoinService service;
	
	@RequestMapping(value="checkSeekerOverlap.do",method=RequestMethod.POST)
	public @ResponseBody ResponseModel checkOverlap(LoginModel model) {
		return service.checkSeekerOverlap(model);
	}
	
	@RequestMapping(value="joinSeeker.do",method=RequestMethod.POST)
	public @ResponseBody ResponseModel joinSeeker(SeekerVO seekerVO) {
		return service.joinSeeker(seekerVO);
	}
}
