package com.lx.odw.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;

import com.lx.odw.model.LoginModel;
import com.lx.odw.model.OfferIdModel;
import com.lx.odw.model.OfferPwModel;
import com.lx.odw.model.ResponseModel;
import com.lx.odw.model.SeekerIdModel;
import com.lx.odw.model.SeekerPwModel;
import com.lx.odw.vo.OfferVO;
import com.lx.odw.vo.SeekerVO;

@Service
public interface LoginService {

	SeekerVO seekerLogin(LoginModel model);

	OfferVO offerMobileLogin(LoginModel model);

	String offerLogin(LoginModel model, HttpSession session, HttpServletRequest request);

	SeekerVO seekerIdFind(SeekerIdModel model);

	SeekerVO seekerPwFind(SeekerPwModel model);
	
	OfferVO offerIdFind(OfferIdModel model);
	
	OfferVO offerPwFind(OfferPwModel model);

	ResponseModel alterOfferPw(OfferPwModel model)throws Exception;

	ResponseModel seekerPwAlter(SeekerVO seekerVO)throws Exception;

	ResponseModel offerPwAlter(OfferVO offerVO)throws Exception;

	ResponseModel alterSeekerPw(SeekerPwModel model)throws Exception;

	
	
}
