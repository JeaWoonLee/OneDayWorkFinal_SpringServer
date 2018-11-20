package com.lx.odw.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lx.odw.model.LoginModel;
import com.lx.odw.model.OfferIdModel;
import com.lx.odw.model.OfferPwModel;
import com.lx.odw.model.ResponseModel;
import com.lx.odw.model.SeekerIdModel;
import com.lx.odw.model.SeekerPwModel;
import com.lx.odw.service.LoginService;
import com.lx.odw.vo.OfferVO;
import com.lx.odw.vo.SeekerVO;

@Controller
public class LoginController {

	@Autowired
	LoginService service;
	
	@RequestMapping(value="seekerLogin.do", method=RequestMethod.POST)
	public @ResponseBody SeekerVO seekerLogin(LoginModel model) {
		return service.seekerLogin(model);
	}
	//
	
	@RequestMapping(value="offerLogin.do",method=RequestMethod.GET)
	public String showOfferLoginPage() {
		return "offerLogin";
	}
	
	@RequestMapping(value="offerLogin.do",method=RequestMethod.POST)
	public String offerLogin(LoginModel model,HttpSession session,HttpServletRequest request) {
		return service.offerLogin(model,session,request);
	}
	
	
	@RequestMapping(value="offerMobileLogin.do", method=RequestMethod.POST)
	public @ResponseBody OfferVO offerMobileLogin(LoginModel model) {
		return service.offerMobileLogin(model);
	}
	
	@RequestMapping(value="seekrIdFind.do", method=RequestMethod.POST)
	public @ResponseBody SeekerVO seekerIdFind(SeekerIdModel model) {
		return service.seekerIdFind(model);
	}
	
	@RequestMapping(value="offerIdFind.do", method=RequestMethod.POST)
	public @ResponseBody OfferVO offerIdFind(OfferIdModel model) {
		return service.offerIdFind(model);
	}
	
	@RequestMapping(value="seekerPwFind.do", method=RequestMethod.POST)
	public @ResponseBody SeekerVO seekerPwFind(SeekerPwModel model) {
		return service.seekerPwFind(model);
	}
	
	@RequestMapping(value="offerPwFind.do", method=RequestMethod.POST)
	public @ResponseBody OfferVO offerPwFind(OfferPwModel model) {
		return service.offerPwFind(model);
	}
	
	@RequestMapping(value="seekerPwAlter.do", method=RequestMethod.POST)
	public @ResponseBody ResponseModel alterSeekerPw(SeekerPwModel model) throws Exception{
		return service.alterSeekerPw(model);
	}
	
	@RequestMapping(value="seekerPwAlter.do", method=RequestMethod.POST)
	public @ResponseBody ResponseModel seekerPwAlter(SeekerVO seekerVO) throws Exception{
		return service.seekerPwAlter(seekerVO);
	}
	
	@RequestMapping(value="offerPwAlter.do", method=RequestMethod.POST)
	public @ResponseBody ResponseModel alterOfferPw(OfferPwModel model) throws Exception{
		return service.alterOfferPw(model);	
	}
	
	@RequestMapping(value="offerPwAlter.do", method=RequestMethod.POST)
	public @ResponseBody ResponseModel offerPwAlter(OfferVO offerVO) throws Exception{
		return service.offerPwAlter(offerVO);
	}
	
}
