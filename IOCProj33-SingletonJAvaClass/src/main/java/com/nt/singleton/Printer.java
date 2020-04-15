package com.nt.singleton;

public class Printer {
	private static Printer INSTANCE;
	
	private Printer() {
		//no op
		System.out.println("Printer:: 0-param consstructor");
		
	}
	
	//static  factory method
	public  static  Printer getInstance() {
		if(INSTANCE==null)
			INSTANCE=new Printer();
		
		return INSTANCE;
	}
	
	
	// B.method
	public   void   printMessage(String msg) {
		System.out.println(msg+" printed on paper");
	}
	
	

}
