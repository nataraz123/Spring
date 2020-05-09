package com.nt.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MobilePhone {
	private  String beanId;
	
	public void setBeanId(String beanId) {
		System.out.println("MobilePhone.setBeandId()");
		this.beanId = beanId;
	}

	public MobilePhone() {
		System.out.println("MobilePhone::0--param constructor");
	}
	
	
	//b.methods
 public   void gaming() {
	 System.out.println("MobilePhone.gaming()::: PubG,Ludo and etc..");
 }
 
 public void  shopping() {
	 System.out.println("MobilePhone.shopping()::: Amazon, Flipkart and etc..");
 }
 
 public  void entertainment() {
	 System.out.println("MobilePhone.entertainment():: Prime Vedio, netflix and etc..");
 }
 
 public  void calls() {
	 System.out.println("MobilePhone.calls():: Incoming and outgoing calls");
 }
 
 public void batteryCharging() {
	  ApplicationContext ctx=null;
	 MobilePhoneBatteryCharger charger=null;
	
	 System.out.println("MobilePhone.batteryCharging()");
	 //create an extra IOC container
	 System.out.println("2nd IOC container");
	   ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
	 //get Depedent Bean class object
	 charger=ctx.getBean(beanId,MobilePhoneBatteryCharger.class);
	 //invoke method
	 charger.charging();
	 
 }

}
