package com.lx.odw.service;

import org.springframework.stereotype.Service;

import com.lx.odw.model.LoginModel;
import com.lx.odw.model.ResponseModel;
import com.lx.odw.vo.OfferVO;
import com.lx.odw.vo.SeekerVO;

@Service
public interface JoinService {

	ResponseModel checkSeekerOverlap(LoginModel model) throws Exception;

	ResponseModel joinSeeker(SeekerVO seekerVO);
	
//	ResponseModel joinOffer(OfferVO offerVO);

	ResponseModel checkOfferOverlap(LoginModel model) throws Exception;

	ResponseModel joinOffer(OfferVO offerVO) throws Exception;
	

}
