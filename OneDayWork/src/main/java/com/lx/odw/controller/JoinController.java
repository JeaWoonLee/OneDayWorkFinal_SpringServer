package com.lx.odw.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lx.odw.model.LoginModel;
import com.lx.odw.model.ResponseModel;
import com.lx.odw.service.JoinService;
import com.lx.odw.vo.OfferVO;
import com.lx.odw.vo.SeekerVO;

@Controller
public class JoinController {

	@Autowired
	JoinService service;
	
	@RequestMapping(value="checkSeekerOverlap.do",method=RequestMethod.POST)
	public @ResponseBody ResponseModel checkOverlap(LoginModel model) throws Exception {
		return service.checkSeekerOverlap(model);
	}
	
	@RequestMapping(value="joinSeeker.do",method=RequestMethod.POST)
	public @ResponseBody ResponseModel joinSeeker(SeekerVO seekerVO) throws Exception {
		return service.joinSeeker(seekerVO);
	}
	
//	@RequestMapping("offerJoin.do")
//	public String offerLogin() {
//		System.out.println("offerJoin이 실행됨");
//		return "offerJoin";
//	}
	
	@RequestMapping(value="checkOfferOverlap.do",method=RequestMethod.POST)
	public @ResponseBody ResponseModel checkOverlap1(LoginModel model) throws Exception {
		return service.checkOfferOverlap(model);
	}
	
	@RequestMapping(value="joinOffer.do", method=RequestMethod.POST)
	public @ResponseBody ResponseModel joinOffer(OfferVO offerVO) throws Exception {
		return service.joinOffer(offerVO);
	}
}
