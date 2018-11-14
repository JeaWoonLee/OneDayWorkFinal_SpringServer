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
}
