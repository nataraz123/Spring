package com.nt.beans;

import java.util.Date;

public class Student {
	private int sno;
	private String sname;
	private String sadd;
	private Course course;
	private  Date  dob;
	
	public void setSno(int sno) {
		this.sno = sno;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public void setSadd(String sadd) {
		this.sadd = sadd;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	
	public void setDob(Date dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "Student [sno=" + sno + ", sname=" + sname + ", sadd=" + sadd + ", course=" + course + ", dob=" + dob
				+ "]";
	}
	
	
	
	

}
