package com.lx.odw.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lx.odw.model.LoginModel;
import com.lx.odw.model.OfferIdModel;
import com.lx.odw.model.OfferPwModel;
import com.lx.odw.model.SeekerIdModel;
import com.lx.odw.model.SeekerPwModel;
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
	
	public SeekerVO seekerIdFind(SeekerIdModel model) {
		return session.selectOne("seekerId",model);
	}
	
	public SeekerVO seekerPwFind(SeekerPwModel model) {
		return session.selectOne("seekerPw",model);
	}
	
	public OfferVO offerIdFind(OfferIdModel model) {
		return session.selectOne("offerId",model);
	}
	
	public OfferVO offerPwFind(OfferPwModel model) {
		return session.selectOne("offerPw",model);
	}

	public int alterSeekerPw(SeekerPwModel model) {
		return session.selectOne("alterSeekerPw",model);
	}

	public int seekerPwAlter(SeekerVO seekerVO) {
		return session.update("seekerPwAlter", seekerVO);
	}
	
	public int alterOfferPw(OfferPwModel model) {
		return session.selectOne("alterOfferPw", model);	
	}

	public int offerPwAlter(OfferVO offerVO) {
		return session.update("offerPwAlter", offerVO);
	}
}
