package com.nt.beans;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

@Named("pEngine")

public class PetrolEngine implements Engine {
	@Value("${engine.petrol.id}")
	private String engineId;
	
	public PetrolEngine() {
		System.out.println("PetrolEngine:: 0-param consrtuctor");
	}

	@Override
	public void start() {
		System.out.println("PetrolEngine.start()::: Petrol Engine started  with Id::"+engineId);

	}

	@Override
	public void stop() {
		System.out.println("PetrolEngine.stop()::: Petrol Engine stopped");

	}

}
