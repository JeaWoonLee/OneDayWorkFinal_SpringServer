package com.lx.odw.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.lx.odw.vo.JobVO;
import com.lx.odw.vo.ProjectVO;

@Service
public interface OfferService {

	List<ProjectVO> getOffList();

	List<JobVO> requestOffJobListByProjectNumber(ProjectVO projectVO);
	
	//웹 구인자 일감목록
	List<ProjectVO> projectList(String offerId);

	//웹 구인자 상세정보
	String showPrjDetail(ProjectVO vo, HttpServletRequest request);

}
