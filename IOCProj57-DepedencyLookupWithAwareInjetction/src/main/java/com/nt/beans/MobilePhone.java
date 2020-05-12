package com.nt.beans;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MobilePhone  implements ApplicationContextAware {
	private  String beanId;
	private ApplicationContext ctx;
	
	public MobilePhone() {
		System.out.println("MobilePhone::0--param constructor");
	}
	
	
	public void setBeanId(String beanId) {
		System.out.println("MobilePhone.setBeandId()");
		this.beanId = beanId;
	}
	
	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
	System.out.println("MobilePhone.setApplicationContext()");
		this.ctx=ctx;
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
	
	 MobilePhoneBatteryCharger charger=null;
	
	 System.out.println("MobilePhone.batteryCharging()");
	 //get Depedent Bean class object  through Dependency lookup
	 charger=ctx.getBean(beanId,MobilePhoneBatteryCharger.class);
	 //invoke method
	 charger.charging();
	 
 }



}
