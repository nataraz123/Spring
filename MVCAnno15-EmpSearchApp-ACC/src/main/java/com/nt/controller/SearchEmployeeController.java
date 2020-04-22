package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.command.EmployeeCommand;
import com.nt.dto.EmployeeDTO;
import com.nt.dto.EmployeeResultDTO;
import com.nt.service.EmployeeService;

@Controller
public class SearchEmployeeController {
	@Autowired
	private EmployeeService service;
	
	
	@RequestMapping("/welcome.htm")
	public String showHome() {
		return "search_employee";
	}
	
	@RequestMapping("/search_emps.htm")
	public  String  searchEmployees(Map<String,Object> map,
			                                                       @ModelAttribute EmployeeCommand cmd,
			                                                       BindingResult br){
			                                                       
		EmployeeDTO   dto=null;
		List<EmployeeResultDTO> listRDTO=null;
				//convert cmd to dto
		dto=new EmployeeDTO();
		BeanUtils.copyProperties(cmd,dto);
			//use service
		listRDTO=service.search(dto);
		// keep result as model attribute
		map.put("listRDTO", listRDTO);
		return "show_results";
	}
	
	

}
