package com.nt.beans;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wmg")
public class WishMessageGenerator {
	@Autowired
	private Calendar calendar;
	
	
	public WishMessageGenerator() {
		System.out.println("WishMessageGenerator::0-paaram constructor");
	}
	
	public  String  generateWishMessage(String user) {
		int hour=0;
		//get current hour of the day
		hour=calendar.get(Calendar.HOUR_OF_DAY);
		///get message
		if(hour<12)
			return "good Morning::"+user;
		else if(hour<16)
			return "good afternoon::"+user;
		else if(hour<20)
			return "Good evening::"+user;
		else
			return "Good night::"+user;
			
	}

}
