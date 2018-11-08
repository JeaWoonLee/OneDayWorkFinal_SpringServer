package com.lx.odw.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lx.odw.vo.ProjectCandidateQueueVO;
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

	public ProjectVO requestProjectDetail(ProjectVO projectVO) {
		return session.selectOne("requestProjectDetail",projectVO);
	}

	public ProjectJobListVO requestJobDetail(ProjectJobListVO vo) {
		return session.selectOne("requestJobDetail",vo);
	}

	public int requestTargetDateCount(ProjectCandidateQueueVO vo) {
		return session.selectOne("requestTargetDateCount",vo);
	}

	public Integer candidateJob(ProjectCandidateQueueVO vo) {
		return session.insert("candidateJob",vo);
	}

	public int checkAnotherAccepted(ProjectCandidateQueueVO vo) {
		return session.selectOne("checkAnotherAccepted",vo);
	}

	public int checkDuplicateCandidate(ProjectCandidateQueueVO vo) {
		return session.selectOne("checkDuplicateCandidate",vo);
	}

	public int checkDuplicateAcceptCandidate(ProjectCandidateQueueVO vo) {
		return session.selectOne("checkDuplicateAcceptCandidate",vo);
	}

}
