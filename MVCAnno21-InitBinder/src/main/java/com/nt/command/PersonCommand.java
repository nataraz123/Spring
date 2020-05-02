package com.nt.command;

import java.util.Arrays;
import java.util.Date;

public class PersonCommand {
	private String name;
	private  int age;
	private  String gender="female";
	private  String hobies[]= {"watchingTV","meditation"};
	private  String courses[]= {"java","oracle"};
	private  String qlfy="MCA";
	private  Date  dob,doj,dom;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String[] getHobies() {
		return hobies;
	}
	public void setHobies(String[] hobies) {
		this.hobies = hobies;
	}
	public String[] getCourses() {
		return courses;
	}
	public void setCourses(String[] courses) {
		this.courses = courses;
	}
	public String getQlfy() {
		return qlfy;
	}
	public void setQlfy(String qlfy) {
		this.qlfy = qlfy;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public Date getDom() {
		return dom;
	}
	public void setDom(Date dom) {
		this.dom = dom;
	}
	
	@Override
	public String toString() {
		return "PersonCommand [name=" + name + ", age=" + age + ", gender=" + gender + ", hobies="
				+ Arrays.toString(hobies) + ", courses=" + Arrays.toString(courses) + ", qlfy=" + qlfy + ", dob=" + dob
				+ ", doj=" + doj + ", dom=" + dom + "]";
	}
	
	
	
	

}
