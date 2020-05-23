package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;

import com.nt.dto.EmployeeDTO;
import com.nt.service.EmployeeMgmtService;

@Controller("controller")
@Lazy
public final class MainController {
	@Autowired
	private  EmployeeMgmtService service;


	
	
	public  @NonNull List<EmployeeDTO>  fetchEmpsByDesgs(@NonNull String desg1,@NonNull String desg2)throws Exception{
		 List<EmployeeDTO> listDTO=null;
		//use service
		 listDTO=service.fetchEmpsByDesgs(desg1, desg2);
		 return listDTO;
	}
	
	

}
