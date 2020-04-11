package com.nt.controller;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class WishMessageGeneratorController extends AbstractController {

	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest req	, HttpServletResponse res) throws Exception {
		 Calendar calendar=null;
		 int hour=0;
		 String msg=null;
		// get System data
		 calendar=Calendar.getInstance();
		//get current hour of the day
		 hour=calendar.get(Calendar.HOUR_OF_DAY);
		 if(hour<12)
			 msg="Good Morning";
		 else if(hour<16)
			  msg="Good AfterNoon";
		 else if(hour<20)
			 msg="Good Evening";
		 else
			 msg="Good Night";
			 
		
		return new ModelAndView("result","resMsg",msg);
	}

}
