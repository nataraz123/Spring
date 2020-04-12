package com.nt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.nt.service.WishService;

public class WishMessageGeneratorController extends AbstractController {
	private WishService service;

	public WishMessageGeneratorController(WishService service) {
	
		this.service = service;
	}

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest req	, HttpServletResponse res) throws Exception {
		String msg=null;
			 //use service
		msg=service.generateWishMsg();
		//return MAV
		return new ModelAndView("result","resMsg",msg);
	}

}
