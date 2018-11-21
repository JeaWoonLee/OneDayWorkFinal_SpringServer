package com.lx.odw.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lx.odw.model.ManageHumanResourceModel;
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

	public int requestRefuseCandidateByCandidateNumber(JobCandidateVO vo) {
		return session.update("requestRefuseCandidateByCandidateNumber",vo);
	}

	public List<JobCandidateVO> requestProjectRecruitInfo(ProjectVO vo) {
		return session.selectList("requestProjectRecruitInfo",vo);
	}

	public List<JobCandidateVO> requestTargetDateJobNumber(ManageHumanResourceModel vo) {
		return session.selectList("requestTargetDateJobNumber",vo);
	}

	public List<ManageHumanResourceModel> requestRecruitListByJobNumAndTargetDate(JobCandidateVO item) {
		return session.selectList("requestRecruitListByJobNumAndTargetDate",item);
	}
	

}
