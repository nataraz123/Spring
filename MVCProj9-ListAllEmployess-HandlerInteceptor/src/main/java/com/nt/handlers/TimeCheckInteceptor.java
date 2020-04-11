package com.nt.handlers;

import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class TimeCheckInteceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler)
			throws Exception {
		Calendar cal=null;
		int hour=0;
		RequestDispatcher rd=null;
		System.out.println("TimeCheckInteceptor.preHandle()");
		//get system date and time
		cal=Calendar.getInstance();
		//get current hour of the day
		hour=cal.get(Calendar.HOUR_OF_DAY);
		//check the timing of the reques
		if(hour<10 || hour>=17) {
			rd=req.getRequestDispatcher("/timeout.jsp");
			rd.forward(req, res);
			return false;
		}
		else {
			return true;
		}
		
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		 System.out.println("TimeCheckInteceptor.postHandle()");
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("TimeCheckInteceptor.afterCompletion()");
	}

}
