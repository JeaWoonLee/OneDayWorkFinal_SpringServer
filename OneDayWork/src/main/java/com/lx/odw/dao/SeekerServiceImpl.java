package com.lx.odw.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lx.odw.model.FilterModel;
import com.lx.odw.service.SeekerService;
import com.lx.odw.vo.JobCandidateVO;
import com.lx.odw.vo.JobVO;
import com.lx.odw.vo.ProjectVO;

@Repository
public class SeekerServiceImpl implements SeekerService{

	@Autowired
	SeekerDAO seekerDAO;
	
	@Override
	public List<ProjectVO> getProjectList(FilterModel model) {
		return seekerDAO.getProjectList(model);
	}

	@Override
	public List<JobVO> requestProjectJobListByProjectNumber(ProjectVO projectVO) {
		return seekerDAO.requestProjectJobListByProjectNumber(projectVO);
	}

	@Override
	public ProjectVO requestProjectDetail(ProjectVO projectVO) {
		return seekerDAO.requestProjectDetail(projectVO);
	}

	@Override
	public JobVO requestJobDetail(JobVO vo) {
		return seekerDAO.requestJobDetail(vo);
	}

	@Override
	public int requestTargetDateCount(JobCandidateVO vo) {
		return seekerDAO.requestTargetDateCount(vo);
	}

	@Override
	public Integer candidateJob(JobCandidateVO vo) {
		
		final int ANOTHER_ACCEPTED = 2;
		final int CANDIDATE_DUPLICATED = 3;
		final int ACCEPTED_DUPLICATED = 4;
		//���� ��¥�� ������ ���� �ϰ��� �ִ��� Ȯ���Ѵ�
		int checkDuplicateAcceptCandidate = seekerDAO.checkDuplicateAcceptCandidate(vo);
		if(checkDuplicateAcceptCandidate == 1) {
			return ACCEPTED_DUPLICATED;
		}
		
		//���� ��¥�� ���� �ϰ����� ��û �Ǿ� �ִ��� Ȯ���Ѵ�.
		int checkDuplicateCandidate = seekerDAO.checkDuplicateCandidate(vo);
		if(checkDuplicateCandidate == 1) {
			return CANDIDATE_DUPLICATED;
		}
		
		//���� ��¥�� ������ �ϰ��� �ִ��� Ȯ���Ѵ�.
		int checkAnotherAccepted = seekerDAO.checkAnotherAccepted(vo);
		if(checkAnotherAccepted == 1) {
			return ANOTHER_ACCEPTED;
		}
		
		
		
		//�μ�Ʈ�ϱ�
		return seekerDAO.candidateJob(vo);
	}

	@Override
	public List<JobCandidateVO> manageJobList(JobCandidateVO vo) {
		return seekerDAO.managejobList(vo);
	}

}
