package com.nt.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.service.WishMessageService;

@Controller
public class WishController {
	@Autowired
	private WishMessageService service;
	
	@RequestMapping("/home.htm")
	public  String showHome() {
		return "welcome";
	}
	
	/*@RequestMapping("/wish.htm")
	public  ModelAndView   process() {
		String msg=null;
		//use service
		msg=service.getWishMessage();
		//return MAV object
		return new ModelAndView("result","wMsg",msg);
	}*/
	
	/*@RequestMapping("/wish.htm")
	public  String  process(Model model) {
		 String msg=null;
	   //use service
		msg=service.getWishMessage();
		model.addAttribute("wMsg", msg);
		return "result";
	
	}*/
	
	/*@RequestMapping("/wish.htm")
	public  String  process(ModelMap model) {
		 String msg=null;
	   //use service
		msg=service.getWishMessage();
		model.addAttribute("wMsg", msg);
		return "result";
	
	}*/
	
	
	
	@RequestMapping("/wish.htm")  //best signature
	public  String  process(Map<String,Object> map) {
		 String msg=null;
	   //use service
		msg=service.getWishMessage();
		//put model data
		 map.put("wMsg",msg);
		 //return lvn
		return "result";
	
	}
	
	
	/*@RequestMapping("/wish.htm")
	public  void  process(Map<String,Object> map) {
		 String msg=null;
	   //use service
		msg=service.getWishMessage();
		//put model data
		 map.put("wMsg",msg);
		
	
	}*/
	
	
	/*@RequestMapping("/wish.htm")
	public  ModelMap process() {
		 String msg=null;
	    ModelMap model=null;
		 //use service
		msg=service.getWishMessage();
		//put model data
		model=new ModelMap();
		model.addAttribute("wMsg", msg);
		return model;
		
	}*/
	
	
	/*@RequestMapping("/wish.htm")
	public Map<String,Object> process() {
		 String msg=null;
	   Map<String,Object> map=null;
		 //use service
		msg=service.getWishMessage();
		//put model data
		map=new HashMap();
		map.put("wMsg", msg);
		return map;
		
	}*/
	

}
