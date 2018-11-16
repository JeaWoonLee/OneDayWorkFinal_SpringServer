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
	OfferDAO offerDAO;
	
	
	@RequestMapping(value="getOffList.do", method=RequestMethod.POST)
	public @ResponseBody List<ProjectVO> getOffList(){
		return service.getOffList();
	}
	
	@RequestMapping(value="requestOffJobListByProjectNumber.do", method = RequestMethod.POST)
	public @ResponseBody List<JobVO> requestOffJobListByProjectNumber(ProjectVO projectVO){
		return service.requestOffJobListByProjectNumber(projectVO);
		
	}
	
	//�� �ϰ� ��� 
	@RequestMapping(value="projectList.do")
	public String projectList() {
		System.out.println("projectList.do�� ���� ���������� ��û��");
		return "projectList";
	}
	
	//�� ����ڰ� ����� �ϰ� ���
	@RequestMapping(value="offerProjectList.do", method=RequestMethod.POST)
	public String searchEmpListByDeptId(ProjectVO projectVO, HttpServletRequest request) {
		//�α��ο��� �޾ƿ��� �κ�
		HttpSession session = request.getSession();//session=��������; �α����� ����� ��ϸ� ���� ���� 
		OfferVO offerVO = (OfferVO) session.getAttribute("loginInfo");
		List<ProjectVO> list = offerDAO.projectList(projectVO);
				
		request.setAttribute("projectList", list);
		
		return "projectList";
	}
		
}
