package com.lx.odw.service;

import java.util.List;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.lx.odw.vo.JobVO;
import com.lx.odw.vo.ProjectVO;
import com.lx.odw.vo.SeekerVO;

@Service
public interface OfferService {

	List<ProjectVO> getOffList();

	List<JobVO> requestOffJobListByProjectNumber(ProjectVO projectVO);
	
	//�쎒 援ъ씤�옄 �씪媛먮ぉ濡�
	List<ProjectVO> projectList(String offerId);
	
	List<SeekerVO> seekerList(SeekerVO seekervo, String offerId);
	

	//�쎒 援ъ씤�옄 �긽�꽭�젙蹂�
	String showPrjDetail(ProjectVO vo, HttpServletRequest request);

	String insertProject(ProjectVO vo, String jobs, HttpSession seesion);



}
