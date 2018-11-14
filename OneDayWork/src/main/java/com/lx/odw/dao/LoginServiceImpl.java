package com.lx.odw.dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Repository;

import com.lx.odw.model.LoginModel;
import com.lx.odw.service.LoginService;
import com.lx.odw.vo.OfferVO;
import com.lx.odw.vo.SeekerVO;

@Repository
public class LoginServiceImpl implements LoginService{

	@Autowired
	LoginDAO loginDAO;
	
	@Override
	public SeekerVO seekerLogin(LoginModel model) {
		return loginDAO.seekerLogin(model);
	}

	@Override
	public OfferVO offerMobileLogin(LoginModel model) {
		return loginDAO.offerMobileLogin(model);
	}

	@Override
	public String offerLogin(LoginModel model,HttpSession session, HttpServletRequest request) {
		OfferVO loginResult = loginDAO.offerMobileLogin(model);
		if(loginResult != null) {
			session.setAttribute("loginInfo", loginResult);
			return "haruMainPage";
		}else {
			request.setAttribute("loginResult", "loginFail");
			return "offerLogin";
		}
	}

	
}
