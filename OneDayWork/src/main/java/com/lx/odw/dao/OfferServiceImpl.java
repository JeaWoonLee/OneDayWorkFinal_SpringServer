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
import com.lx.odw.vo.ProjectVO;
import com.lx.odw.vo.SeekerVO;

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

	//�쎒 援ъ씤�옄 �씪媛먮ぉ濡�
	@Override
	public List<ProjectVO> projectList(String offerId) {
		return offerDAO.projectList(offerId);
	}
	

	//�쎒 援ъ씤�옄 �긽�꽭�젙蹂�
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
					//�꽦怨�
					return "�봽濡쒖젥�듃瑜� �꽦怨듭쟻�쑝濡� �벑濡앺븯���뒿�땲�떎";
				}
			}else {
				//insert job �떎�뙣
				return "吏곴뎔 �젙蹂대�� 異붽��븯�뒗�뜲 �떎�뙣�뻽�뒿�땲�떎";
			}
		}
		return "�봽濡쒖젥�듃 �벑濡앹뿉 �떎�뙣�븯���뒿�땲�떎";
	}

	@Override
	public List<SeekerVO> seekerList(SeekerVO seekervo, String seekerId) {
		return offerDAO.seekerList(seekerId);
	}
}
