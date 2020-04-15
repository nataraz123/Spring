package com.nt.dto;

import java.io.Serializable;

public class StudentDTO implements Serializable {
	private int sno;
	private String sname;
	private String sadd;
	private  float avg;
	private  String course;
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSadd() {
		return sadd;
	}
	public void setSadd(String sadd) {
		this.sadd = sadd;
	}
	public float getAvg() {
		return avg;
	}
	public void setAvg(float avg) {
		this.avg = avg;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	@Override
	public String toString() {
		return "StudentDTO [sno=" + sno + ", sname=" + sname + ", sadd=" + sadd + ", avg=" + avg + ", course=" + course
				+ "]";
	}
	
	

}
