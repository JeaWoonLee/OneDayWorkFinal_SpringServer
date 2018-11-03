package com.lx.odw.service;

import org.springframework.stereotype.Service;

import com.lx.odw.model.LoginModel;
import com.lx.odw.vo.OfferVO;
import com.lx.odw.vo.SeekerVO;

@Service
public interface LoginService {

	SeekerVO seekerLogin(LoginModel model);

	OfferVO offerLogin(LoginModel model);
	
	
}
