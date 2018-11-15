package com.lx.odw.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lx.odw.service.OfferService;
import com.lx.odw.service.SeekerService;
import com.lx.odw.vo.JobVO;
import com.lx.odw.vo.OfferVO;
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
	public List<JobVO> requestOffJobListByProjectNumber(ProjectVO projectVO) {
		return offerDAO.requestOffJobListByProjectNumber(projectVO);
	}

	//웹 구인자 일감목록
	@Override
	public List<ProjectVO> projectList(String offerId) {
		return offerDAO.projectList(offerId);
	}

	//웹 구인자 상세정보
	@Override
	public String showPrjDetail(ProjectVO vo, HttpServletRequest request) {
		HttpSession session = request.getSession();
		OfferVO offerVO = (OfferVO) session.getAttribute("loginInfo");
		if(offerVO != null) {
			ProjectVO item = offerDAO.showPrjDetail(vo);
			request.setAttribute("projectVO", item);
			System.out.println(item);
		} else {
			return "offerLogin";
		}
		return "projectDetail";
	}

}
