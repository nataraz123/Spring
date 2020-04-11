package com.nt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.nt.dto.EmployeeDTO;
import com.nt.service.EmployeeMgmtService;

public class ListEmployeesController extends AbstractController {
	private EmployeeMgmtService  service;

	public ListEmployeesController(EmployeeMgmtService service) {
	
		this.service = service;
	}

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<EmployeeDTO> listDTO=null;
		//use service
		listDTO=service.fetchAllEmps();
		//return MAV
				return new ModelAndView("show_emps","listDTO",listDTO);
	}

}
