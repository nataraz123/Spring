package com.nt.command;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

public class PatientCommand {
	@NotEmpty(message = "patient name is required(d)")
	private String patName;
	@NotNull(message = "patient age is required(d)")
	@Range(min = 1 ,max = 100,message = "patient age must be 1 through 100 (d)")
	private Integer age;
	@NotEmpty(message = "patient location is required(d)")
	private String location;
	@NotEmpty(message = "patient hosptial is required(d)")
	@Length(min = 3,max=12,message = "patient hospital name must have min of 3 chars and max 12 chars(d)")
	private String hospital;
	
	private String vflag="no";
	
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

	public String getVflag() {
		return vflag;
	}

	public void setVflag(String vflag) {
		this.vflag = vflag;
	}

}
