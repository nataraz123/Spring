package com.nt.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component("vehicle")
@Component
/*@PropertySources(value= {@PropertySource(value = "com/nt/commons/info.properties"),
		                                       @PropertySource(value = "com/nt/commons/info1.properties")
                                              }
                                )  up to spring 3*/

 //from spring 4
/*@PropertySource(value = "com/nt/commons/info.properties")
@PropertySource(value = "com/nt/commons/info1.properties")*/
@PropertySource(value = {"com/nt/commons/info1.properties","com/nt/commons/info.properties"})
@Scope("singleton")
public class Vechicle {
	@Value("${vehicle.type}")
	private String  type;
	@Autowired
	private Engine engg;
	
	public  void jounery(String startPlace, String endPlace) {
		System.out.println("Vechicle.jounery():::: Jounery stated from "+startPlace);
		engg.start();
		System.out.println("Vechicle:: Journey going on....... in vechile of type::"+type);
		engg.stop();
		System.out.println("Vechicle.jounery():::: Jounery ended at"+endPlace);
		
	}
	
	

}
