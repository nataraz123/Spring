package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TileOperationsController {
	
	@RequestMapping("/welcome.htm")
	public  String showHome() {
		return "page1Def";
	}
	
	@RequestMapping("/courses.htm")
	public  String showCourses() {
		return "page2Def";
	}
	
	@RequestMapping("/faculties.htm")
	public  String showFaculties() {
		return "page3Def";
	}
	
	@RequestMapping("/projects.htm")
	public  String showProjects() {
		return "page4Def";
	}




}
