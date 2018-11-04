package com.lx.odw.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lx.odw.service.SeekerService;
import com.lx.odw.vo.ProjectJobListVO;
import com.lx.odw.vo.ProjectVO;

@Repository
public class SeekerServiceImpl implements SeekerService{

	@Autowired
	SeekerDAO seekerDAO;
	
	@Override
	public List<ProjectVO> getProjectList() {
		return seekerDAO.getProjectList();
	}

	@Override
	public List<ProjectJobListVO> requestProjectJobListByProjectNumber(ProjectVO projectVO) {
		return seekerDAO.requestProjectJobListByProjectNumber(projectVO);
	}

}
