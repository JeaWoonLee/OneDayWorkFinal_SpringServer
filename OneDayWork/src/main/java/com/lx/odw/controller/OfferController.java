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
import com.lx.odw.vo.JobVO;
import com.lx.odw.vo.OfferVO;
import com.lx.odw.vo.ProjectVO;

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
	
	//웹 구인자 일감목록
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
	
	//커밋 테스트
	@RequestMapping("haruMainPage.do")
	public String offerLogin() {
		System.out.println("haruMainPage이 실행됨");
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
}
