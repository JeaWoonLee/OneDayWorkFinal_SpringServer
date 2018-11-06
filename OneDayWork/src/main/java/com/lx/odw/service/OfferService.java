package com.lx.odw.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lx.odw.vo.ProjectJobListVO;
import com.lx.odw.vo.ProjectVO;

@Service
public interface OfferService {

	List<ProjectVO> getOffList();

	List<ProjectJobListVO> requestOffJobListByProjectNumber(ProjectVO projectVO);

}
