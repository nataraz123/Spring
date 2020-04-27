package com.nt.controller;

import java.util.Map;

import javax.validation.Valid;

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
//@SessionAttributes("patCmd")
public class PatientOperationsController {
	@Autowired
	private PatientMgmtService service;

	
	@ModelAttribute("patCmd")
	public PatientCommand  getPatientCommand() {
		System.out.println("getPatientCommand()");
		return new PatientCommand();
	}
	
	@GetMapping("/corona.htm")   //for Initial Phase request
	public  String  showForm( @ModelAttribute("patCmd") PatientCommand cmd ) {
		cmd.setLocation("hyd");  cmd.setHospital("Gandhi Hospital");
		System.out.println("PatientOperationsController.showForm()");
		//return LVN
		return "patient_registration";
	}
	
	@PostMapping("/corona.htm")   //for POST back request
	public String  processForm(Map<String,Object> map,
			                                              @Valid @ModelAttribute("patCmd") PatientCommand cmd,
			                                              BindingResult br) {
		System.out.println("PatientOperationsController.processForm()");
		PatientDTO  dto=null;
		String result=null;
		
		
		if(br.hasErrors()) {
			return "patient_registration";
		}
		
		
		
		//Application logic errors
		if(cmd.getLocation().equalsIgnoreCase("hyd")) {
			  br.rejectValue("location", "hyd.blocked");
			  return  "patient_registration";
		}
		
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
