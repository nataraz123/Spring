package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.command.EmployeeCommand;
import com.nt.dto.EmployeeDTO;
import com.nt.service.EmployeeMgmtService;

@Controller
public class ListEmployeesController  {
	
	@Autowired
	private EmployeeMgmtService  service;
	
	@RequestMapping("/welcome.htm")
	public  String showHome() {
		return "home";
	}


	@RequestMapping("/list_emps.htm")
	public  String showEmps(Map<String,Object> map) {
				List<EmployeeDTO> listDTO=null;
		//use service
		listDTO=service.fetchAllEmps();
		// put data in model attribute
		map.put("listDTO", listDTO);
		//return MAV
			return "show_emps";
	}
	
	
	@GetMapping("/update.htm")   // SFC --edit form launching with formbacking object operations
	public  String  showEmpUpdateForm(@RequestParam("eno") int empNo,
			                                                                   @ModelAttribute("empCmd") EmployeeCommand cmd ) {
		EmployeeDTO dto=null;
		//use service
		dto=service.fetchEmpByNo(empNo);
		//keep dTO object data to Command class obj ,So it will become dynamic initial values in the update form
		BeanUtils.copyProperties(dto, cmd);
		return "emp_update_form";
	}
	
	@PostMapping("/update.htm")  // edit form post back request proccesing
	public String   processEmpUpdateForm(Map<String,Object> map,
			                                                                       @ModelAttribute("empCmd")EmployeeCommand cmd,
			                                                                       BindingResult errors) {
		EmployeeDTO dto=null;
		String msg=null;
		List<EmployeeDTO> listDTO=null;
		//convert cmd to  dto
		dto=new EmployeeDTO();
		BeanUtils.copyProperties(cmd, dto);
		//use service
		msg=service.modifyEmpByNo(dto);
		listDTO=service.fetchAllEmps();
		//keep results in model attributes
		map.put("resMsg", msg);
		map.put("listDTO", listDTO);
		//return lvn
		return "show_emps";
	}
	
	@RequestMapping("/delete.htm")
	public   String   deleleEmployee(Map<String,Object> map,@RequestParam("eno") int no) {
		 String msg=null;
		 List<EmployeeDTO> listDTO=null;
		//use service
		 msg=service.removeEmpByNo(no);
		 listDTO=service.fetchAllEmps();
			//keep results in model attributes
			map.put("resMsg", msg);
			map.put("listDTO", listDTO);
			//return lvn
			return "show_emps";
		
		
	}

}
