package com.lx.odw.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lx.odw.model.LoginModel;
import com.lx.odw.vo.OfferVO;
import com.lx.odw.vo.SeekerVO;

@Repository
public class LoginDAO {

	@Autowired
	SqlSession session;
	
	public SeekerVO seekerLogin(LoginModel model) {
		return session.selectOne("seekerLogin",model);
	}

	public OfferVO offerMobileLogin(LoginModel model) {
		return session.selectOne("offerLogin",model);
	}

	
}
