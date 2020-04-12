package com.nt.service;

import java.util.Calendar;

public class WishSeviceImpl implements WishService {

	@Override
	public String generateWishMsg() {
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
		 return msg;
	}

}
