package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.command.PatientCommand;

@Controller
public class PatientOperationsController {
	
	@RequestMapping("/register.htm")
	public  String showForm(@ModelAttribute("patCmd") PatientCommand cmd) {
		return "patient_register";
	}

}
