package com.lx.odw.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.lx.odw.service.OfferService;
import com.lx.odw.vo.JobVO;
import com.lx.odw.vo.OfferVO;
import com.lx.odw.vo.OfferWorkVO;
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

	@Override
	public String insertProject(ProjectVO vo, String jobs,HttpSession session) {
		
		OfferVO offerVO = (OfferVO) session.getAttribute("loginInfo");
		vo.setOfferId(offerVO.getOfferId());
		int insertProjectResult = offerDAO.insertProject(vo);
		if(insertProjectResult > 0) {
			
			int pay = 0;
			Gson gson = new Gson();
			JobVO[] items = gson.fromJson(jobs, JobVO[].class);
			for(int i = 0 ; i < items.length ; i ++ ) {
				pay += items[i].getPay();
			}
			List<JobVO> list = new ArrayList<JobVO>(Arrays.asList(items));
			int insertJobsResult = offerDAO.insertJobs(list);
			if(insertJobsResult > 0 ) {
				offerVO.setOfferCash(pay);
				int subOfferCash = offerDAO.subOfferCash(offerVO);
				if(subOfferCash > 0) {
					//성공
					return "프로젝트를 성공적으로 등록하였습니다";
				}
			}else {
				//insert job 실패
				return "직군 정보를 추가하는데 실패했습니다";
			}
		}
		return "프로젝트 등록에 실패하였습니다";
	}

	@Override
	public List<OfferWorkVO> requestOfferProjectList(String offerId) {
		return offerDAO.requestOfferProjectList(offerId);
	}

	@Override
	public OfferWorkVO getProjectCommuteInfo(String projectNumber) {
		return offerDAO.getProjectCommuteInfo(projectNumber);
	}
}
