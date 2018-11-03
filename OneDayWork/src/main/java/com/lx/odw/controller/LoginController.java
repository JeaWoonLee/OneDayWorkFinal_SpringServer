package com.lx.odw.controller;

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
	
	@RequestMapping(value="seekerLogin.do", method=RequestMethod.POST)
	public @ResponseBody SeekerVO seekerLogin(LoginModel model) {
		return service.seekerLogin(model);
	}
	
	@RequestMapping(value="offerLogin.do", method=RequestMethod.POST)
	public @ResponseBody OfferVO offerLogin(LoginModel model) {
		return service.offerLogin(model);
	}
}
