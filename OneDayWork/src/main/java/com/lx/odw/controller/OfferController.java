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
	
	//Ïõπ Íµ¨Ïù∏Ïûê ÏùºÍ∞êÎ™©Î°ù
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
	//¿• ªÁøÎ¿⁄∞° µÓ∑œ«— ¿œ∞® ∏Ò∑œ
	@RequestMapping(value="offerProjectList.do", method=RequestMethod.POST)
	public String searchEmpListByDeptId(ProjectVO projectVO, HttpServletRequest request) {
		//∑Œ±◊¿Œø°º≠ πﬁæ∆ø¿¥¬ ∫Œ∫–
		HttpSession session = request.getSession();//session=ªÛ≈¬¡§∫∏; ∑Œ±◊¿Œ«— ªÁøÎ¿⁄ ∏Ò∑œ∏∏ ∫ººˆ ¿÷¿Ω 
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
		
	//Ïõπ Íµ¨Ïù∏Ïûê ÏÉÅÏÑ∏Ï†ïÎ≥¥
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
	
	//Ïª§Î∞ã ÌÖåÏä§Ìä∏
	@RequestMapping("haruMainPage.do")
	public String offerLogin() {
		System.out.println("haruMainPageÏù¥ Ïã§ÌñâÎê®");
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
