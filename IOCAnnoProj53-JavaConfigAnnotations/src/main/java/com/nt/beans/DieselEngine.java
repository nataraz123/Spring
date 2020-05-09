package com.nt.beans;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

@Named("dEngine")
@Primary

public class DieselEngine implements Engine {
	@Value("${engine.diesel.id}")
	private String engineId;

	public DieselEngine() {
		System.out.println("DieselEngine::0-param constructor");
	}
	
	@Override
	public void start() {
		System.out.println("DieselEngine.start()::: Diesel Engine started with ID::"+engineId);

	}

	@Override
	public void stop() {
		System.out.println("DieselEngine.stop()::: Diesel Engine stopped");

	}

}
