package com.lx.odw.dao;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.lx.odw.controller.CertificateVO;
import com.lx.odw.model.FilterModel;
import com.lx.odw.service.SeekerService;
import com.lx.odw.util.Util;
import com.lx.odw.vo.JobCandidateVO;
import com.lx.odw.vo.JobVO;
import com.lx.odw.vo.ManageVO;
import com.lx.odw.vo.ProjectVO;
import com.lx.odw.vo.SeekerVO;
import com.lx.odw.vo.WorkVO;

@Repository
public class SeekerServiceImpl implements SeekerService{

	@Autowired
	SeekerDAO seekerDAO;
	
	@Override
	public List<ProjectVO> getProjectList(FilterModel model) {
		//PayFilter
		if(model.getJobPayFilter().equals("없음")) {
			model.setMinJobPay(0);
			model.setMaxJobPay(9999999);
		}else if(model.getJobPayFilter().equals("100,000 미만")) {
			model.setMaxJobPay(99999);
			model.setMinJobPay(0);
		}else if(model.getJobPayFilter().equals("100,000 – 150,000")) {
			model.setMaxJobPay(150000);
			model.setMinJobPay(100000);
		}else if(model.getJobPayFilter().equals("150,000 이상")) {
			model.setMaxJobPay(9999999);
			model.setMinJobPay(150000);
		}
		//DistanceFilter
		//경위도 도분초 1m 근사값 : 1초(약30m) / 30
		double oneMeterByDegree = 0.000009259259;
		
		if(model.getMaxDistanceFilter().equals("없음")) {
			//5도 (약 550km) 범위 검색
			model.setMaxDistance(5);
		}else {
			model.setMaxDistance(oneMeterByDegree * Double.valueOf(model.getMaxDistanceFilter()));
			System.out.println("oneMeterByDegree" + oneMeterByDegree);
			System.out.println("getMaxDistanceFilter" + Double.valueOf(model.getMaxDistanceFilter()));
			System.out.println(oneMeterByDegree * Double.valueOf(model.getMaxDistanceFilter()));
		}
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
		int checkDuplicateAcceptCandidate = seekerDAO.checkDuplicateAcceptCandidate(vo);
		if(checkDuplicateAcceptCandidate == 1) {
			return ACCEPTED_DUPLICATED;
		}
		
		int checkDuplicateCandidate = seekerDAO.checkDuplicateCandidate(vo);
		if(checkDuplicateCandidate == 1) {
			return CANDIDATE_DUPLICATED;
		}
		
		int checkAnotherAccepted = seekerDAO.checkAnotherAccepted(vo);
		if(checkAnotherAccepted == 1) {
			return ANOTHER_ACCEPTED;
		}
		
		return seekerDAO.candidateJob(vo);
	}

	@Override
	public List<JobCandidateVO> requestDisableDaysByJobNumber(int jobNumber) {
		return seekerDAO.requestDisableDaysByJobNumber(jobNumber);
	}
	
	@Override
	public List<ManageVO> manageJobList(ManageVO vo) {
		return seekerDAO.managejobList(vo);
	}
	
	@Override
	public int cancelProject(ManageVO vo) {
		return seekerDAO.cancelProject(vo);
	}

	@Override
	public ManageVO requestManageProjectDetail(ManageVO vo) {
		return seekerDAO.requestManageProjectDetail(vo);
		
	}

	@Override
	public SeekerVO requestSeekerDetail(SeekerVO seekerVO) {
		return seekerDAO.requestSeekerDetail(seekerVO);
	}

	@Override
	public List<CertificateVO> requestSeekerCertificationDetail(SeekerVO seekerVO) {
		return seekerDAO.requestSeekerCertificationDetail(seekerVO);
	}

	@Override
	public int updateSeeker(String seekerVO,String seekerPicture, HttpServletRequest request) {
		Gson gson = new Gson();
		SeekerVO item = gson.fromJson(seekerVO, SeekerVO.class);
		String imgPath = Util.getUplodaPath(seekerPicture,request,item.getSeekerId());
		item.setSeekerPicture(imgPath);
		return seekerDAO.updateSeeker(item);
	}

	@Override
	public WorkVO requestTodayWorkDetail(String seekerId) {
		return seekerDAO.requestTodayWorkDetail(seekerId);
	}

	@Override
	public int requestCommute(SeekerVO vo) {
		return seekerDAO.requestCommute(vo);
	}

}
