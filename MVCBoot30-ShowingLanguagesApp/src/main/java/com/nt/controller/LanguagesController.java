package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.service.FetchLanguagesService;

@Controller
public class LanguagesController {
	
	@Autowired
	private FetchLanguagesService service;
	
	@RequestMapping("/welcome.htm")
	public  String  showHomePage() {
		return "home";
	}
	
	@RequestMapping("/lang.htm")
	public  String  getLanguages(Map<String,Object> map) {
		List<String> langList=null;
		//use service
		langList=service.fetchAllLanguages();
		// keep to map as model attribute
		map.put("langList", langList);
		//return lvn
		return "show_languages";
	}
	
	

}
