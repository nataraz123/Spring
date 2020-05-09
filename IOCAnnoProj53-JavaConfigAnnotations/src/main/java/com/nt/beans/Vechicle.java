package com.nt.beans;

import javax.annotation.Resource;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Named("vehicle")
@Scope("singleton")
//@Lazy

public class Vechicle {
	@Value("${vehicle.type}")
	private String  type;
	/*@Inject
	@Named("pEngine")*/
	@Resource(name="pEngine")
	//@Named("pEngine")
	private Engine engg;
	
	public Vechicle() {
		System.out.println("Vechicle:: 0-param constructor");
	}
	
	
	/*@Inject
	@Named("pEngine"/)
	@Resource(name="dEngine")
	public void setEngg(Engine engg) {
		this.engg=engg;
	}*/
	
	
	/*@Inject
	@Named("pEngine")*/
	/*@Resource(name="dEngine")
	public void assign(Engine engg) {
		this.engg=engg;
	}*/
	
	
	//@Inject
	//@Named("pEngine")
	//@Resource(name="dEngine")
	public Vechicle(@Named("pEngine")Engine engg) {
		this.engg=engg;
	}

	
	public  void jounery(String startPlace, String endPlace) {
		System.out.println("Vechicle.jounery():::: Jounery stated from "+startPlace);
		engg.start();
		System.out.println("Vechicle:: Journey going on....... in vechile of type::"+type);
		engg.stop();
		System.out.println("Vechicle.jounery():::: Jounery ended at"+endPlace);
		
	}
	
	

}
