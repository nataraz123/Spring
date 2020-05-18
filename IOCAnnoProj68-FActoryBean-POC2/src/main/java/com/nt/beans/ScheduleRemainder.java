package com.nt.beans;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component("remainder")
public class ScheduleRemainder {
	@Autowired
	private Date  date;

	
	
	public String remainderOfTheDay() {
		Date sysDate=null;
		sysDate=new Date();
		if(sysDate.getYear()==date.getYear() && sysDate.getMonth()==date.getMonth() && sysDate.getDate()==date.getDate())
			return "U have an appoinment today ... call the manager for the details";
		else
			return "U do not have any appoinments today ... just relax and chill";
			
	}

}
