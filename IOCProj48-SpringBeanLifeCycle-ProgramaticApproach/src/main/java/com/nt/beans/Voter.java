package com.nt.beans;

import java.util.Date;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Voter implements InitializingBean,DisposableBean{
	private String name;
	private  int  age;
	private String addrs;
	private  Date dov;
	
	public Voter() {
		System.out.println("Voter:: 0-param constructor");
	}
	
	public void setName(String name) {
		System.out.println("Voter.setName()");
		this.name = name;
	}
	public void setAge(int age) {
		System.out.println("Voter.setAge()");
		this.age = age;
	}
	public void setAddrs(String addrs) {
		System.out.println("Voter.setAddrs()");
		this.addrs = addrs;
	}
	
	public  String  checkVotingElgibility() {
		System.out.println("Voter.checkVotingElgibility()---B.method");
		if(age<18)
			return "Mr/Miss/Mrs. "+name+" u r not elgible for voting";
		else
			return "Mr/Miss/Mrs. "+name+" u r elgible for voting";
			
	}

	@Override
	public String toString() {
		return "Voter [name=" + name + ", age=" + age + ", addrs=" + addrs + ", dov=" + dov + "]";
	}
	
	
	//Custom Init method
	public  void  myInit(){
		System.out.println("Voter.myInit()");
		//bean processing 
		 if(age<0)
			 age=age*-1;
		 
		//verifying bean properties....
		if(name==null || age<2)
			throw new IllegalArgumentException("Invalid age,name values ");
		
		//initialize left over properites
		  dov=new Date();
		  
		  
	}
	
	//custom destroy method
	public void myDestroy() {
		System.out.println("Voter.myDestroy()");
		name=null;
		age=0;
		dov=null;
		addrs=null;
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Voter.destroy()");
		name=null;
		age=0;
		dov=null;
		addrs=null;
			
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Voter.afterPropertiesSet()");
		//bean processing 
		 if(age<0)
			 age=age*-1;
		 
		//verifying bean properties....
		if(name==null || age<2)
			throw new IllegalArgumentException("Invalid age,name values ");
		
		//initialize left over properites
		  dov=new Date();
		
	}
	

}
