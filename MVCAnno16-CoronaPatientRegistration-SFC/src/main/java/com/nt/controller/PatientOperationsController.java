package com.nt.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.command.PatientCommand;
import com.nt.dto.PatientDTO;
import com.nt.service.PatientMgmtService;

@Controller
public class PatientOperationsController {
	@Autowired
	private PatientMgmtService service;
	
	@GetMapping("/corona.htm")   //for Initial Phase request
	public  String  showForm(@ModelAttribute("patCmd") PatientCommand cmd ) {
		cmd.setLocation("hyd");  cmd.setHospital("Gandhi Hospital");
		//return LVN
		return "patient_registration";
	}
	
	@PostMapping("/corona.htm")
	public String  processForm(Map<String,Object> map,
			                                              @ModelAttribute("patCmd") PatientCommand cmd,
			                                              BindingResult br) {
		PatientDTO  dto=null;
		String result=null;
		//convert cmd to  dto
		dto=new PatientDTO();
		BeanUtils.copyProperties(cmd, dto);
		//use service
		result=service.register(dto);
		//keep result in model attribute
		map.put("resMsg", result);
		//return LVN
		return "show_result";
		
	}

}
