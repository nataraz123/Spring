package com.nt.beans;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wmg")
public class WishMessageGenerator {
	@Autowired
	private Calendar calendar;
	
   public WishMessageGenerator() {
	System.out.println("WishMessageGeneator :: 0-param constructor");
}
   
   public   String generateWishMessage(String user) {
	   System.out.println("WishMessageGenerator.generateWishMessage()");
	   int hour=0;
	   hour=calendar.get(Calendar.HOUR_OF_DAY);
	   if(hour<12)
		   return "Good Morning::"+user;
	   else if(hour<16)
		   return "Good AfterNoon::"+user;
	   else if(hour<20)
		   return "Good Evening :;"+user;
	   else 
		   return "Good Night ::"+user;
   }
	
	

}
