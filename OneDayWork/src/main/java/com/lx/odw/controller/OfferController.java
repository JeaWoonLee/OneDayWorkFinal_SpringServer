package com.lx.odw.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lx.odw.dao.OfferDAO;
import com.lx.odw.service.OfferService;
import com.lx.odw.vo.JobCandidateVO;
import com.lx.odw.vo.JobVO;
import com.lx.odw.vo.OfferVO;
import com.lx.odw.vo.ProjectVO;
import com.lx.odw.vo.SeekerVO;

@Controller
public class OfferController {

	@Autowired
	OfferService service;
	
	@Autowired
	OfferDAO offerDAO;
	
	
	@RequestMapping(value="getOffList.do", method=RequestMethod.POST)
	public @ResponseBody List<ProjectVO> getOffList(){
		return service.getOffList();
	}
	
	@RequestMapping(value="requestOffJobListByProjectNumber.do", method = RequestMethod.POST)
	public @ResponseBody List<JobVO> requestOffJobListByProjectNumber(ProjectVO projectVO){
		return service.requestOffJobListByProjectNumber(projectVO);
		
	}
	
	//�쎒 援ъ씤�옄 �씪媛먮ぉ濡�
	@RequestMapping(value="projectList.do", method=RequestMethod.GET)
	public String projectList(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		OfferVO offerVO = (OfferVO) session.getAttribute("loginInfo");
		if(offerVO != null) {
			List<ProjectVO> list = service.projectList(offerVO.getOfferId());
			request.setAttribute("projectList", list);
		} else {
			return "offerLogin";
		}
		return "projectList";
	}
	
		
	//�쎒 援ъ씤�옄 �긽�꽭�젙蹂�
	@RequestMapping(value="showPrjDetail.do",method=RequestMethod.GET)
	public String showPrjDetail (ProjectVO vo,HttpServletRequest request) {
		HttpSession session = request.getSession();
		OfferVO offerVO = (OfferVO) session.getAttribute("loginInfo");
		if(offerVO != null) {
			ProjectVO item = offerDAO.showPrjDetail(vo);
			request.setAttribute("prjDetail", item);
			return "projectDetail";
		} else {
			return "offerLogin";
		}
	}
	
	@RequestMapping(value="seekerList.do",method=RequestMethod.GET)
	public String seekerList(SeekerVO seekerVO, HttpServletRequest request) {//요청을 받는 내장객체 httpservletrequest
		HttpSession session = request.getSession();
		JobCandidateVO jobcandidateVO  = (JobCandidateVO) session.getAttribute("seekerId");
		
		return "seekerList";
	}
	
	//而ㅻ컠 �뀒�뒪�듃
	@RequestMapping("haruMainPage.do")
	public String offerLogin() {
		System.out.println("haruMainPage�씠 �떎�뻾�맖");
		return "haruMainPage";
	}
	
	@RequestMapping(value="registration.do",method=RequestMethod.GET)
	public String registration(HttpServletRequest request) {
		HttpSession session = request.getSession();
		OfferVO offerVO = (OfferVO)session.getAttribute("loginInfo");
		if(offerVO == null) {
			return "offerLogin";
		}
		return "registration";
	}
	
	
//	
//	@RequestMapping(value="projectList.do", method=RequestMethod.GET)
//	public String projectList(HttpServletRequest request) {
//		
//		HttpSession session = request.getSession();
//		OfferVO offerVO = (OfferVO) session.getAttribute("loginInfo");
//		if(offerVO != null) {
//			List<ProjectVO> list = service.projectList(offerVO.getOfferId());
//			request.setAttribute("projectList", list);
//		} else {
//			return "offerLogin";
//		}
//		return "projectList";
//	}
}
