package com.nt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.external.ExternalIccScoreComp;
import com.nt.service.CrickScoreMgmtService;

public class MainControllerServlet extends HttpServlet {
	private ApplicationContext ctx;
	public void init() {
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
	}
	
	@Override
	public  void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	          int mid=0;
	         CrickScoreMgmtService service=null;
	         String score=null;
	         RequestDispatcher rd=null;
		 //read match id given by hperlink as additional req param value
	          mid=Integer.parseInt(req.getParameter("mid"));
	       //get SErvice clss object   
		    service=ctx.getBean("cbService",CrickScoreMgmtService.class);
		    //use service
		    score=service.findScore(mid);
		    //keep score in request scope
		    req.setAttribute("scoreCard", score);
		    //forward to result page
		    rd=req.getRequestDispatcher("show_score.jsp");
		    rd.forward(req,res);
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
	}
	
	
	public void destroy() {
		//close container
		((AbstractApplicationContext) ctx).close();
	}

}
