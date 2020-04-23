package com.nt.controller;

import java.util.List;

import com.nt.dto.EmployeeDTO;
import com.nt.service.EmployeeMgmtService;

public final class MainController {
	private  EmployeeMgmtService service;

	public MainController(EmployeeMgmtService service) {
	
		this.service = service;
	
	}
	
	
	public  List<EmployeeDTO>  fetchEmpsByDesgs(String desg1,String desg2)throws Exception{
		 List<EmployeeDTO> listDTO=null;
		//use service
		 listDTO=service.fetchEmpsByDesgs(desg1, desg2);
		 return listDTO;
	}
	
	

}
