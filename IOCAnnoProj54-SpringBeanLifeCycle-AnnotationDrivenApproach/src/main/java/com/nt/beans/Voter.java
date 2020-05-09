package com.nt.beans;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.NonNull;

@Named("voter")
public class Voter {
	@Value("${voter.name}")
	private String name;
	@Value("${voter.age}")
	private  int  age;
	@Value("${voter.addrs}")
	private String addrs;
	private  Date dov;
	
	public Voter() {
		System.out.println("Voter:: 0-param constructor");
	}
	
	public void setName(@NonNull String name) {
		System.out.println("Voter.setName()");
		this.name = name;
	}
	public void setAge(int age) {
		System.out.println("Voter.setAge()");
		this.age = age;
	}
	public void setAddrs(@NonNull String addrs) {
		System.out.println("Voter.setAddrs()");
		this.addrs = addrs;
	}
	
	public  @NonNull String  checkVotingElgibility() {
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
	@PostConstruct
    public  void  myInit(){
    	System.out.println("Voter.myInit()");
    	//bean processing 
    	 if(age<0)
    		 age=age*-1;
    	 
    	//verifying bean properties....
    	if(name==null || name.length()==0 || age<2)
    		throw new IllegalArgumentException("Invalid age,name values ");
    	
    	//initialize left over properites
    	  dov=new Date();
    	  
    	  
    }
	
    //custom destroy method
	@PreDestroy
    public void myDestroy() {
    	System.out.println("Voter.myDestroy()");
    	name=null;
    	age=0;
    	dov=null;
    	addrs=null;
    }
	

}
