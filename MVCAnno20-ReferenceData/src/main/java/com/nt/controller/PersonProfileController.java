package com.nt.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.command.PersonCommand;
import com.nt.validator.PersonCommandValidator;

@Controller
public class PersonProfileController {
	@Autowired
	private PersonCommandValidator validator;
	
	
	@ModelAttribute("gendersList")
	public   List<String>  populateGenders(){
		System.out.println("PersonProfileController.populateGenders()");
		List<String> list=new ArrayList();
		list.add("male"); list.add("female");
		return list;
	}
	
	@ModelAttribute("hobiesList")
	public   List<String>  populateHobies(){
		System.out.println("PersonProfileController.populateHobies()");
		List<String> list=new ArrayList();
		list.add("meditation"); list.add("workout");
		list.add("watchingTV"); list.add("Travelling");
		return list;
	}
	
	@ModelAttribute("coursesList")
	public   List<String>  populateCourses(){
		System.out.println("PersonProfileController.populateCourses()");
		List<String> list=new ArrayList();
		list.add("java"); list.add(".net");
		list.add("oracle"); list.add("angularJs");
		list.add("UI"); list.add("Jquery");
		return list;
	}
	
	@ModelAttribute("qlfyList")
	public   List<String>  populateQualifications(){
		System.out.println("PersonProfileController.populateQualifications()");
		List<String> list=new ArrayList();
		list.add("B.E/B.Tech"); list.add("MBBS");
		list.add("B.sc"); list.add("BA");
		list.add("MCA"); list.add("MBA");
		return list;
	}
	
	@GetMapping("/register.htm")  // for InitialPhase request
	public   String  showForm(@ModelAttribute("perCmd") PersonCommand cmd) {
		System.out.println("PersonProfileController.showForm()");
		return "person_register";
	}
	
	@PostMapping("/register.htm")
	public  String   processForm(Map<String,Object> map,
			                                               @ModelAttribute("perCmd") PersonCommand cmd,
			                                               BindingResult errors) {
		//perform validations
		if(validator.supports(cmd.getClass())) {
			validator.validate(cmd, errors);
			if(errors.hasErrors())
				return "person_register";
		}
		 //return lvn
		map.put("cmdData", cmd);
		return "show_result";
		
	}
	
	
	

}
