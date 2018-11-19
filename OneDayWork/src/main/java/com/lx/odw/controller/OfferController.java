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
import com.lx.odw.model.CandidateMapResponseModel;
import com.lx.odw.service.OfferService;

import com.lx.odw.vo.CommuteInfoVO;

import com.lx.odw.vo.JobCandidateVO;
import com.lx.odw.vo.JobVO;
import com.lx.odw.vo.OfferVO;
import com.lx.odw.vo.OfferWorkVO;
import com.lx.odw.vo.ProjectDetailVO;
import com.lx.odw.vo.ProjectVO;

import com.lx.odw.vo.SeekerDetailVO;

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
	
	@RequestMapping(value="seekerList.do",method=RequestMethod.GET)
	public String seekerList(HttpServletRequest request) {//요청을 받는 내장객체 httpservletrequest
		HttpSession session = request.getSession();
		JobVO jobVO = (JobVO) session.getAttribute("projectNumber");
		
		return "seekerList";
	}

		

	@RequestMapping(value="insertProject.do",method=RequestMethod.POST)
	public @ResponseBody String insertProject (ProjectVO vo, String jobs,HttpSession seesion){
		return service.insertProject(vo,jobs,seesion);
	}
		
	//웹 구인자 상세정보

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

	@RequestMapping(value="requestOfferProjectList.do",method=RequestMethod.POST)
	public @ResponseBody List<OfferWorkVO> requestOfferProjectList(String offerId) {
		return service.requestOfferProjectList(offerId);
	}
	
	@RequestMapping(value="getProjectCommuteInfo.do",method=RequestMethod.POST)
	public @ResponseBody OfferWorkVO getProjectCommuteInfo(String projectNumber) {
		return service.getProjectCommuteInfo(projectNumber);
	}
	
	@RequestMapping(value="requestProjectCommuteInfo.do", method=RequestMethod.POST)
	public @ResponseBody CommuteInfoVO requestProjectCommuteInfo(String projectNumber) {
		return service.requestProjectCommuteInfo(projectNumber);
	}
	
	@RequestMapping(value="requestAbsentByCandidateNumber",method=RequestMethod.POST)
	public @ResponseBody int requestAbsentByCandidateNumber(JobCandidateVO vo) {
		return service.requestAbsentByCandidateNumber(vo);
	}
	
	@RequestMapping(value="requestWorkingByCandidateNumber",method=RequestMethod.POST)
	public @ResponseBody int requestWorkingByCandidateNumber(JobCandidateVO vo) {
		return service.requestWorkingByCandidateNumber(vo);
	}
	
	@RequestMapping(value="requestOffWorkByCandidateNumber",method=RequestMethod.POST)
	public @ResponseBody int requestOffWorkByCandidateNumber(JobCandidateVO vo) {
		return service.requestOffWorkByCandidateNumber(vo);
	}
	
	@RequestMapping(value="requestEvaluate.do",method=RequestMethod.POST)
	public @ResponseBody int requestEvaluate(JobCandidateVO vo) {
		return service.requestEvaluate(vo);
	}
	
	@RequestMapping(value="requestSeekerDetailPopup.do",method=RequestMethod.POST)
	public @ResponseBody SeekerDetailVO requestSeekerDetail(SeekerVO vo) {
		return service.requestSeekerDetail(vo);
	}
	
	@RequestMapping(value="allAbsent.do",method=RequestMethod.POST)
	public @ResponseBody int  allAbsent(ProjectVO vo) {
		return service.allAbsent(vo);
	}
	
	@RequestMapping(value="allWorking.do",method=RequestMethod.POST)
	public @ResponseBody int  allWorking(ProjectVO vo) {
		return service.allWorking(vo);
	}
	
	@RequestMapping(value="allOffWork.do",method=RequestMethod.POST)
	public @ResponseBody int  allOffWork(ProjectVO vo) {
		return service.allOffWork(vo);
	}
	
	@RequestMapping(value="requestOfferManageProjectList.do",method=RequestMethod.POST)
	public @ResponseBody List<ProjectVO> requestOfferManageProjectList(OfferVO vo) {
		return service.requestOfferManageProjectList(vo);
	}
	
	@RequestMapping(value="requestManageProjectDetailInfo.do",method=RequestMethod.POST)
	public @ResponseBody ProjectDetailVO requestManageProjectDetailInfo(ProjectVO vo) {
		return service.requestManageProjectDetailInfo(vo);
	}
	
	@RequestMapping(value="requestCandidateListByJobNumber.do",method=RequestMethod.POST)
	public @ResponseBody CandidateMapResponseModel requestCandidateListByJobNumber (JobCandidateVO vo) {
		return service.requestCandidateListByJobNumber(vo);
	}
	
	@RequestMapping(value="requestAcceptCandidateByCandidateNumber.do", method=RequestMethod.POST)
	public @ResponseBody int requestAcceptCandidateByCandidateNumber(JobCandidateVO vo) {
		return service.requestAcceptCandidateByCandidateNumber(vo);
	}

}
