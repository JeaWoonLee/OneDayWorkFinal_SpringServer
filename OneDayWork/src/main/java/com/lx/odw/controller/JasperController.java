package com.lx.odw.controller;

import java.io.OutputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lx.odw.service.OfferService;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

@Controller
public class JasperController {

	 private static final long serialVersionUID = 1L;
	 private String DOWNLOAD_FILE_NAME = "REPORT.pdf";
	 private String FILE_TYPE = "application/pdf";
	 
	 @Autowired
	 DataSource dataSource;
	@Autowired
	OfferService service;
	
	@RequestMapping(value="report.do",method=RequestMethod.GET)
	public void report(String candidateNumber, HttpServletRequest req, HttpServletResponse res) throws Exception{
		System.out.println("candidateNumber"+candidateNumber);
		JasperReport jasperReport;
		JasperDesign jasperDesign;
	    JRDataSource reportSource;
//	    jasperData jasperData;
	    Map reportParameters;
		String reportPath;	
		OutputStream outStream;
		reportPath = req.getSession().getServletContext().getRealPath("resources/report/") + "/sigened_contract.jrxml";
		jasperDesign = JRXmlLoader.load(reportPath);
		jasperReport = JasperCompileManager.compileReport(jasperDesign);
		reportParameters = new HashMap<String, Object>();
		reportParameters.put("candidateNumber", candidateNumber);
		Connection conn = dataSource.getConnection();
		byte[] byteStream;
	      byteStream = JasperRunManager.runReportToPdf(jasperReport,
	          reportParameters, conn);
	      outStream = res.getOutputStream();
	      res.setHeader("Content-Disposition", "inline; filename=\"" + DOWNLOAD_FILE_NAME+"\"");
	      res.setContentType(FILE_TYPE);
	      res.setContentLength(byteStream.length);
	      outStream.write(byteStream, 0, byteStream.length);
	      outStream.flush();
	      outStream.close();
	      conn.close();
	      System.out.println("reportReturn");
	}
	
	@RequestMapping(value="unsignedContract.do",method=RequestMethod.GET)
	public void unsignedContract(String candidateNumber, HttpServletRequest req, HttpServletResponse res) throws Exception{
		System.out.println("candidateNumber"+candidateNumber);
		JasperReport jasperReport;
		JasperDesign jasperDesign;
	    JRDataSource reportSource;
//	    jasperData jasperData;
	    Map reportParameters;
		String reportPath;	
		OutputStream outStream;
		reportPath = req.getSession().getServletContext().getRealPath("resources/report/") + "/unsigened_contract.jrxml";
		jasperDesign = JRXmlLoader.load(reportPath);
		jasperReport = JasperCompileManager.compileReport(jasperDesign);
		reportParameters = new HashMap<String, Object>();
		reportParameters.put("candidateNumber", candidateNumber);
		Connection conn = dataSource.getConnection();
		byte[] byteStream;
	      byteStream = JasperRunManager.runReportToPdf(jasperReport,
	          reportParameters, conn);
	      outStream = res.getOutputStream();
	      res.setHeader("Content-Disposition", "inline; filename=\"" + DOWNLOAD_FILE_NAME+"\"");
	      res.setContentType(FILE_TYPE);
	      res.setContentLength(byteStream.length);
	      outStream.write(byteStream, 0, byteStream.length);
	      outStream.flush();
	      outStream.close();
	      conn.close();
	      System.out.println("reportReturn");

	}
	
}
