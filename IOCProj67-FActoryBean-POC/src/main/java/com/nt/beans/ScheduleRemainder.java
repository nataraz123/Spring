package com.nt.beans;

import java.util.Date;

public class ScheduleRemainder {
	private Date  date;

	public ScheduleRemainder(Date date) {
		System.out.println("ScheduleRemainder: 1-param consructor");
			this.date = date;
	}
	
	public String remainderOfTheDay() {
		Date sysDate=null;
		sysDate=new Date();
		if(sysDate.getYear()==date.getYear() && sysDate.getMonth()==date.getMonth() && sysDate.getDate()==date.getDate())
			return "U have an appoinment today ... call the manager for the details";
		else
			return "U do not have any appoinments today ... just relax and chill";
			
	}

}
