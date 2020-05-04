package com.nt.beans;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Student {
	private int sno;
	private String sname;
	
	//@Qualifier("c1")
	//@Autowired
	private Course course;
	//@Autowired(required = false)
	//@Autowired
	private  Date  dob;
	
	
	
	@Autowired
	public Student(@Qualifier("c2") Course course, Date dob,int x) {
		System.out.println("Student::3-param constructor");
		this.course = course;
		this.dob = dob;
	}
	
	@Autowired
	public Student( Course course1, Date dob) {
		System.out.println("Student::2-param constructor");
		this.course = course1;
		this.dob = dob;
	}

	public Student() {
		System.out.println("Student.Student()");
	}
	
	public void setSno(int sno) {
		System.out.println("Student.setSno()");
		this.sno = sno;
	}
	public void setSname(String sname) {
		System.out.println("Student.setSname()");
		this.sname = sname;
	}
	
	/*@Autowired
	public void setCourse(Course course1) {
		System.out.println("Student.setCourse()");
		this.course = course1;
	}
	
	@Autowired
	public void setDob(Date dob) {
		System.out.println("Student.setDob()");
		this.dob = dob;
	}*/
	
	/*	@Autowired
		//@Qualifier("c2")
		public void assignCourse(Course course1) {
			System.out.println("Student.assignCourse()");
			this.course=course1;
		}
		
		@Autowired
		
		public void assignDob(Date dob) {
			System.out.println("Student.assignDob()");
			this.dob=dob;
		}*/

	@Override
	public String toString() {
		return "Student [sno=" + sno + ", sname=" + sname + ", course=" + course + ", dob=" + dob
				+ "]";
	}
	
	
	
	

}
