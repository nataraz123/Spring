package com.nt.command;

import org.springframework.web.multipart.MultipartFile;

public class UploadCommand {
	private String ename;
	private  String eadd;
	private  MultipartFile  ephoto;
	private  MultipartFile eresume;
	
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEadd() {
		return eadd;
	}
	public void setEadd(String eadd) {
		this.eadd = eadd;
	}
	public MultipartFile getEphoto() {
		return ephoto;
	}
	public void setEphoto(MultipartFile ephoto) {
		this.ephoto = ephoto;
	}
	public MultipartFile getEresume() {
		return eresume;
	}
	public void setEresume(MultipartFile eresume) {
		this.eresume = eresume;
	}
	

}
