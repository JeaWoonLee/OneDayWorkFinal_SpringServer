package com.lx.odw.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lx.odw.service.OfferService;
import com.lx.odw.service.SeekerService;
import com.lx.odw.vo.ProjectJobListVO;
import com.lx.odw.vo.ProjectVO;

@Repository
public class OfferServiceImpl implements OfferService{

	@Autowired
	OfferDAO offerDAO;
	
	@Override
	public List<ProjectVO> getOffList() {
		return offerDAO.getOffList();
	}

	@Override
	public List<ProjectJobListVO> requestOffJobListByProjectNumber(ProjectVO projectVO) {
		return offerDAO.requestOffJobListByProjectNumber(projectVO);
	}

}
