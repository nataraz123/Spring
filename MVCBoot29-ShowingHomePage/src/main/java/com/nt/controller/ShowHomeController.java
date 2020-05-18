package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShowHomeController {
	
	@RequestMapping("/welcome.htm")
	public   String showHome() {
		return "home";
	}

}
