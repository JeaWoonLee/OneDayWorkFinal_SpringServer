package com.lx.odw.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	private final String mainPage = "haruMainPage";
	
	
	@RequestMapping(value="seekerLogin.do", method=RequestMethod.POST)
	public @ResponseBody SeekerVO seekerLogin(LoginModel model) {
		return service.seekerLogin(model);
	}
	

	@RequestMapping("offerLogin.do")
	public String offerLogin() {
		System.out.println("offerLogin이 실행됨");
		return "offerLogin";
	}
	
	@RequestMapping(value="offerLogin.do", method=RequestMethod.POST)
	public String offerLogin(LoginModel model, HttpSession session) {
		System.out.println("offerLogin.do 이 실행됨");
		
		OfferVO offerVO= service.offerLogin(model);
		session.setAttribute("offerId",offerVO);
		
		return mainPage;
	}

}
