package com.nt.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class ContainerPerformenceAnalyzer implements ApplicationListener {
	private long start,end;

	 public ContainerPerformenceAnalyzer() {
		System.out.println("ContainerPerformenceAnalyzer:: 0-param constructor");
	}
	
	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		if(event.toString().contains("Refreshed"))
			start=System.currentTimeMillis();
		else if(event.toString().contains("Closed")) {
			end=System.currentTimeMillis();
			System.out.println("Container is in running mode for ::"+(end-start)+"   ms");
		}
			
		

	}

}
