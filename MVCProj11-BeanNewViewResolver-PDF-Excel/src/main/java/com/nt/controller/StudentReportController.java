package com.nt.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.nt.dto.StudentDTO;

public class StudentReportController extends AbstractController {

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		List<StudentDTO> listDTO=null;
		StudentDTO dto1=null,dto2=null,dto3=null;
		
		//create List Collection
		listDTO=new ArrayList();
		dto1=new StudentDTO();
		dto1.setSno(101); dto1.setSname("raja"); dto1.setSadd("hyd"); dto1.setCourse("java"); dto1.setAvg(90.55f);
		dto2=new StudentDTO();
		dto2.setSno(102); dto2.setSname("karan"); dto2.setSadd("vizag"); dto2.setCourse("java"); dto2.setAvg(91.55f);
		dto3=new StudentDTO();
		dto3.setSno(103); dto3.setSname("suresh"); dto3.setSadd("delhi"); dto3.setCourse("UI"); dto3.setAvg(92.55f);
		listDTO.add(dto1); listDTO.add(dto2); listDTO.add(dto3);
		//return MAV object
		if(req.getParameter("type").equalsIgnoreCase("excel")) 
			return  new ModelAndView("excelView", "listDTO",listDTO);
		else
			return  new ModelAndView("pdfView", "listDTO",listDTO);
	
	}

}
