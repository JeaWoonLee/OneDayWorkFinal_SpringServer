package com.lx.odw.dao;

import org.springframework.beans.factory.annotation.Autowired;
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
	public OfferVO offerLogin(LoginModel model) {
		return loginDAO.offerLogin(model);
	}

	
}
