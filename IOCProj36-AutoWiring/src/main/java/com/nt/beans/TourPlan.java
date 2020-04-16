package com.nt.beans;

import java.util.Arrays;

public class TourPlan {
	private String [] places;
	
	
	public TourPlan() {
		System.out.println("TourPlan: 0-param constructor");
	}

	public void setPlaces(String[] places) {
		System.out.println("TourPlan.setPlaces(-)");
		this.places = places;
	}

	public String[] getPlaces() {
		return places;
	}

	@Override
	public String toString() {
		return "TourPlan [places=" + Arrays.toString(places) + "]";
	}
	
	

}
