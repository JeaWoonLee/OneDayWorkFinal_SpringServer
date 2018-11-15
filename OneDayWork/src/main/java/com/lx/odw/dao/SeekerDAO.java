package com.lx.odw.dao;

import java.util.List;
import java.util.logging.Logger;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lx.odw.model.FilterModel;
import com.lx.odw.vo.JobCandidateVO;
import com.lx.odw.vo.JobVO;
import com.lx.odw.vo.ManageVO;
import com.lx.odw.vo.ProjectVO;

@Repository
public class SeekerDAO {

	@Autowired
	SqlSession session;
	
	public List<ProjectVO> getProjectList(FilterModel model) {
		return session.selectList("getProjectList",model);
	}

	public List<JobVO> requestProjectJobListByProjectNumber(ProjectVO projectVO) {
		return session.selectList("requestProjectJobListByProjectNumber",projectVO);
	}

	public ProjectVO requestProjectDetail(ProjectVO projectVO) {
		return session.selectOne("requestProjectDetail",projectVO);
	}

	public JobVO requestJobDetail(JobVO vo) {
		return session.selectOne("requestJobDetail",vo);
	}

	public int requestTargetDateCount(JobCandidateVO vo) {
		return session.selectOne("requestTargetDateCount",vo);
	}

	public Integer candidateJob(JobCandidateVO vo) {
		return session.insert("candidateJob",vo);
	}

	public int checkAnotherAccepted(JobCandidateVO vo) {
		return session.selectOne("checkAnotherAccepted",vo);
	}

	public int checkDuplicateCandidate(JobCandidateVO vo) {
		return session.selectOne("checkDuplicateCandidate",vo);
	}

	public int checkDuplicateAcceptCandidate(JobCandidateVO vo) {
		return session.selectOne("checkDuplicateAcceptCandidate",vo);
	}

	public List<JobCandidateVO> requestDisableDaysByJobNumber(int jobNumber) {
		return session.selectList("requestDisableDaysByJobNumber",jobNumber);
	}
	

	public List<ManageVO> managejobList(ManageVO vo) {
	return session.selectList("managejobList", vo);
	
	}
	
	public int cancelProject(ManageVO vo) {
		return session.update("cancelProject", vo);
	}

	public ManageVO requestManageProjectDetail(ManageVO vo) {
		
		return session.selectOne("requestManageProjectDetail", vo);
	}


}
