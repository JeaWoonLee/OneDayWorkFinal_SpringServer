package com.lx.odw.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.lx.odw.model.CandidateMapResponseModel;
import com.lx.odw.model.HumanResRsponseModel;
import com.lx.odw.model.ManageHumanResourceModel;
import com.lx.odw.service.OfferService;
import com.lx.odw.util.Util;
import com.lx.odw.vo.CertificationVO;
import com.lx.odw.vo.CommuteInfoVO;
import com.lx.odw.vo.JobCandidateVO;
import com.lx.odw.vo.JobVO;
import com.lx.odw.vo.OfferVO;
import com.lx.odw.vo.OfferWorkVO;
import com.lx.odw.vo.ProjectDetailVO;
import com.lx.odw.vo.ProjectVO;

import com.lx.odw.vo.SeekerDetailVO;

import com.lx.odw.vo.SeekerVO;
import com.lx.odw.vo.WorkVO;

@Repository
public class OfferServiceImpl implements OfferService{

	@Autowired
	OfferDAO offerDAO;

	@Override
	public List<ProjectVO> getOffList() {
		return offerDAO.getOffList();
	}

	@Override
	public List<JobVO> requestOffJobListByProjectNumber(ProjectVO projectVO) {
		return offerDAO.requestOffJobListByProjectNumber(projectVO);
	}

	//�쎒 援ъ씤�옄 �씪媛먮ぉ濡�
	@Override
	public List<ProjectVO> projectList(String offerId) {
		return offerDAO.projectList(offerId);
	}
	

	//�쎒 援ъ씤�옄 �긽�꽭�젙蹂�
	@Override
	public String showPrjDetail(ProjectVO vo, HttpServletRequest request) {
		HttpSession session = request.getSession();
		OfferVO offerVO = (OfferVO) session.getAttribute("loginInfo");
		if(offerVO != null) {
			ProjectVO item = offerDAO.showPrjDetail(vo);
			request.setAttribute("projectVO", item);
			System.out.println(item);
		} else {
			return "offerLogin";
		}
		return "projectDetail";
	}
	

	@Override
	public String insertProject(ProjectVO vo, String jobs,HttpSession session) {
		
		OfferVO offerVO = (OfferVO) session.getAttribute("loginInfo");
		vo.setOfferId(offerVO.getOfferId());
		int insertProjectResult = offerDAO.insertProject(vo);
		if(insertProjectResult > 0) {
			
			int pay = 0;
			Gson gson = new Gson();
			JobVO[] items = gson.fromJson(jobs, JobVO[].class);
			for(int i = 0 ; i < items.length ; i ++ ) {
				pay += items[i].getPay();
			}
			List<JobVO> list = new ArrayList<JobVO>(Arrays.asList(items));
			int insertJobsResult = offerDAO.insertJobs(list);
			if(insertJobsResult > 0 ) {
				offerVO.setOfferCash(pay);
				int subOfferCash = offerDAO.subOfferCash(offerVO);
				if(subOfferCash > 0) {
					//�꽦怨�
					return "�봽濡쒖젥�듃瑜� �꽦怨듭쟻�쑝濡� �벑濡앺븯���뒿�땲�떎";
				}
			}else {
				//insert job �떎�뙣
				return "吏곴뎔 �젙蹂대�� 異붽��븯�뒗�뜲 �떎�뙣�뻽�뒿�땲�떎";
			}
		}
		return "�봽濡쒖젥�듃 �벑濡앹뿉 �떎�뙣�븯���뒿�땲�떎";
	}

	
	public List<JobVO> seekerList(ProjectVO projectVO) {
		ProjectVO offerId = null;
		return offerDAO.seekerList(offerId);
	}


	@Override
	public List<OfferWorkVO> requestOfferProjectList(String offerId) {
		return offerDAO.requestOfferProjectList(offerId);
	}

	@Override
	public OfferWorkVO getProjectCommuteInfo(String projectNumber) {
		return offerDAO.getProjectCommuteInfo(projectNumber);
	}

	@Override
	public CommuteInfoVO requestProjectCommuteInfo(String projectNumber) {
		//모집률, 출석률, 기간 정보
		OfferWorkVO offerWorkVO = offerDAO.getProjectCommuteInfo(projectNumber);
		List<JobVO> jobList = offerDAO.getJobNumberList(projectNumber);
		Map<Integer,List<JobCandidateVO>> candidateMap = new HashMap<Integer, List<JobCandidateVO>>();
		for(JobVO item : jobList) {
			List<JobCandidateVO> items = offerDAO.getCommuteListByJobNumber(item.getJobNumber());
			candidateMap.put(item.getJobNumber(), items);
		}
		CommuteInfoVO vo = new CommuteInfoVO();
		vo.setOfferWorkVO(offerWorkVO);
		vo.setJobList(jobList);
		vo.setCandidateMap(candidateMap);
		
		return vo;
	}

	@Override
	public int requestAbsentByCandidateNumber(JobCandidateVO vo) {
		return offerDAO.requestAbsentByCandidateNumber(vo);
	}

	@Override
	public int requestWorkingByCandidateNumber(JobCandidateVO vo) {
		return offerDAO.requestWorkingByCandidateNumber(vo);
	}

	@Override
	public int requestOffWorkByCandidateNumber(JobCandidateVO vo) {
		return offerDAO.requestOffWorkByCandidateNumber(vo);
	}

	@Override
	public int requestEvaluate(JobCandidateVO vo) {
		return offerDAO.requestEvaluate(vo);
	}

	@Override
	public SeekerDetailVO requestSeekerDetail(SeekerVO vo) {
		SeekerVO seekerVO = offerDAO.requestSeekerDetail(vo);
		List<JobCandidateVO> record = offerDAO.requestSeekerRecord(vo);
		List<CertificationVO> certificate = offerDAO.requestSeekerCertificate(vo);
		SeekerDetailVO item = new SeekerDetailVO();
		item.setSeekerVO(seekerVO);
		item.setRecord(record);
		item.setCertificate(certificate);
		return item;
	}

	@Override
	public int allAbsent(ProjectVO vo) {
		return offerDAO.allAbsent(vo);
	}

	@Override
	public int allWorking(ProjectVO vo) {
		return offerDAO.allWorking(vo);
	}

	@Override
	public int allOffWork(ProjectVO vo) {
		return offerDAO.allOffWork(vo);
	}

	@Override
	public List<ProjectVO> requestOfferManageProjectList(OfferVO vo) {
		return offerDAO.requestOfferManageProjectList(vo);
	}

	@Override
	public ProjectDetailVO requestManageProjectDetailInfo(ProjectVO vo) {
		ProjectVO projectVO = offerDAO.requestManageProjectDetailInfo(vo);
		List<JobVO> jobList = offerDAO.requestOffJobListByProjectNumber(vo);
		ProjectDetailVO item = new ProjectDetailVO();
		item.setProjectVO(projectVO);
		item.setJobList(jobList);
		return item;
	}

	@Override
	public CandidateMapResponseModel requestCandidateListByJobNumber(JobCandidateVO vo) {
		HashMap<String,List<JobCandidateVO>> jobCandidateList = new HashMap<String, List<JobCandidateVO>>();
		//해당 jobNumber 로 targetDate 리스트 가져오기
		List<JobCandidateVO> targetDateList = offerDAO.getTargetDateListByJobNumber(vo);
		System.out.println("getDateList : " + targetDateList.toString());
		//하나의 targetDate 마다 candidateList 를 가져오고 hashMap 에 담기
		//Distinct 처리가 되어 있지 않으므로 같은 targetDate 의 seeker 정보가 많다. 해당 각 seekerId 를 이용하여
		//각각 seeker의 신뢰도를 포함한 정보를 가져온다
		List<JobCandidateVO> candidateList = new ArrayList<JobCandidateVO>();
		for(JobCandidateVO targetDate : targetDateList) {
			JobCandidateVO candidate = offerDAO.getCandidateListByCandidateVO(targetDate);
			//같은 targetDate 의 값이 있을 때, 
			if(jobCandidateList.get(targetDate.getTargetDate()) != null) {
				candidateList = jobCandidateList.get(targetDate.getTargetDate());
				candidateList.add(candidate);
			} else {
				candidateList = new ArrayList<JobCandidateVO>();
				candidateList.add(candidate);
			}
			jobCandidateList.put(targetDate.getTargetDate(), candidateList);
		}
		
		CandidateMapResponseModel responseModel = new CandidateMapResponseModel();
		responseModel.setResult(jobCandidateList);
		responseModel.setTargetDateList(targetDateList);
		return responseModel;
	}

	@Override
	public int requestAcceptCandidateByCandidateNumber(JobCandidateVO vo) {
		return offerDAO.requestAcceptCandidateByCandidateNumber(vo);
	}

	@Override
	public int requestRefuseCandidateByCandidateNumber(JobCandidateVO vo) {
		return offerDAO.requestRefuseCandidateByCandidateNumber(vo);
	}

	@Override
	public List<JobCandidateVO> requestProjectRecruitInfo(ProjectVO vo) {
		return offerDAO.requestProjectRecruitInfo(vo);
	}

	@Override
	public HumanResRsponseModel requestTargetDateRecruitInfo(ManageHumanResourceModel vo) {
		List<JobCandidateVO> jobNumberList = offerDAO.requestTargetDateJobNumber(vo);
		HashMap<Integer,List<ManageHumanResourceModel>> recruitMap = new HashMap<Integer, List<ManageHumanResourceModel>>();
		for(JobCandidateVO item : jobNumberList) {
			List<ManageHumanResourceModel> recruitList = offerDAO.requestRecruitListByJobNumAndTargetDate(item);
			recruitMap.put(item.getJobNumber(), recruitList);
		}
		HumanResRsponseModel model = new HumanResRsponseModel();
		model.setJobNumberList(jobNumberList);
		model.setRecruitMap(recruitMap);
		return model;
	}
	
	@Override
	public int updateOffer(String offerVO, HttpServletRequest request) {
		Gson gson = new Gson();
		OfferVO item = gson.fromJson(offerVO, OfferVO.class);
		return offerDAO.updateOffer(item);
	}

	@Override
	public int updateOfferSign(MultipartFile offerSign, String offer,HttpServletRequest request) {
		try {
			Gson gson = new Gson();
			OfferVO offerVO = gson.fromJson(offer, OfferVO.class);
			String updateOfferPath = Util.getUplodaPath(offerSign, request, offerVO.getCompanyName());
			offerVO.setOfferSign(updateOfferPath);
			return offerDAO.updateOfferSign(offerVO);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public OfferVO requestOfferDetail(OfferVO offerVO) {
		return offerDAO.requestOfferDetail(offerVO);
	}
	
}
