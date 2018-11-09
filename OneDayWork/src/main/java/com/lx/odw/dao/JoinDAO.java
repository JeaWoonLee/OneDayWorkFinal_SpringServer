package com.lx.odw.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lx.odw.model.LoginModel;
import com.lx.odw.vo.OfferVO;
import com.lx.odw.vo.SeekerVO;

@Repository
public class JoinDAO {

	@Autowired
	SqlSession session;

	public int checkSeekerOverlap(LoginModel model) throws Exception {
		return session.selectOne("checkSeekerOverlap",model);
	}

	public int joinSeeker(SeekerVO seekerVO){
		return session.insert("joinSeeker",seekerVO);
	}
//	
//	public int joinOffer(OfferVO offerVO) {
//		return session.insert("joinOffer", offerVO);
//	}
	
	public int checkOfferOverlap(LoginModel model) throws Exception {
		return session.selectOne("checkOfferOverlap",model);
	}
	
	public int joinOffer(OfferVO offerVO) throws Exception {
		return session.insert("joinOffer",offerVO);
	}
	
}
