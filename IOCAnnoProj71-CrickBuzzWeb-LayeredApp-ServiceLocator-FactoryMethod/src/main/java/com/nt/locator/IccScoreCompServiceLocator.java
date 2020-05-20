package com.nt.locator;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import com.nt.external.ExternalICCScoreCompImpl;
import com.nt.external.ExternalIccScoreComp;

//@Component("locator")
public class IccScoreCompServiceLocator {

	
	public static ExternalIccScoreComp getInstance() {
		ExternalIccScoreComp extComp=null;
		//Actually here we should written jndi lookup code.. Since we have Extenal comp as
		// ordinary java class.. we are going create and return object manually
		extComp=new ExternalICCScoreCompImpl();
		return extComp;
	}

	

}
