package com.lx.odw.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lx.odw.service.SeekerService;
import com.lx.odw.vo.ProjectCandidateQueueVO;
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

	@Override
	public ProjectVO requestProjectDetail(ProjectVO projectVO) {
		return seekerDAO.requestProjectDetail(projectVO);
	}

	@Override
	public ProjectJobListVO requestJobDetail(ProjectJobListVO vo) {
		return seekerDAO.requestJobDetail(vo);
	}

	@Override
	public int requestTargetDateCount(ProjectCandidateQueueVO vo) {
		return seekerDAO.requestTargetDateCount(vo);
	}

	@Override
	public Integer candidateJob(ProjectCandidateQueueVO vo) {
		
		final int ANOTHER_ACCEPTED = 2;
		final int CANDIDATE_DUPLICATED = 3;
		final int ACCEPTED_DUPLICATED = 4;
		//같은 날짜에 수락된 같은 일감이 있는지 확인한다
		int checkDuplicateAcceptCandidate = seekerDAO.checkDuplicateAcceptCandidate(vo);
		if(checkDuplicateAcceptCandidate == 1) {
			return ACCEPTED_DUPLICATED;
		}
		
		//같은 날짜에 같은 일감으로 신청 되어 있는지 확인한다.
		int checkDuplicateCandidate = seekerDAO.checkDuplicateCandidate(vo);
		if(checkDuplicateCandidate == 1) {
			return CANDIDATE_DUPLICATED;
		}
		
		//같은 날짜에 수락된 일감이 있는지 확인한다.
		int checkAnotherAccepted = seekerDAO.checkAnotherAccepted(vo);
		if(checkAnotherAccepted == 1) {
			return ANOTHER_ACCEPTED;
		}
		
		
		
		//인서트하기
		return seekerDAO.candidateJob(vo);
	}

}
