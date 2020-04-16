package com.nt.beans;

public class TravelAgent {
			private TourPlan tp;
			
			public TravelAgent() {
				System.out.println("TravelAgent:: 0-param constructor");
			}
		
		public void setTp(TourPlan tp) {
			System.out.println("TravelAgent.setTp(-)");
			this.tp = tp;
		}
		
		
		public  String  tourBudgeting() {
			System.out.println("TravelAgent.tourBudgeting()");
			//get Tourplaces count
			int count=tp.getPlaces().length;
			return tp.toString()+" places having budget "+(count*5000);
			
		}
		

}
