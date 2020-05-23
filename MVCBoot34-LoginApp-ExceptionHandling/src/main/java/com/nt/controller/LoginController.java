package com.nt.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nt.command.UserCommand;
import com.nt.dto.UserDTO;
import com.nt.service.LoginMgmtService;

@Controller
public class LoginController {
	@Autowired
	private  LoginMgmtService service;
	
	
	@GetMapping("/login.htm")  //to handler initial phase request
	public   String  showForm(@ModelAttribute("userCmd") UserCommand cmd) {
		//return  lnv
		return "login_form";
	}
	
	@PostMapping("/login.htm")  //post back request..
	public   String  processForm(Map<String,Object> map,@ModelAttribute("userCmd") UserCommand cmd) {
		 UserDTO dto=null;
		 String resultMsg=null;
		// convert cmd to  dto
		 dto=new UserDTO();
		 BeanUtils.copyProperties(cmd, dto);
		//use service
		 resultMsg=service.authenticate(dto);
		 //keep result in model attribute
		 map.put("resultMsg", resultMsg);
		 //return lvn of result page
		 return "login_form";
	}
	
	/*	@ExceptionHandler(Exception.class)
		public   ModelAndView  localExceptionHandler(Exception  ex) {
			return new ModelAndView("local_error");
		}
	*/
	
		@ExceptionHandler(Exception.class)
		public  ModelAndView  localExceptionHandler(Exception  ex) {
			return new ModelAndView("local_error","problem",ex.getMessage());
		}
	
}
