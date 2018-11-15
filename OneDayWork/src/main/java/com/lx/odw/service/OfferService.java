package com.lx.odw.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lx.odw.vo.JobVO;
import com.lx.odw.vo.ProjectVO;

@Service
public interface OfferService {

	List<ProjectVO> getOffList();

	List<JobVO> requestOffJobListByProjectNumber(ProjectVO projectVO);
	
	//web 일감 목록
	List<ProjectVO> projectList(ProjectVO projectVO);

}
