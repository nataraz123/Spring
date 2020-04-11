package com.nt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class ShowHomeController2 extends AbstractController {

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest req	, HttpServletResponse res) throws Exception {
		
		return new ModelAndView("welcome2");
	}

}
