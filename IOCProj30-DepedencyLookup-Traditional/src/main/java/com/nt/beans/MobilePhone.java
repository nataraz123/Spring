package com.nt.beans;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

public class MobilePhone {
	private  String beanId;
	
	public void setBeanId(String beanId) {
		System.out.println("MobilePhone.setBeandId()");
		this.beanId = beanId;
	}

	public MobilePhone() {
		System.out.println("MobilePhone.MobilePhone()");
	}
	
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
	 XmlBeanDefinitionReader reader=null;
	 MobilePhoneBatteryCharger charger=null;
	 DefaultListableBeanFactory factory=null;
	 System.out.println("MobilePhone.batteryCharging()");
	 //create an extra IOC container
	 System.out.println("2nd IOC container");
	 factory=new DefaultListableBeanFactory();
	 reader=new XmlBeanDefinitionReader(factory);
	 reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
	 //get Depedent Bean class object
	 charger=factory.getBean(beanId,MobilePhoneBatteryCharger.class);
	 //invoke method
	 charger.charging();
	 
 }

}
