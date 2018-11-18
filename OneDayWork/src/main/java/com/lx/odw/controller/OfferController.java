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
	
<<<<<<< HEAD
	//웹 사용자가 등록한 일감 목록
	@RequestMapping(value="offerProjectList.do", method=RequestMethod.POST)
	public String searchEmpListByDeptId(ProjectVO projectVO, HttpServletRequest request) {
		//로그인에서 받아오는 부분
		HttpSession session = request.getSession();//session=상태정보; 로그인한 사용자 목록만 볼수 있음 
		OfferVO offerVO = (OfferVO) session.getAttribute("loginInfo");
		List<ProjectVO> list = offerDAO.projectList(projectVO);
				
		request.setAttribute("projectList", list);
		
		return "projectList";
=======
	@RequestMapping(value="insertProject.do",method=RequestMethod.POST)
	public @ResponseBody String insertProject (ProjectVO vo, String jobs,HttpSession seesion){
		return service.insertProject(vo,jobs,seesion);
>>>>>>> branch 'master' of https://github.com/JeaWoonLee/OneDayWorkFinal_SpringServer
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
}
