package com.lx.odw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lx.odw.model.LoginModel;
import com.lx.odw.model.ResponseModel;
import com.lx.odw.service.JoinService;
import com.lx.odw.vo.OfferVO;
import com.lx.odw.vo.SeekerVO;

@Controller
public class JoinController {

	@Autowired
	JoinService service;
	
	@RequestMapping(value="checkSeekerOverlap.do",method=RequestMethod.POST)
	public @ResponseBody ResponseModel checkOverlap(LoginModel model) throws Exception {
		return service.checkSeekerOverlap(model);
	}
	
	@RequestMapping(value="joinSeeker.do",method=RequestMethod.POST)
	public @ResponseBody ResponseModel joinSeeker(SeekerVO seekerVO) throws Exception {
		return service.joinSeeker(seekerVO);
	}
		
	@RequestMapping(value="checkOfferOverlap.do",method=RequestMethod.POST)
	public @ResponseBody ResponseModel checkOverlap1(LoginModel model) throws Exception {
		return service.checkOfferOverlap(model);
	}
	
	@RequestMapping(value="joinOffer.do", method=RequestMethod.POST)
	public @ResponseBody ResponseModel joinOffer(OfferVO offerVO) throws Exception {
		return service.joinOffer(offerVO);
	}
	
	@RequestMapping(value="joinOffer.do", method=RequestMethod.GET)
	public String joinOffer() {
		System.out.println("joinOffer.do를 통해 웹페이지가 요청됨");
		return "joinOffer";
	}
	
//	//웹페이지를 요청하는 소스 
//	@RequestMapping(value="/joinOffer.do")
//	public String joinOffer() {
//		System.out.println("joinOffer.do를 통해 웹페이지가 요청됨");
//		return "joinOffer"; //여기에 jsp파일 이름을 적음
//	}
//	
//	//만약에 jsp파일에서 submit으로 버튼을 생성했으면 그 버튼을 눌렀을 때 form 태그에 있던 action이 실행되면서 일로 넘어옴 .
//	@RequestMapping(value="/joinOffer.do", method=RequestMethod.POST)
//	public String searchEmpListByDeptId(EmpVO empVO, HttpServletRequest request) {
//		logger.info("searchEmpListByDeptId");
//		logger.info("deptId : " + empVO);
//		List<EmpVO> list = empDAO.searchEmpListByDeptId(empVO);
//		if(list == null) {
//			logger.info("list가 null 입니다");
//		}else {
//			for(EmpVO item : list) logger.info(item.toString());
//		}
//		
//		request.setAttribute("empList", list);
//		
//		return "home";
//	}
//	
	
	
}
