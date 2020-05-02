package com.nt.command;

import java.util.Arrays;

public class PersonCommand {
	private String name;
	private  int age;
	private  String gender="female";
	private  String hobies[]= {"watchingTV","meditation"};
	private  String courses[]= {"java","oracle"};
	private  String qlfy="MCA";
	
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
	@Override
	public String toString() {
		return "PersonCommand [name=" + name + ", age=" + age + ", gender=" + gender + ", hobies="
				+ Arrays.toString(hobies) + ", courses=" + Arrays.toString(courses) + ", qlfy=" + qlfy + "]";
	}
	
	

}
