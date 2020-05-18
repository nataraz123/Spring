package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.service.WishMessageService;

@Controller
public class WishMessageController {
	
	@Autowired
	private WishMessageService service;
	
	public WishMessageController() {
		System.out.println("WishMessageController:: 0-param constructor");
		}
	
	
	@RequestMapping("/home.htm")
	public  String showHome() {
		System.out.println("WishMessageController.showHome()");
		return "welcome";
		
	}
	
	@RequestMapping("/wish.htm")
	public  String showMessage(Map<String,Object> map) {
		System.out.println("WishMessageController.showMessage()");
		String msg=null;
		//use service
		msg=service.getWishMessage();
		//keep result in model attribute
		map.put("resMsg",msg);
		//return lvn
		return "result";
		
	}

}
