package com.lx.odw.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lx.odw.vo.ProjectJobListVO;
import com.lx.odw.vo.ProjectVO;

@Repository
public class SeekerDAO {

	@Autowired
	SqlSession session;
	
	public List<ProjectVO> getProjectList() {
		return session.selectList("getProjectList");
	}

	public List<ProjectJobListVO> requestProjectJobListByProjectNumber(ProjectVO projectVO) {
		return session.selectList("requestProjectJobListByProjectNumber",projectVO);
	}

}
