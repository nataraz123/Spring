package com.nt.command;

public class PatientCommand {
	private String patName;
	private Integer age;
	private String location;
	private String hospital;
	
	public PatientCommand() {
		System.out.println("PatientCommand:: 0-param constructor");
	}
	
	public String getPatName() {
		return patName;
	}
	public void setPatName(String patName) {
		this.patName = patName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getHospital() {
		return hospital;
	}
	public void setHospital(String hospital) {
		this.hospital = hospital;
	}

}
