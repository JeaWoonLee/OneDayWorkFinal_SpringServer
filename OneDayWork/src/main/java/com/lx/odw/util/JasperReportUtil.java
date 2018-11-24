package com.lx.odw.util;

import java.util.List;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class JasperReportUtil extends Exception{
	
	private static final long serialVersionUID = 1L;
	public static ModelAndView render(String templateId, List<Map<String, Object>> list, String fmt) {
	         JRBeanCollectionDataSource src = new JRBeanCollectionDataSource(list);
	         ModelAndView mv = new ModelAndView();
	         mv.setViewName(templateId);      //​ multiformat-view
	         mv.addObject("format", fmt);        //pdf
	         mv.addObject("datasource", src);  
	         //​list DataSource -> “datasource”는 jasperreport-views.properties 파일의 
	         //multiformat-view.reportDataKey의 이름과 일치해야한다.
	         return mv;
	       }
}
