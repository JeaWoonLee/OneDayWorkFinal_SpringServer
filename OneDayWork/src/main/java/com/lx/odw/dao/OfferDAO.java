package com.lx.odw.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lx.odw.vo.JobVO;
import com.lx.odw.vo.OfferVO;
import com.lx.odw.vo.ProjectVO;
import com.lx.odw.vo.SeekerVO;

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
	
	//�쎒 援ъ씤�옄 �씪源�紐⑸줉
	public List<ProjectVO> projectList(String offerId) {
		return session.selectList("projectList", offerId);
	}

	@Transactional
	public int insertProject(ProjectVO vo) {
		return session.insert("insertProject",vo);
	}

	@Transactional
	public int insertJobs(List<JobVO> list) {
		return session.insert("insertJobs",list);
	}

	@Transactional
	public int subOfferCash(OfferVO offerVO) {
		return session.update("subOfferCash",offerVO);
	}
	//�쎒 援ъ씤�옄 �긽�꽭�젙蹂�
	public ProjectVO showPrjDetail(ProjectVO vo) {
		return session.selectOne("showPrjDetail",vo);
	}
	
	//웹 신청자 목록
	public List<SeekerVO> seekerList(String seekerId) {
		return session.selectList("seekerList", seekerId);
	}

	
	
//	public List<ProjectVO> getFaqList() {
//		return session.selectList("faqList");
//	}
	
	

}
