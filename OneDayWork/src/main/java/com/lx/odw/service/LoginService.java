package com.lx.odw.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;

import com.lx.odw.model.LoginModel;
import com.lx.odw.vo.OfferVO;
import com.lx.odw.vo.SeekerVO;

@Service
public interface LoginService {

	SeekerVO seekerLogin(LoginModel model);

	OfferVO offerMobileLogin(LoginModel model);

	String offerLogin(LoginModel model, HttpSession session, HttpServletRequest request);
	
	
}
