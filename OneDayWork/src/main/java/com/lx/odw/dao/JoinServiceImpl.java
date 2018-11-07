package com.lx.odw.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lx.odw.model.LoginModel;
import com.lx.odw.model.ResponseModel;
import com.lx.odw.service.JoinService;
import com.lx.odw.vo.OfferVO;
import com.lx.odw.vo.SeekerVO;

@Repository
public class JoinServiceImpl implements JoinService{

	@Autowired
	JoinDAO joinDAO;
	
	@Override
	public ResponseModel checkSeekerOverlap(LoginModel model) throws Exception {
		int overlapResult = joinDAO.checkSeekerOverlap(model);
		ResponseModel responseModel = new ResponseModel();
		responseModel.setResponse(overlapResult);
		return responseModel;
	}

	@Override
	public ResponseModel joinSeeker(SeekerVO seekerVO) throws Exception {
		int insertResult = joinDAO.joinSeeker(seekerVO);
		ResponseModel responseModel = new ResponseModel();
		responseModel.setResponse(insertResult);
		return responseModel;
	}

	@Override
	public ResponseModel checkOfferOverlap(LoginModel model) throws Exception {
		int overlapResult = joinDAO.checkOfferOverlap(model);
		ResponseModel responseModel = new ResponseModel();
		responseModel.setResponse(overlapResult);
		return responseModel;
	}

	@Override
	public ResponseModel joinOffer(OfferVO offerVO) throws Exception {
		int inserResult = joinDAO.joinOffer(offerVO);
		ResponseModel responseModel = new ResponseModel();
		responseModel.setResponse(inserResult);
		return responseModel;
	}

}
