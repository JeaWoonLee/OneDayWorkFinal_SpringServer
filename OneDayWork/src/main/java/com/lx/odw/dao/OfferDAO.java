package com.lx.odw.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lx.odw.vo.CertificationVO;
import com.lx.odw.vo.JobCandidateVO;
import com.lx.odw.vo.JobVO;
import com.lx.odw.vo.OfferVO;
import com.lx.odw.vo.OfferWorkVO;
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
<<<<<<< HEAD
	
	//웹 신청자 목록
	public List<SeekerVO> seekerList(String seekerId) {
		return session.selectList("seekerList", seekerId);
	}

	
	
//	public List<ProjectVO> getFaqList() {
//		return session.selectList("faqList");
//	}
	
	
=======

	public List<OfferWorkVO> requestOfferProjectList(String offerId) {
		return session.selectList("requestOfferProjectList",offerId);
	}

	public OfferWorkVO getProjectCommuteInfo(String projectNumber) {
		return session.selectOne("getProjectCommuteInfo",projectNumber);
	}

	public List<JobVO> getJobNumberList(String projectNumber) {
		return session.selectList("getJobNumberList",projectNumber);
	}

	public List<JobCandidateVO> getCommuteListByJobNumber(int jobNumber) {
		return session.selectList("getCommuteListByJobNumber",jobNumber);
	}

	public int requestAbsentByCandidateNumber(JobCandidateVO vo) {
		return session.update("requestAbsentByCandidateNumber",vo);
	}

	public int requestWorkingByCandidateNumber(JobCandidateVO vo) {
		return session.update("requestWorkingByCandidateNumber",vo);
	}

	public int requestOffWorkByCandidateNumber(JobCandidateVO vo) {
		return session.update("requestOffWorkByCandidateNumber",vo);
	}

	public int requestEvaluate(JobCandidateVO vo) {
		return session.update("requestEvaluate",vo);
	}

	public SeekerVO requestSeekerDetail(SeekerVO vo) {
		return session.selectOne("requestSeekerDetailPopup",vo);
	}

	public List<JobCandidateVO> requestSeekerRecord(SeekerVO vo) {
		return session.selectList("requestSeekerRecord",vo);
	}

	public List<CertificationVO> requestSeekerCertificate(SeekerVO vo) {
		return session.selectList("requestSeekerCertificate",vo);
	}

	public int allAbsent(ProjectVO vo) {
		return session.update("allAbsent",vo);
	}

	public int allWorking(ProjectVO vo) {
		return session.update("allWorking",vo);
	}

	public int allOffWork(ProjectVO vo) {
		return session.update("allOffWork",vo);
	}

	public List<ProjectVO> requestOfferManageProjectList(OfferVO vo) {
		return session.selectList("requestOfferManageProjectList",vo);
	}

	public ProjectVO requestManageProjectDetailInfo(ProjectVO vo) {
		return session.selectOne("requestManageProjectDetailInfo",vo);
	}

	public List<JobCandidateVO> getTargetDateListByJobNumber(JobCandidateVO vo) {
		return session.selectList("getTargetDateListByJobNumber",vo);
	}

	public JobCandidateVO getCandidateListByCandidateVO(JobCandidateVO vo) {
		return session.selectOne("getCandidateListByCandidateVO",vo);
	}

	public int requestAcceptCandidateByCandidateNumber(JobCandidateVO vo) {
		return session.update("requestAcceptCandidateByCandidateNumber",vo);
	}	
>>>>>>> branch 'master' of https://github.com/JeaWoonLee/OneDayWorkFinal_SpringServer

}
