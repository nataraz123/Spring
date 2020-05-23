package com.nt.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.command.PagingCommand;
import com.nt.dto.EmployeeDTO;
import com.nt.service.EmployeeMgmtService;

@Controller
public class PaginationController {
	@Autowired
	private EmployeeMgmtService  service;
	
	@GetMapping("/page.htm")   //intial phase request
	public  String  showHome(@ModelAttribute("pageCmd")PagingCommand cmd,HttpServletRequest req) {
		HttpSession ses=null;
		cmd.setPagesize(3);
		//get Acesss to session
		ses=req.getSession(true);
		ses.removeAttribute("pageSize");
		//return lvn
		return "page_form";
	}
	
	@RequestMapping("/report.htm")
	public    String   showReport(Map<String,Object> map,
			                                                @ModelAttribute("pageCmd")PagingCommand cmd,
			                                                HttpServletRequest req)throws Exception{
		int pageSize=0;
		HttpSession ses=null;
		int pageNo=0;
		int pagesCount=0;
		List<EmployeeDTO> listDTO=null;
		//get Session object
		ses=req.getSession(true);
		//get PageSize
		if(ses.getAttribute("pageSize")!=null)
			pageSize=(int) ses.getAttribute("pageSize");
		else {
		pageSize=cmd.getPagesize();
		ses.setAttribute("pageSize",pageSize);
		}
		//get PageNo
		pageNo=Integer.parseInt(req.getParameter("pageNo"))-1;		
		//use service
		pagesCount=service.getPagesCount(pageSize);
		listDTO=service.getPageData(pageNo, pageSize);
		//keep results in model attribte
		map.put("pagesCount",pagesCount);
		map.put("listDTO",listDTO);
		//return lvn
		return "show_report";
		
	}
	
	

}
