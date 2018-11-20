package com.lx.odw.dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Repository;

import com.lx.odw.model.LoginModel;
import com.lx.odw.model.OfferIdModel;
import com.lx.odw.model.OfferPwModel;
import com.lx.odw.model.SeekerIdModel;
import com.lx.odw.model.SeekerPwModel;
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
		System.out.println(loginResult);
		if(loginResult != null) {
			session.setAttribute("loginInfo", loginResult);
			return "haruMainPage";
		}else {
			request.setAttribute("loginResult", "loginFail");
			return "offerLogin";
		}
	}
	
	@Override
	public SeekerVO seekerIdFind(SeekerIdModel model) {
		return loginDAO.seekerIdFind(model);
	}
	
	@Override
	public SeekerVO seekerPwFind(SeekerPwModel model) {
		return loginDAO.seekerPwFind(model);
	}

	@Override
	public OfferVO offerIdFind(OfferIdModel model) {
		return loginDAO.offerIdFind(model);
	}
	
	@Override
	public OfferVO offerPwFind(OfferPwModel model) {
		return loginDAO.offerPwFind(model);
	}
}
