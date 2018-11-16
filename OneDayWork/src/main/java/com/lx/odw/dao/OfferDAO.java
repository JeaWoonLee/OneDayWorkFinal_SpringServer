package com.lx.odw.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lx.odw.vo.JobVO;
import com.lx.odw.vo.OfferVO;
import com.lx.odw.vo.OfferWorkVO;
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
	
	//웹 구인자 일김목록
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
	//웹 구인자 상세정보
	public ProjectVO showPrjDetail(ProjectVO vo) {
		return session.selectOne("showPrjDetail",vo);
	}

	public List<OfferWorkVO> requestOfferProjectList(String offerId) {
		return session.selectList("requestOfferProjectList",offerId);
	}

	public OfferWorkVO getProjectCommuteInfo(String projectNumber) {
		return session.selectOne("getProjectCommuteInfo",projectNumber);
	}
	
//	public List<ProjectVO> getFaqList() {
//		return session.selectList("faqList");
//	}
	
	

}
