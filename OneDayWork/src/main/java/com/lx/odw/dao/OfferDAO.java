package com.lx.odw.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lx.odw.vo.JobVO;
import com.lx.odw.vo.ProjectVO;

@Repository
public class OfferDAO {

	@Autowired
	SqlSession session;
	
	public List<ProjectVO> getOffList() {
		return session.selectList("getOffList");
	}

	public List<JobVO> requestOffJobListByProjectNumber(ProjectVO projectVO) {
		return session.selectList("requestOffJobListByProjectNumber",projectVO);
	}
	
	//웹 일감 목록
	public List<ProjectVO> projectList(ProjectVO projectVO) {
		return session.selectList("projectList",projectVO);
	}
	
	

}
